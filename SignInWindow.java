import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import myDatabaseClassesAndMethods.databaseConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SignInWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmedPassword;
	private JTextField txtQuestion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignInWindow dialog = new SignInWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public signInWindow() {
		setTitle("My Database_Sign In");
		setBounds(100, 100, 340, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 324, 354);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblUsername.setBounds(10, 11, 228, 14);
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		txtUsername.setBounds(10, 32, 302, 20);
		panel.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblPassword.setBounds(10, 63, 228, 14);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		txtPassword.setBounds(10, 88, 302, 23);
		panel.add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(10, 132, 228, 14);
		panel.add(lblConfirmPassword);
		
		txtConfirmedPassword = new JPasswordField();
		txtConfirmedPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmedPassword.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		txtConfirmedPassword.setBounds(10, 157, 302, 23);
		panel.add(txtConfirmedPassword);
		
		JLabel lblQuestion = new JLabel("What's your favorite animal?");
		lblQuestion.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblQuestion.setBounds(10, 207, 228, 14);
		panel.add(lblQuestion);
		
		txtQuestion = new JTextField();
		txtQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuestion.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		txtQuestion.setColumns(10);
		txtQuestion.setBounds(10, 235, 302, 20);
		panel.add(txtQuestion);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				char[] pw = txtPassword.getPassword();
				char[] pw2 = txtConfirmedPassword.getPassword();
				String question = txtQuestion.getText().toLowerCase().trim();
				
                boolean comparePw = Arrays.equals(pw, pw2);
				if (comparePw) {
					String password = new String(pw);
					String regexPwd = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
					Pattern pattern = Pattern.compile(regexPwd);
					Matcher matcher = pattern.matcher(password);
					boolean matchFound = matcher.find();
					if(matchFound == true) {
						ResultSet rs = null;
						PreparedStatement ps = null;
						Connection con = null;
						try {
							con = DatabaseConnection.getConnection();
							String querySQL = "INSERT INTO database.login (username, password, question) VALUES (?,?,?)";
							ps = con.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
							ps.setString(1, username);
							ps.setString(2, password);
							ps.setString(3, question);
							ps.executeUpdate();
							rs = ps.getGeneratedKeys();
							if(rs.next()) {
							int idClient = rs.getInt(1);
							String msg = "Welcome in My Database\n"
									+ "Your ID : " + idClient + ""
									+ "\nYour Username : " + username + ""
											+ "\nYour Password is : " + password
							        + "Your secret code : " + question
							        + "You can use your ID and your secret code if you forgot your password";
								JOptionPane.showMessageDialog(btnSignIn, msg);
								dispose();
								LogInWindow log = new LogInWindow();
								log.setModal(true);
								log.setVisible(true);
							}
							else {
							System.out.print("Error");
							}
							con.close();
							ps.close();
						}
						catch(SQLException ex) {
							ex.printStackTrace();
						}
						finally {
							try {
								if (rs != null)
									rs.close();
								if (ps != null)
									ps.close();
								if (con != null)
									con.close();
							}
							catch(SQLException ec) {
								ec.printStackTrace();
							}
						}
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(btnSignIn, "The password is not ");
					}
				}
				else {
					JOptionPane.showMessageDialog(btnSignIn, "Ceck your Password");
				}
			}
		});
		btnSignIn.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		btnSignIn.setBounds(10, 293, 91, 23);
		panel.add(btnSignIn);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				txtPassword.setText("");
				txtConfirmedPassword.setText("");
				txtQuestion.setText("");
			}
		});
		btnClear.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		btnClear.setBounds(221, 293, 91, 23);
		panel.add(btnClear);
	}
}
