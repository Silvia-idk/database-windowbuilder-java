import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import SecondaryWindows.AddClientWindow;
import SecondaryWindows.AddProductWindow;
import SecondaryWindows.DeleteClientWindow;
import SecondaryWindows.DeleteProductWindow;
import SecondaryWindows.FindClientWindow;
import SecondaryWindows.FindProductWindow;
import SecondaryWindows.UpdateClientWondow;
import SecondaryWindows.UpdateProductWindow;
import myDatabaseClassesAndMethods.myMethods;
import myDatabaseClassesAndMethods.variables;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class DatabaseHomepage extends JFrame {
	//variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JButton btnUpdateClient;
	public static JButton btnUpdateInventory;
	public static JTable tblClient;
	public static JTable tblWarehouse;
	public static JTable tblDatabase;
	public static JButton btnClearTblClient;
	public static JButton btnClearTblInventory;
	public static JButton btnClearDatabase;
	public static JButton btnClearAll;
	public static JMenuBar menuBar;
	public static JMenu mnShow;
	public static JMenuItem mntmShowClientList;
	public static JMenuItem mntmShowInventory;
	public static JMenuItem mntmShowDatabase;
	public static JMenuItem mntmShowAll;
	public static JMenu mnFind;
	public static JMenuItem mntmFindClient;
	public static JMenuItem mntmFindProduct;
	public static JMenu mnAdd;
	public static JMenuItem mntmAddClient;
	public static JMenuItem mntmAddProduct;
	public static JMenu mnDelete; 
	public static JMenuItem mntmDeleteClient; 
	public static JMenuItem mntmDeleteProduct; 
	public static JMenu mnUpdate;
	public static JMenuItem mntmUpdateClient; 
	public static JMenuItem mntmUpdateproduct;	
	public static JMenu mnFont;	
	public static JMenu mnFamily;
	public static JMenuItem mntmCambriaMath;
	public static JMenuItem mntmComic;
	public static JMenuItem mntmConsolas;	
	public static JMenu mnStyle;
	public static JMenuItem mntmPlain; 
	public static JMenuItem mntmBold;
	public static JMenuItem mntmItalic;	
	public static JMenu mnSize;
	public static JMenuItem mntm12;
	public static JMenuItem mntm14;
	public static JMenuItem mnm16;
	public static JMenu mnEdit;
	public static JMenu mnLabels; 
	public static JMenu mnlblFamily; 
	public static JMenuItem mntmLblCambria;	
	public static JMenuItem mntmLblComic;
	public static JMenuItem mntmLblConsolas;
	public static JMenu mnLblStyle;
	public static JMenuItem mntmLblPlain;
	public static JMenuItem mntmLblBold;
	public static JMenuItem mntmLblItalic;
	public static JMenu mnlblSize;
	public static JMenuItem mntmLbl12;
	public static JMenuItem mntmLbl14;
	public static JMenuItem mnmLbl16;
	public static JMenu mnButton; 
	public static JMenu mnBtnFamily; 
	public static JMenuItem mntmBtnCambria;
	public static JMenuItem mntmBtnComic;
	public static JMenuItem mntmBtnConsolas; 
	public static JMenu mnBtnStyle;
	public static JMenuItem mntmBtnPlain; 
	public static JMenuItem mntmBtnBold;
	public static JMenuItem mntmBtnItalic; 
	public static JMenu mnBtnSize; 
	public static JMenuItem mntmBtn12; 
	public static JMenuItem mntmBtn14;
	public static JMenuItem mnmBtn16;
	public static JMenu mnMenu;
	public static JMenu mnmnFamily;
	public static JMenuItem mntmMnCambria;
	public static JMenuItem mntmMnComic;
	public static JMenuItem mntmMnConsolas;
	public static JMenu mnMnStyle;
	public static JMenuItem mntmMnPlain; 
	public static JMenuItem mntmMnBold;
	public static JMenuItem mntmMnItalic;
	public static JMenu mnMnSize;
	public static JMenuItem mntmMn12;
	public static JMenuItem mntmMn14;
	public static JMenuItem mnmMn16;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseHomepage frame = new DatabaseHomepage();
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
	public Homepage() {
		setTitle("My Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1616, 915);
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane spDatabase = new JScrollPane();
		tblDatabase = new JTable();
		spDatabase.setViewportView(tblDatabase);
		
		JScrollPane spClient = new JScrollPane();
		tblClient = new JTable();
		spClient.setViewportView(tblClient);
		
		JScrollPane spWarehouse = new JScrollPane();
		tblWarehouse = new JTable();
		spWarehouse.setViewportView(tblWarehouse);
		/*Buttons*/
		
		btnUpdateClient = new JButton("Update Clients' List");
		btnUpdateClient.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] elements = {"idClient","clientName", "clientSurname", "clientMail", "phoneNumber"};
				String data = "clientName = ?, clientSurname = ?, clientMail = ?, phoneNumber = ?";
				myMethods.mySql.UndateFromTableInMySQL(variables.tableC,data,tblClient,elements, variables.idC);
				myMethods.myRefreshTables();
			}
		});
		
		btnUpdateInventory = new JButton("Update Inventory");
		btnUpdateInventory.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnUpdateInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] elements = {"idProduct","productName", "category", "idClientP"};
				String data = "productName = ?, category = ?, idClientP = ?";
				myMethods.mySql.UndateFromTableInMySQL(variables.tableW,data,tblWarehouse,elements, variables.idP);
				myMethods.myRefreshTables();
			}
		});
		
		btnUpdateInventory.setHorizontalAlignment(SwingConstants.LEFT);
		btnClearTblClient = new JButton("Clear Clients' List");
		btnClearTblClient.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnClearTblClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblClient.setModel(new DefaultTableModel());
			}
		});
		btnClearTblInventory = new JButton("Clear Inventory");
		btnClearTblInventory.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnClearTblInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblWarehouse.setModel(new DefaultTableModel());
			}
		});
		btnClearDatabase = new JButton("Clear Database");
		btnClearDatabase.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblDatabase.setModel(new DefaultTableModel());
			}
		});
		btnClearAll = new JButton("Clear All");
		btnClearAll.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblClient.setModel(new DefaultTableModel());
				tblWarehouse.setModel(new DefaultTableModel());
				tblDatabase.setModel(new DefaultTableModel());
			}
		});
		/*Menu*/
		/*Menu bar*/
		menuBar = new JMenuBar();
		menuBar.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		/*Menu Show*/
		mnShow = new JMenu("Show");
		mnShow.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		mnShow.setBackground(SystemColor.activeCaption);
		menuBar.add(mnShow);
		/*Options*/
			/*Clients*/
			mntmShowClientList = new JMenuItem("Clients' List");
			mnShow.add(mntmShowClientList);
			mntmShowClientList.setBackground(SystemColor.inactiveCaption);
			mntmShowClientList.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmShowClientList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myMethods.myRefreshClients();
				}
			});
			/*Inventory*/
			mntmShowInventory = new JMenuItem("Inventory");
			mnShow.add(mntmShowInventory);
			mntmShowInventory.setBackground(SystemColor.inactiveCaption);
			mntmShowInventory.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmShowInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myMethods.myRefreshWarehouse();
				}
			});
			/*Database*/
			mntmShowDatabase = new JMenuItem("Database");
			mnShow.add(mntmShowDatabase);
			mntmShowDatabase.setBackground(SystemColor.inactiveCaption);
			mntmShowDatabase.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmShowDatabase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myMethods.myRefreshDatabase();
				}
			});
			/*All*/
			mntmShowAll = new JMenuItem("All");
			mnShow.add(mntmShowAll);
			mntmShowAll.setBackground(SystemColor.inactiveCaption);
			mntmShowAll.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myMethods.myRefreshTables();
				}
			});
		/*Menu Find*/
		mnFind = new JMenu("Find");
		mnFind.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		mnFind.setBackground(SystemColor.activeCaption);
		menuBar.add(mnFind);
		/*Options*/	
			/*Client*/
			mntmFindClient = new JMenuItem("Client");
			mnFind.add(mntmFindClient);
			mntmFindClient.setBackground(SystemColor.inactiveCaption);
			mntmFindClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmFindClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FindClientWindow fcw = new FindClientWindow();
					fcw.setModal(true);
					fcw.setVisible(true);
				}
			});
			/*Product*/
			mntmFindProduct = new JMenuItem("Product");
			mnFind.add(mntmFindProduct);
			mntmFindProduct.setBackground(SystemColor.inactiveCaption);
			mntmFindProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmFindProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FindProductWindow fpw = new FindProductWindow();
					fpw.setModal(true);
					fpw.setVisible(true);
				}
			});
		/*Menu Add*/
		mnAdd = new JMenu("Add");
		mnAdd.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		mnAdd.setBackground(SystemColor.activeCaption);
		menuBar.add(mnAdd);
		/*Options*/
			/*Client*/
			mntmAddClient = new JMenuItem("Client");
			mnAdd.add(mntmAddClient);
			mntmAddClient.setBackground(SystemColor.inactiveCaption);
			mntmAddClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmAddClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddClientWindow acw = new AddClientWindow();
					acw.setModal(true);
					acw.setVisible(true);
				}
			});
			/*Product*/
			mntmAddProduct = new JMenuItem("Product");
			mnAdd.add(mntmAddProduct);
			mntmAddProduct.setBackground(SystemColor.inactiveCaption);
			mntmAddProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mntmAddProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddProductWindow apw = new AddProductWindow();
					apw.setModal(true);
					apw.setVisible(true);
				}
			});
		/*Menu Delete*/
		mnDelete = new JMenu("Delete");
		mnDelete.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		mnDelete.setBackground(SystemColor.activeCaption);
		menuBar.add(mnDelete);
		/*Options*/
			/*Client*/
			mntmDeleteClient = new JMenuItem("Client");
			mntmDeleteClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnDelete.add(mntmDeleteClient);
			mntmDeleteClient.setBackground(SystemColor.inactiveCaption);
			mntmDeleteClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteClientWindow dcw = new DeleteClientWindow();
					dcw.setModal(true);
					dcw.setVisible(true);
				}
			});
			/*Product*/
			mntmDeleteProduct = new JMenuItem("Product");
			mntmDeleteProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnDelete.add(mntmDeleteProduct);
			mntmDeleteProduct.setBackground(SystemColor.inactiveCaption);
			mntmDeleteProduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteProductWindow dpw = new DeleteProductWindow();
					dpw.setModal(true);
					dpw.setVisible(true);
				}
			});
		/*Menu Update*/
		mnUpdate = new JMenu("Update");
		mnUpdate.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		mnUpdate.setBackground(SystemColor.activeCaption);
		menuBar.add(mnUpdate);
		/*Options*/
			/*Client*/
			mntmUpdateClient = new JMenuItem("Client");
			mntmUpdateClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnUpdate.add(mntmUpdateClient);
			mntmUpdateClient.setBackground(SystemColor.inactiveCaption);
			mntmUpdateClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateClientWondow acw = new UpdateClientWondow();
					acw.setModal(true);
					acw.setVisible(true);
				}
			});
			/*Product*/
			mntmUpdateproduct = new JMenuItem("Product");
			mntmUpdateproduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnUpdate.add(mntmUpdateproduct);
			mntmUpdateproduct.setBackground(SystemColor.inactiveCaption);
			mntmUpdateproduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateProductWindow apw = new UpdateProductWindow();
					apw.setModal(true);
					apw.setVisible(true);
				}
			});
		/*Menu Font text*/
		mnFont = new JMenu("Font");
		mnFont.setBackground(SystemColor.activeCaption);
		mnFont.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		menuBar.add(mnFont);
		/*Options*/
			/*Family*/
			mnFamily = new JMenu("Family");
			mnFamily.setBackground(SystemColor.inactiveCaption);
			mnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnFont.add(mnFamily);
				/*Op*/			
				 mntmCambriaMath = new JMenuItem("Cambria Math");
				mntmCambriaMath.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
				mnFamily.add(mntmCambriaMath);
				mntmCambriaMath.setBackground(SystemColor.inactiveCaption);
				mntmCambriaMath.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtFamily = "Cambria Math";
						myMethods.myRefreshTables();
					}
				});
				mntmComic = new JMenuItem("Comic Sans MS");
				mntmComic.setFont(new Font("Comic Sans MS",variables.mnStyle, variables.mnSize));
				mnFamily.add(mntmComic);
				mntmComic.setBackground(SystemColor.inactiveCaption);
				mntmComic.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtFamily = "Comic Sans MS";
						myMethods.myRefreshTables();
					}
				});
				mntmConsolas = new JMenuItem("Consolas");
				mntmConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));
				mnFamily.add(mntmConsolas);
				mntmConsolas.setBackground(SystemColor.inactiveCaption);
				mntmConsolas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtFamily = "Consolas";
						myMethods.myRefreshTables();
					}
				});
			/*Style*/
			mnStyle = new JMenu("Style");
			mnStyle.setBackground(SystemColor.inactiveCaption);
			mnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnFont.add(mnStyle);

			mntmPlain = new JMenuItem("Plain");
			mntmPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
			mnStyle.add(mntmPlain);
			mntmPlain.setBackground(SystemColor.inactiveCaption);
			mntmPlain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					variables.txtStyle = Font.PLAIN;
					myMethods.myRefreshTables();
				}
			});
			mntmBold = new JMenuItem("Bold");
			mntmBold.setFont(new Font(variables.mnFamily, Font.BOLD, variables.mnSize));
			mnStyle.add(mntmBold);
			mntmBold.setBackground(SystemColor.inactiveCaption);
			mntmBold.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					variables.txtStyle = Font.BOLD;
					myMethods.myRefreshTables();
				}
			});
			mntmItalic = new JMenuItem("Italic");
			mntmItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
			mnStyle.add(mntmItalic);
			mntmItalic.setBackground(SystemColor.inactiveCaption);
			mntmItalic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					variables.txtStyle = Font.ITALIC;
					myMethods.myRefreshTables();
				}
			});
			/*Size*/
			mnSize = new JMenu("Size");
			mnSize.setBackground(SystemColor.inactiveCaption);
			mnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnFont.add(mnSize);
				/*Op*/				
				mntm12 = new JMenuItem("12");
				mntm12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
				mnSize.add(mntm12);
				mntm12.setBackground(SystemColor.inactiveCaption);
				mntm12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtSize = 12;
						myMethods.myRefreshTables();
					}
				});
				mntm14 = new JMenuItem("14");
				mntm14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
				mnSize.add(mntm14);
				mntm14.setBackground(SystemColor.inactiveCaption);
				mntm14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtSize = 14;
						myMethods.myRefreshTables();
					}
				});
				mnm16 = new JMenuItem("16");
				mnm16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
				mnSize.add(mnm16);
				mnm16.setBackground(SystemColor.inactiveCaption);
				mnm16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						variables.txtSize = 16;
						myMethods.myRefreshTables();
					}
				});
		/*Menu Edit*/		
		mnEdit = new JMenu("Edit");
		mnEdit.setBackground(SystemColor.activeCaption);
		mnEdit.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		menuBar.add(mnEdit);
			/*Labels*/
			mnLabels = new JMenu("Labels");
			mnLabels.setBackground(SystemColor.inactiveCaption);
			mnLabels.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnEdit.add(mnLabels);
				/*Family*/
				mnlblFamily = new JMenu("Family");
				mnlblFamily.setBackground(SystemColor.inactiveCaption);
				mnlblFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnLabels.add(mnlblFamily);
		
					mntmLblCambria = new JMenuItem("Cambria Math");
					mntmLblCambria.setBackground(SystemColor.inactiveCaption);
					mntmLblCambria.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblFamily = "Cambria Math";
							
							repaint();
						}
					});
					mntmLblCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
					mnlblFamily.add(mntmLblCambria);
					
					mntmLblComic = new JMenuItem("Comic Sans MS");
					mntmLblComic.setBackground(SystemColor.inactiveCaption);
					mntmLblComic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblFamily = "Comic Sans MS";
							
							repaint();
						}
					});
					mntmLblComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
					mnlblFamily.add(mntmLblComic);
					
					mntmLblConsolas = new JMenuItem("Consolas");
					mntmLblConsolas.setBackground(SystemColor.inactiveCaption);
					mntmLblConsolas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblFamily = "Consolas";
							
							repaint();
						}
					});
					mntmLblConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));
					mnlblFamily.add(mntmLblConsolas);
				/*Style*/
				mnLblStyle = new JMenu("Style");
				mnLblStyle.setBackground(SystemColor.inactiveCaption);
				mnLblStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnLabels.add(mnLblStyle);
		
					mntmLblPlain = new JMenuItem("Plain");
					mntmLblPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
					mnLblStyle.add(mntmLblPlain);
					mntmLblPlain.setBackground(SystemColor.inactiveCaption);
					mntmLblPlain.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblStyle = Font.PLAIN;
							
							repaint();
						}
					});
					mntmLblBold = new JMenuItem("Bold");
					mntmLblBold.setFont(new Font(variables.mnFamily, Font.BOLD, variables.mnSize));
					mnLblStyle.add(mntmLblBold);
					mntmLblBold.setBackground(SystemColor.inactiveCaption);
					mntmLblBold.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblStyle = Font.BOLD;
							
							repaint();
						}
					});
					mntmLblItalic = new JMenuItem("Italic");
					mntmLblItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
					mnLblStyle.add(mntmLblItalic);
					mntmLblItalic.setBackground(SystemColor.inactiveCaption);
					mntmLblItalic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblStyle = Font.ITALIC;
							
							repaint();
						}
					});
					
				/*Size*/
				mnlblSize = new JMenu("Size");
				mnlblSize.setBackground(SystemColor.inactiveCaption);
				mnlblSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnLabels.add(mnlblSize);
					mntmLbl12 = new JMenuItem("12");
					mntmLbl12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
					mnlblSize.add(mntmLbl12);
					mntmLbl12.setBackground(SystemColor.inactiveCaption);
					mntmLbl12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblSize = 12;
							repaint();
						}
					});
					mntmLbl14 = new JMenuItem("14");
					mntmLbl14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
					mnlblSize.add(mntmLbl14);
					mntmLbl14.setBackground(SystemColor.inactiveCaption);
					mntmLbl14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblSize = 14;
							repaint();
						}
					});
					mnmLbl16 = new JMenuItem("16");
					mnmLbl16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
					mnlblSize.add(mnmLbl16);
					mnmLbl16.setBackground(SystemColor.inactiveCaption);
					mnmLbl16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.lblSize = 16;
							repaint();
						}
					});
			/*Buttons*/		
			mnButton = new JMenu("Buttons");
			mnButton.setBackground(SystemColor.inactiveCaption);
			mnButton.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnEdit.add(mnButton);
				/*Family*/
				mnBtnFamily = new JMenu("Family");
				mnBtnFamily.setBackground(SystemColor.inactiveCaption);
				mnBtnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnButton.add(mnBtnFamily);
			
					mntmBtnCambria = new JMenuItem("Cambria Math");
					mntmBtnCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
					mnBtnFamily.add(mntmBtnCambria);
					mntmBtnCambria.setBackground(SystemColor.inactiveCaption);
					mntmBtnCambria.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnFamily = "Cambria Math";
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mntmBtnComic = new JMenuItem("Comic Sans MS");
					mntmBtnComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
					mnBtnFamily.add(mntmBtnComic);
					mntmBtnComic.setBackground(SystemColor.inactiveCaption);
					mntmBtnComic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnFamily = "Comic Sans MS";
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mntmBtnConsolas = new JMenuItem("Consolas");
					mntmBtnConsolas.setFont(new Font("Consolas",  variables.mnStyle, variables.mnSize));
					mnBtnFamily.add(mntmBtnConsolas);
					mntmBtnConsolas.setBackground(SystemColor.inactiveCaption);
					mntmBtnConsolas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnFamily = "Consolas";
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
				/*Style*/
				mnBtnStyle = new JMenu("Style");
				mnBtnStyle.setBackground(SystemColor.inactiveCaption);
				mnBtnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnButton.add(mnBtnStyle);
			
					mntmBtnPlain = new JMenuItem("Plain");
					mntmBtnPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
					mnBtnStyle.add(mntmBtnPlain);
					mntmBtnPlain.setBackground(SystemColor.inactiveCaption);
					mntmBtnPlain.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnStyle = Font.PLAIN;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mntmBtnBold = new JMenuItem("Bold");
					mntmBtnBold.setFont(new Font(variables.mnFamily, Font.BOLD, variables.mnSize));
					mnBtnStyle.add(mntmBtnBold);
					mntmBtnBold.setBackground(SystemColor.inactiveCaption);
					mntmBtnBold.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnStyle = Font.BOLD;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mntmBtnItalic = new JMenuItem("Italic");
					mntmBtnItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
					mnBtnStyle.add(mntmBtnItalic);
					mntmBtnItalic.setBackground(SystemColor.inactiveCaption);
					mntmBtnItalic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnStyle = Font.ITALIC;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					
				/*Size*/
				mnBtnSize = new JMenu("Size");
				mnBtnSize.setBackground(SystemColor.inactiveCaption);
				mnBtnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnButton.add(mnBtnSize);
			
					mntmBtn12 = new JMenuItem("12");
					mntmBtn12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
					mnBtnSize.add(mntmBtn12);
					mntmBtn12.setBackground(SystemColor.inactiveCaption);
					mntmBtn12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnSize = 12;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mntmBtn14 = new JMenuItem("14");
					mntmBtn14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
					mnBtnSize.add(mntmBtn14);
					mntmBtn14.setBackground(SystemColor.inactiveCaption);
					mntmBtn14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnSize = 14;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
					mnmBtn16 = new JMenuItem("16");
					mnmBtn16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
					mnBtnSize.add(mnmBtn16);
					mnmBtn16.setBackground(SystemColor.inactiveCaption);
					mnmBtn16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.btnSize = 16;
							myMethods.myRefreshButtonsHomepage();
							repaint();
						}
					});
			/*edit Menu*/
			mnMenu = new JMenu("Menu");
			mnMenu.setBackground(SystemColor.inactiveCaption);
			mnMenu.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
			mnEdit.add(mnMenu);
				/*Family*/
				mnmnFamily = new JMenu("Family");
				mnmnFamily.setBackground(SystemColor.inactiveCaption);
				mnmnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnMenu.add(mnmnFamily);
			
					mntmMnCambria = new JMenuItem("Cambria Math");
					mntmMnCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
					mnmnFamily.add(mntmMnCambria);
					mntmMnCambria.setBackground(SystemColor.inactiveCaption);
					mntmMnCambria.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnFamily = "Cambria Math";
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mntmMnComic = new JMenuItem("Comic Sans MS");
					mntmMnComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
					mnmnFamily.add(mntmMnComic);
					mntmMnComic.setBackground(SystemColor.inactiveCaption);
					mntmMnComic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnFamily = "Comic Sans MS";
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mntmMnConsolas = new JMenuItem("Consolas");
					mntmMnConsolas.setFont(new Font("Consolas",variables.mnStyle, variables.mnSize));
					mnmnFamily.add(mntmMnConsolas);
					mntmMnConsolas.setBackground(SystemColor.inactiveCaption);
					mntmMnConsolas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnFamily = "Consolas";
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					
				/*Style*/
				mnMnStyle = new JMenu("Style");
				mnMnStyle.setBackground(SystemColor.inactiveCaption);
				mnMnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnMenu.add(mnMnStyle);
			
					mntmMnPlain = new JMenuItem("Plain");
					mntmMnPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
					mnMnStyle.add(mntmMnPlain);
					mntmMnPlain.setBackground(SystemColor.inactiveCaption);
					mntmMnPlain.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnStyle = Font.PLAIN;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mntmMnBold = new JMenuItem("Bold");
					mntmMnBold.setFont(new Font(variables.mnFamily, Font.BOLD, variables.mnSize));
					mnMnStyle.add(mntmMnBold);
					mntmMnBold.setBackground(SystemColor.inactiveCaption);
					mntmMnBold.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnStyle = Font.BOLD;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mntmMnItalic = new JMenuItem("Italic");
					mntmMnItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
					mnMnStyle.add(mntmMnItalic);
					mntmMnItalic.setBackground(SystemColor.inactiveCaption);
					mntmMnItalic.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnStyle = Font.ITALIC;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
				/*Size*/
				mnMnSize = new JMenu("Size");
				mnMnSize.setBackground(SystemColor.inactiveCaption);
				mnMnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
				mnMenu.add(mnMnSize);
			
					mntmMn12 = new JMenuItem("12");
					mntmMn12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
					mnMnSize.add(mntmMn12);
					mntmMn12.setBackground(SystemColor.inactiveCaption);
					mntmMn12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnSize = 12;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mntmMn14 = new JMenuItem("14");
					mntmMn14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
					mnMnSize.add(mntmMn14);
					mntmMn14.setBackground(SystemColor.inactiveCaption);
					mntmMn14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnSize = 14;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
					mnmMn16 = new JMenuItem("16");
					mnmMn16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
					mnMnSize.add(mnmMn16);
					mnmMn16.setBackground(SystemColor.inactiveCaption);
					mnmMn16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							variables.mnSize = 16;
							myMethods.myRefreshMenusHomepage();
							repaint();
						}
					});
		/*Layout*/
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(spDatabase, GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(spClient, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
								.addComponent(btnClearTblClient, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
								.addComponent(btnClearDatabase, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
								.addComponent(btnUpdateClient))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(spWarehouse, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
								.addComponent(btnClearTblInventory, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
								.addComponent(btnClearAll, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
								.addComponent(btnUpdateInventory))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateInventory)
						.addComponent(btnUpdateClient))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(spClient, 0, 0, Short.MAX_VALUE)
						.addComponent(spWarehouse, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClearTblClient)
						.addComponent(btnClearTblInventory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(11)
					.addComponent(spDatabase, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClearDatabase)
						.addComponent(btnClearAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(7))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
