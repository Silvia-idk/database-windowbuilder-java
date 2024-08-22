import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import myDatabaseClassesAndMethods.databaseConnection;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ForgottenPassword extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtYourId;
	private JTextField txtSecretCode;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgottenPassword dialog = new ForgottenPassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public forgottenPassword() {
		setBounds(100, 100, 294, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblYourId = new JLabel("Your ID");
		lblYourId.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblYourId.setBounds(10, 23, 102, 22);
		contentPanel.add(lblYourId);
		
		JLabel lblSecretCode = new JLabel("Your Secret Code");
		lblSecretCode.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblSecretCode.setBounds(10, 57, 117, 22);
		contentPanel.add(lblSecretCode);
		
		txtYourId = new JTextField();
		txtYourId.setBounds(137, 23, 131, 20);
		contentPanel.add(txtYourId);
		txtYourId.setColumns(10);
		
		txtSecretCode = new JTextField();
		txtSecretCode.setColumns(10);
		txtSecretCode.setBounds(137, 57, 131, 20);
		contentPanel.add(txtSecretCode);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblUsername.setBounds(10, 139, 258, 14);
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblPassword.setBounds(10, 164, 258, 14);
		contentPanel.add(lblPassword);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(Connection con = DatabaseConnection.getConnection()){
					String ClientId = txtYourId.getText().toLowerCase().trim();;
					String secretCode = txtSecretCode.getText().toLowerCase().trim();
						
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("SELECT * FROM database.login WHERE idClient = '");
					stringBuilder.append(ClientId);
					stringBuilder.append("' AND question = '");
					stringBuilder.append(secretCode);
					stringBuilder.append("'");
					String querySQL = stringBuilder.toString();
					PreparedStatement ps = con.prepareStatement(querySQL);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						ClientId = rs.getString(1);	
						String username = rs.getString(2);
						String password = rs.getString(3);
						lblUsername.setText("Your Username is : " + username);
						lblPassword.setText("Your Password is : " + password);
					}
					else {
						String msg = "ID and/or secret code wrong...";
						JOptionPane.showMessageDialog(btnOk, msg);
						txtYourId.setText("");
						txtSecretCode.setText("");
					}
					con.close();
					ps.close();
					rs.close();
				} 
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnOk.setBounds(10, 105, 91, 23);
		contentPanel.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtYourId.setText("");
				txtSecretCode.setText("");
				lblUsername.setText("");
				lblPassword.setText("");
			}
		});
		btnClear.setBounds(177, 105, 91, 23);
		contentPanel.add(btnClear);
	}

}
