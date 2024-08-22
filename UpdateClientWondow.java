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

public class UpdateClientWondow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtClientId;
	private JTextField txtClientName;
	private JTextField txtClientSurname;
	private JTextField txtClientMail;
	private JTextField txtPhoneNumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateClientWondow dialog = new UpdateClientWondow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public UpdateClientWondow() {
		
		setTitle("My Database_ Update Client");
		setBounds(100, 100, 330, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblClientId = new JLabel("Insert the ID of the client you want to update");
			lblClientId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
			lblClientId.setHorizontalAlignment(SwingConstants.CENTER);
			lblClientId.setBounds(10, 24, 294, 14);
			contentPanel.add(lblClientId);
		}
		{
			txtClientId = new JTextField();
			txtClientId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
			txtClientId.setBounds(41, 57, 110, 20);
			contentPanel.add(txtClientId);
			txtClientId.setColumns(10);
		}
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try (Connection con = DatabaseConnection.getConnection()){
					
					String querySQL = "SELECT * FROM database.clients WHERE idClient = ?";
					PreparedStatement ps = con.prepareStatement(querySQL);
					ps = con.prepareStatement(querySQL);
					String idClient = txtClientId.getText();
					int id = Integer.parseInt(idClient);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					JTextField[] values = {txtClientName, txtClientSurname, txtClientMail, txtPhoneNumber};
					while(rs.next()) {
						for(int i = 0; i < variables.elementsC.length; i++) {
							variables.elementsC[i] = rs.getString(i+2);	
						}
						for(int i = 0; i < values.length; i++) {
							values[i].setText(variables.elementsC[i]);
						}
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
		
		JLabel lblNewData = new JLabel("New Data");
		lblNewData.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblNewData.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewData.setBounds(0, 88, 304, 14);
		contentPanel.add(lblNewData);
		
		JLabel lblClientName = new JLabel("Client's Name");
		lblClientName.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientName.setBounds(41, 120, 109, 14);
		contentPanel.add(lblClientName);
		
		JLabel lblClientSurname = new JLabel("CLient's Surname");
		lblClientSurname.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientSurname.setBounds(41, 145, 109, 14);
		contentPanel.add(lblClientSurname);
		
		JLabel lblClientMail = new JLabel("Client's e_mail");
		lblClientMail.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientMail.setBounds(41, 170, 109, 14);
		contentPanel.add(lblClientMail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblPhoneNumber.setBounds(41, 195, 115, 14);
		contentPanel.add(lblPhoneNumber);
		
		txtClientName = new JTextField();
		txtClientName.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientName.setBounds(161, 113, 109, 20);
		contentPanel.add(txtClientName);
		txtClientName.setColumns(10);
		
		txtClientSurname = new JTextField();
		txtClientSurname.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientSurname.setBounds(161, 142, 109, 20);
		contentPanel.add(txtClientSurname);
		txtClientSurname.setColumns(10);
		
		txtClientMail = new JTextField();
		txtClientMail.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientMail.setBounds(161, 167, 109, 20);
		contentPanel.add(txtClientMail);
		txtClientMail.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtPhoneNumber.setBounds(160, 192, 110, 20);
		contentPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 314, 35);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
						DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
						DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
						String[] values = {txtClientName.getText(),txtClientSurname.getText(),
								txtClientMail.getText(),txtPhoneNumber.getText()};
						for(int i = 0; i < variables.elementsC.length; i++) {
							variables.elementsC[i] = values[i];
						}
						String data = "clientName = ?, clientSurname = ?, clientMail = ?, phoneNumber = ?";
						String idClient = txtClientId.getText();
						DatabaseMethods.mySql.UpdateInMySQL(variables.elementsC, values, variables.tableC, data,variables.idC, idClient);
						DatabaseMethods.myRefreshClients();
						DatabaseMethods.myRefreshWarehouse();
						DatabaseMethods.myRefreshDatabase();
						dispose();
					}
				});
				okButton.setBounds(140, 5, 51, 25);
				okButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtClientId.setText("");
						txtClientName.setText("");
						txtClientSurname.setText("");
						txtClientMail.setText("");
						txtPhoneNumber.setText("");
					}
				});
				cancelButton.setBounds(201, 5, 69, 25);
				cancelButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
