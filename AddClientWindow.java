import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import MainWindows.Homepage;
import myDatabaseClassesAndMethods.myMethods;
import myDatabaseClassesAndMethods.variables;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClientWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtClientName;
	private JTextField txtClientSurname;
	private JTextField txtPhoneNumber;
	private JTextField txtClientMail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddClientWindow dialog = new AddClientWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public AddClientWindow() {
		setTitle("My Database_Add Client");
		setBounds(100, 100, 386, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsertData = new JLabel("Insert the informations of the new client");
		lblInsertData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertData.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblInsertData.setBounds(0, 11, 370, 14);
		contentPanel.add(lblInsertData);
		
		JLabel lblClientName = new JLabel("Client's Name");
		lblClientName.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientName.setBounds(26, 48, 112, 14);
		contentPanel.add(lblClientName);
		
		JLabel lblClientSurname = new JLabel("Client's Surname");
		lblClientSurname.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientSurname.setBounds(26, 76, 112, 14);
		contentPanel.add(lblClientSurname);
		
		JLabel lblClientMail = new JLabel("Client's e-mail");
		lblClientMail.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientMail.setBounds(26, 104, 112, 14);
		contentPanel.add(lblClientMail);
		
		JLabel lblPhoneNumber = new JLabel("Client's phone number");
		lblPhoneNumber.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblPhoneNumber.setBounds(26, 132, 134, 14);
		contentPanel.add(lblPhoneNumber);
		
		txtClientName = new JTextField();
		txtClientName.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientName.setBounds(170, 45, 166, 20);
		contentPanel.add(txtClientName);
		txtClientName.setColumns(10);
		
		txtClientSurname = new JTextField();
		txtClientSurname.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientSurname.setBounds(170, 73, 166, 20);
		contentPanel.add(txtClientSurname);
		txtClientSurname.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtPhoneNumber.setBounds(170, 129, 166, 20);
		contentPanel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		txtClientMail = new JTextField();
		txtClientMail.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientMail.setBounds(170, 101, 166, 20);
		contentPanel.add(txtClientMail);
		txtClientMail.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
							String[] values = {txtClientName.getText(),txtClientSurname.getText(),
									txtClientMail.getText(),txtPhoneNumber.getText()};
							for(int i = 0; i < variables.elementsC.length; i++) {
								variables.elementsC[i] = values[i];
							}
							DatabaseMethods.mySql.AddInMySQL(variables.elementsC, values, variables.tableC, variables.dataC, variables.nValuesC);
						 
						
						DatabaseMethods.myRefreshClients();
						DatabaseMethods.myRefreshWarehouse();
						DatabaseMethods.myRefreshDatabase();
						dispose();
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtClientName.setText("");
						txtClientSurname.setText("");
						txtClientMail.setText("");
						txtPhoneNumber.setText("");
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
}
