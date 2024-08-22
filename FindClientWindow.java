import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import MainWindows.Homepage;
import myDatabaseClassesAndMethods.myMethods;
import myDatabaseClassesAndMethods.variables;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FindClientWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtClientId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindClientWindow dialog = new FindClientWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public FindClientWindow() {
		setTitle("My Database_Find client");
		setBounds(100, 100, 248, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInserClient = new JLabel("Insert Client's ID");
		lblInserClient.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblInserClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserClient.setBounds(10, 11, 210, 14);
		contentPanel.add(lblInserClient);
	
		JLabel lblClientId = new JLabel("Client's ID");
		lblClientId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientId.setBounds(10, 44, 100, 14);
		contentPanel.add(lblClientId);
	
		txtClientId = new JTextField();
		txtClientId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientId.setBounds(120, 41, 93, 20);
		contentPanel.add(txtClientId);
		txtClientId.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(91, 80, 51, 25);
		contentPanel.add(btnOk);
		btnOk.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
				DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
				DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
				String txtCi = txtClientId.getText();
				DatabaseMethods.mySql.FindInMySQL(variables.tableC, variables.idC, txtCi, Homepage.tblClient,variables.colNameC);
				DatabaseMethods.mySql.FindInMySQL(variables.tableW, variables.idCp, txtCi, Homepage.tblWarehouse,variables.colNameP);
				DatabaseMethods.mySql.FindObjectInConnectTableInMySQL(variables.columnsD, variables.tableC, variables.tableW, variables.idC, variables.idCp, variables.idC, txtCi, Homepage.tblDatabase, variables.colNameD);
				dispose();
			}
		});
		btnOk.setActionCommand("OK");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(151, 80, 69, 25);
		contentPanel.add(btnCancel);
		btnCancel.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClientId.setText("");
			}
		});
		btnCancel.setActionCommand("Cancel");
	}
}
