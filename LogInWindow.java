import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import MainWindows.Homepage;
import myDatabaseClassesAndMethods.databaseConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LogInWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdClient;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogInWindow dialog = new LogInWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public LogInWindow() {
		setTitle("My Database_Log In");
		setBounds(100, 100, 450, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblClientId = new JLabel("Your ID");
		lblClientId.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblClientId.setBounds(224, 34, 71, 14);
		contentPanel.add(lblClientId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblUsername.setBounds(224, 71, 71, 14);
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblPassword.setBounds(224, 110, 71, 14);
		contentPanel.add(lblPassword);
		
		txtIdClient = new JTextField();
		txtIdClient.setBounds(305, 30, 105, 20);
		contentPanel.add(txtIdClient);
		txtIdClient.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(305, 67, 105, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(305, 106, 105, 18);
		contentPanel.add(txtPassword);
		
		JButton btnOk = new JButton("Log In");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(Connection con = DatabaseConnection.getConnection()){
					String ClientId = txtIdClient.getText().toLowerCase().trim();;
					String username = txtUsername.getText().toLowerCase().trim();;
					char[] password = txtPassword.getPassword();	
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("SELECT * FROM database.login WHERE idClient = '");
					stringBuilder.append(ClientId);
					stringBuilder.append("' AND username = '");
					stringBuilder.append(username);
					stringBuilder.append("' AND password = '");
					stringBuilder.append(password);
					stringBuilder.append("'");
					String querySQL = stringBuilder.toString();
					PreparedStatement ps = con.prepareStatement(querySQL);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						dispose();
						
						DatabaseHomepage hp = new DatabaseHomepage();
						hp.setVisible(true);
					}
					else {
						String msg = "ID, username and/or password wrong...";
						JOptionPane.showMessageDialog(btnOk, msg);
						txtUsername.setText("");
						txtPassword.setText("");
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
		btnOk.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		btnOk.setBounds(23, 309, 124, 26);
		contentPanel.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdClient.setText("");
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		btnClear.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		btnClear.setBounds(284, 309, 117, 26);
		contentPanel.add(btnClear);
		
		JButton btnForgot = new JButton("I forgot my username and/or password");
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgottenPassword forPwd = new forgottenPassword();
				forPwd.setModal(true);
				forPwd.setVisible(true);
			}
		});
		btnForgot.setFont(new Font("Brush Script MT", Font.PLAIN, 17));
		btnForgot.setBackground(SystemColor.activeCaption);
		btnForgot.setBounds(92, 346, 245, 35);
		contentPanel.add(btnForgot);
		{
			JLabel lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon("C:\\Users\\Silvia\\Downloads\\Sfondo MyDatabase.png"));
			lblBackground.setBounds(0, 0, 434, 401);
			contentPanel.add(lblBackground);
		}
	}
}
