import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteClientWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtClientId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteClientWindow dialog = new DeleteClientWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DeleteClientWindow() {
		setTitle("My Database_ Delete Client");
		setBounds(100, 100, 397, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInsertId = new JLabel("Insert the ID of the client to delete");
		lblInsertId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblInsertId.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertId.setBounds(0, 25, 345, 14);
		contentPanel.add(lblInsertId);
		
		JLabel lblClientId = new JLabel("Client's ID");
		lblClientId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblClientId.setBounds(74, 64, 89, 14);
		contentPanel.add(lblClientId);
		
		txtClientId = new JTextField();
		txtClientId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		txtClientId.setBounds(173, 61, 126, 20);
		contentPanel.add(txtClientId);
		txtClientId.setColumns(10);
		
		JLabel lblinfo = new JLabel("The product associated with the selected Client will be deleted");
		lblinfo.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setBounds(0, 113, 381, 14);
		contentPanel.add(lblinfo);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 138, 381, 35);
		contentPanel.add(buttonPane);
		buttonPane.setBackground(SystemColor.inactiveCaption);
		buttonPane.setLayout(null);
			
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
				DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
				DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
				String txt = txtClientId.getText();
				DatabaseMethods.mySql.DeleteInMySQL(variables.tableC,variables.idC , txt );
				DatabaseMethods.mySql.DeleteInMySQL(variables.tableW,variables.idCp , txt );
				
				String msg = "The product associated with the selected Client will be deleted";
				JOptionPane.showMessageDialog(btnOk, msg);
				DatabaseMethods.myRefreshClients();
				DatabaseMethods.myRefreshWarehouse();
				DatabaseMethods.myRefreshDatabase();
				dispose();
			}
		});
		btnOk.setBounds(224, 5, 51, 25);
		btnOk.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnOk.setActionCommand("OK");
		buttonPane.add(btnOk);
		getRootPane().setDefaultButton(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtClientId.setText("");
			}
		});
		btnCancel.setBounds(285, 5, 69, 25);
		btnCancel.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	}
}

