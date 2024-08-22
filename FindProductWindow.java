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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindProductWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtProductId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindProductWindow dialog = new FindProductWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public FindProductWindow() {
		setTitle("My Database_Find product");
		setBounds(100, 100, 248, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsertProductId = new JLabel("Insert Product's ID");
		lblInsertProductId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblInsertProductId.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertProductId.setBounds(10, 11, 210, 14);
		contentPanel.add(lblInsertProductId);
	
		JLabel lblProductId = new JLabel("Product's ID");
		lblProductId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblProductId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductId.setBounds(10, 44, 100, 14);
		contentPanel.add(lblProductId);
		
		txtProductId = new JTextField();
		txtProductId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtProductId.setBounds(120, 41, 93, 20);
		contentPanel.add(txtProductId);
		txtProductId.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(90, 80, 51, 25);
		contentPanel.add(btnOk);
		btnOk.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
				DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
				DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
				String txtPi = txtProductId.getText();
				DatabaseMethods.mySql.FindInMySQL(variables.tableW, variables.idP,txtPi, Homepage.tblWarehouse,variables.colNameP);
				DatabaseMethods.mySql.FindObjectInConnectTableInMySQL(variables.columnsD, variables.tableC, variables.tableW, variables.idC, variables.idCp, variables.idP, txtPi, Homepage.tblDatabase, variables.colNameD);
				
				try (Connection con = DatabaseConnection.getConnection()){
				String querySQL = "SELECT * FROM database.warehouse WHERE idProduct = ?";
				PreparedStatement ps = con.prepareStatement(querySQL);
				ps = con.prepareStatement(querySQL);
				int id = Integer.parseInt(txtPi);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				String[] str = new String[variables.colNameP.length]; 
				while(rs.next()) {
					for(int i = 0; i < str.length; i++) {
						str[i] = rs.getString(i+1);	
					}
				}
				String idClientP = str[str.length - 1];
				myMethods.mySql.FindInMySQL(variables.tableC, variables.idC,idClientP, Homepage.tblClient,variables.colNameC);
				} 
				catch (SQLException ex) {
					ex.printStackTrace();
				}
				dispose();
			}
		});
		btnOk.setActionCommand("OK");
		getRootPane().setDefaultButton(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(151, 80, 69, 25);
		contentPanel.add(btnCancel);
		btnCancel.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProductId.setText("");
			}
		});
		btnCancel.setActionCommand("Cancel");
	}
}
