import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import MainWindows.Homepage;
import myDatabaseClassesAndMethods.myMethods;
import myDatabaseClassesAndMethods.variables;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductWindow extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtProductName;
	private JTextField txtClientId;
	private JComboBox<String> cbCategory;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProductWindow dialog = new AddProductWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public AddProductWindow() {
		
		getContentPane().setFont(new Font("Cambria Math", Font.PLAIN, 12));
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setBounds(100, 100, 312, 227);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setBounds(0, 144, 296, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JLabel lblProductName = new JLabel("Product's name");
				lblProductName.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
				lblProductName.setBounds(24, 50, 96, 14);
				getContentPane().add(lblProductName);
				
				JLabel lblCategory = new JLabel("Category");
				lblCategory.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
				lblCategory.setBounds(24, 85, 96, 14);
				getContentPane().add(lblCategory);
				
				JLabel lblClientId = new JLabel("Client's ID");
				lblClientId.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
				lblClientId.setBounds(24, 120, 96, 14);
				getContentPane().add(lblClientId);
				
				txtProductName = new JTextField();
				txtProductName.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
				txtProductName.setBounds(130, 47, 139, 20);
				getContentPane().add(txtProductName);
				txtProductName.setColumns(10);
				
				txtClientId = new JTextField();
				txtClientId.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
				txtClientId.setBounds(130, 117, 139, 20);
				getContentPane().add(txtClientId);
				txtClientId.setColumns(10);
				
				cbCategory = new JComboBox<String>();
				cbCategory.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
				cbCategory.setModel(new DefaultComboBoxModel<String>(new String[] {"...", "Type 1", "Type 2", "Type 3"}));
				cbCategory.setBounds(130, 81, 139, 18);
				getContentPane().add(cbCategory);
				
				JLabel lblInsertInfo = new JLabel("Insert the new Product info");
				lblInsertInfo.setFont(new Font(variables.lblFamily, variables.lblStyle, variables.lblSize));
				lblInsertInfo.setHorizontalAlignment(SwingConstants.CENTER);
				lblInsertInfo.setBounds(10, 11, 286, 14);
				getContentPane().add(lblInsertInfo);
				
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
						DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
						
							String[] values = {txtProductName.getText(),(String)cbCategory.getSelectedItem(),
									txtClientId.getText()};
							for(int i = 0; i < variables.elementsP.length; i++) {
								variables.elementsP[i] = values[i];
							
								DatabaseMethods.mySql.AddInMySQL(variables.elementsP, values, variables.tableW, variables.dataP, variables.nValuesP);
							} 
						
						DatabaseMethods.myRefreshClients();
						DatabaseMethods.myRefreshWarehouse();
						DatabaseMethods.myRefreshDatabase();
						dispose();
					}
				});
				okButton.setBounds(141, 5, 51, 25);
				okButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtProductName.setText("");
						txtClientId.setText("");
						cbCategory.setSelectedIndex(0);
					}
				});
				cancelButton.setBounds(202, 5, 69, 25);
				cancelButton.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
