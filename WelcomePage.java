import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import SecondaryWindows.forgottenPassword;
import SecondaryWindows.logInWindow;
import SecondaryWindows.signInWindow;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	public static welcomeInMyDatabase frame;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setTitle("Welcome In My Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1616, 915);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome in My Database");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 50));
		lblWelcome.setBounds(10, 324, 1590, 71);
		contentPane.add(lblWelcome);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInWindow log = new LogInWindow();
				log.setModal(true);
				log.setVisible(true);
			}
		});
		btnLogIn.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 30));
		btnLogIn.setBounds(416, 441, 158, 51);
		contentPane.add(btnLogIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInWindow sign = new SignInWindow();
				sign.setModal(true);
				sign.setVisible(true);
			}
		});
		btnSignIn.setFont(new Font("Brush Script MT", Font.PLAIN, 30));
		btnSignIn.setBounds(1041, 441, 158, 51);
		contentPane.add(btnSignIn);
		
		JButton btnForgot = new JButton("I forgot my username and/or password");
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgottenPassword forPwd = new ForgottenPassword();
				forPwd.setModal(true);
				forPwd.setVisible(true);
			}
		});
		btnForgot.setBackground(SystemColor.activeCaption);
		btnForgot.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		btnForgot.setBounds(625, 551, 378, 51);
		contentPane.add(btnForgot);
	}
}
