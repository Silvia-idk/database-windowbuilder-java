import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import MainWindows.Homepage;
import myDatabaseClassesAndMethods.databaseConnection;
import myDatabaseClassesAndMethods.myMethods;
import myDatabaseClassesAndMethods.variables;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateProductWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtProductId;
	private JTextField txtProductName;
	private JTextField txtClientId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateProductWindow dialog = new UpdateProductWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public UpdateProductWindow() {
		
		setTitle("My Database_ Update Product");
		setBounds(100, 100, 330, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 228, 314, 35);
		contentPanel.add(buttonPane);
		buttonPane.setBackground(SystemColor.inactiveCaption);
		buttonPane.setLayout(null);
		
		//JLabel
		JLabel lblInsertId = new JLabel("Insert the ID of the client you want to update");
		lblInsertId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblInsertId.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertId.setBounds(10, 24, 294, 14);
		contentPanel.add(lblInsertId);
		
		JLabel lblNewData = new JLabel("New Data");
		lblNewData.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblNewData.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewData.setBounds(0, 88, 304, 14);
		contentPanel.add(lblNewData);
		
		JLabel lblProductName = new JLabel("Product's Name");
		lblProductName.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblProductName.setBounds(41, 120, 109, 14);
		contentPanel.add(lblProductName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblCategory.setBounds(41, 145, 109, 14);
		contentPanel.add(lblCategory);
		
		JLabel lblClientId = new JLabel("Client's ID");
		lblClientId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientId.setBounds(41, 170, 109, 14);
		contentPanel.add(lblClientId);
		
		//Text
		txtProductId = new JTextField();
		txtProductId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtProductId.setBounds(41, 57, 110, 20);
		contentPanel.add(txtProductId);
		txtProductId.setColumns(10);
		
		txtProductName = new JTextField();
		txtProductName.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtProductName.setBounds(161, 113, 109, 20);
		contentPanel.add(txtProductName);
		txtProductName.setColumns(10);

		JComboBox<String> cbCategory = new JComboBox<>();
		cbCategory.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		cbCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"...", "Type 1", "Type 2", "Type 3"}));
		cbCategory.setBounds(161, 140, 109, 19);
		contentPanel.add(cbCategory);
		
		txtClientId = new JTextField();
		txtClientId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientId.setBounds(161, 167, 109, 20);
		contentPanel.add(txtClientId);
		txtClientId.setColumns(10);
		
		//Buttons
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try (Connection con = DatabaseConnection.getConnection()){
					
					String querySQL = "SELECT * FROM database.warehouse WHERE idProduct = ?";
					PreparedStatement ps = con.prepareStatement(querySQL);
					ps = con.prepareStatement(querySQL);
					String idProduct = txtProductId.getText();
					int id = Integer.parseInt(idProduct);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						for(int i = 0; i < variables.elementsP.length; i++) {
							variables.elementsP[i] = rs.getString(i+2);	
						}
						txtProductName.setText(variables.elementsP[0]);
						txtClientId.setText(variables.elementsP[2]);
						
						if (variables.elementsP[1].equals("Type 1"))
							cbCategory.setSelectedIndex(1);
						else if (variables.elementsP[1].equals("Type 2"))
							cbCategory.setSelectedIndex(2);
						else if (variables.elementsP[1].equals("Type 3"))
							cbCategory.setSelectedIndex(3);
					}
				}
				catch(SQLException ex) {
					System.out.println(ex);
				}
			}
		});
		btnDone.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnDone.setBounds(161, 56, 109, 23);
		contentPanel.add(btnDone);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
				DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
				DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
				String data = "productName = ?, category = ?, idClientP = ?";
				String[] values = {txtProductName.getText(),(String)cbCategory.getSelectedItem(),
						txtClientId.getText()};
				String idProduct = txtProductId.getText();
				DatabaseMethods.mySql.UpdateInMySQL(variables.elementsP, values, variables.tableW, data, variables.idP, idProduct);
				dispose();
				DatabaseMethods.myRefreshClients();
				DatabaseMethods.myRefreshWarehouse();
				DatabaseMethods.myRefreshDatabase();
			}	
		});
		okButton.setBounds(140, 5, 51, 25);
		okButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProductId.setText("");
				txtProductName.setText("");
				cbCategory.setSelectedIndex(0);
				txtClientId.setText("");
			}
		});
		cancelButton.setBounds(201, 5, 69, 25);
		cancelButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);	
	}
}
