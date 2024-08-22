import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import MainWindows.Homepage;

public class DatabaseMethods {
	//variables
	private String schema = "database";
	private String txt;
	private String[] txtA;
	private JTable tbl;
	
	public static DatabaseMethods mySql = new DatabaseMethods();
	
	//method getFromMySQL
	public void getFromMySQL(String table,JTable tbl, String[] colName) {
		try(Connection con = DatabaseConnection.getConnection()) {
			
			this.txt =table;
			this.tbl = tbl;
			this.txtA = colName;
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT * FROM ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append("");
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			model.setColumnIdentifiers(colName);
			
			String[] str = new String[colName.length]; 
			while(rs.next()) {
				for(int i = 0; i < str.length; i++) {
					str[i] = rs.getString(i+1);	
				}
				model.addRow(str);	
			}
			ps.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}//end method getFromMySQL
	
	//method get2ConnectedTableFromMySQL
	public void get2ConnectedTableFromMySQL( String columns, String table, String tableB, String object, String objectB, JTable tbl, String[] colName) {
		try(Connection con = DatabaseConnection.getConnection()) {
			
			this.setTxt(columns);
			this.setTxt(table);
			this.setTxt(tableB);
			this.setTxt(object);
			this.setTxt(objectB);
			this.tbl = tbl;
			this.txtA = colName;
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT ");
			stringBuilder.append(columns);
			stringBuilder.append(" FROM ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(",");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(tableB);
			stringBuilder.append(" WHERE ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(".");
			stringBuilder.append(object);
			stringBuilder.append(" = ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(tableB);
			stringBuilder.append(".");
			stringBuilder.append(objectB);
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			model.setColumnIdentifiers(colName);
			
			String[] str = new String[colName.length]; 
			while(rs.next()) {
				for(int i = 0; i < str.length; i++) {
					str[i] = rs.getString(i+1);	
				}
				model.addRow(str);	
			}
			ps.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}//end method get2ConnectedTableFromMySQL
	
	//method FindInMySQL
	public void FindInMySQL(String table,String object, String txt, JTable tbl, String[] colName) {
		try (Connection con = DatabaseConnection.getConnection()){
			
			this.setTxt(table);
			this.setTxt(object);
			this.txt = txt;
			this.tbl = tbl;
			this.txtA = colName;
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT * FROM ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append("");
			stringBuilder.append(" WHERE ");
			stringBuilder.append(object);
			stringBuilder.append(" = ?");
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			int id = Integer.parseInt(txt);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			model.setColumnIdentifiers(colName);
			String[] str = new String[colName.length]; 
			while(rs.next()) {
				for(int i = 0; i < str.length; i++) {
					str[i] = rs.getString(i+1);	
				}
				model.addRow(str);	
			}
			ps.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}//end method FindInMySQL
	
	//method FindObjectInConnectTableInMySQL
	public void FindObjectInConnectTableInMySQL(String columns, String table, String tableB,String object,String objectB, String objectToFind, String txt, JTable tbl, String[] colName) {
		try (Connection con = DatabaseConnection.getConnection()) {
			
			this.setTxt(columns);
			this.setTxt(table);
			this.setTxt(tableB);
			this.setTxt(object);
			this.setTxt(objectB);
			this.setTxt(objectToFind);
			this.txt = txt;
			this.tbl = tbl;
			this.txtA = colName;
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT ");
			stringBuilder.append(columns);
			stringBuilder.append(" FROM ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(",");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(tableB);
			stringBuilder.append(" WHERE ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(".");
			stringBuilder.append(object);
			stringBuilder.append(" = ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(tableB);
			stringBuilder.append(".");
			stringBuilder.append(objectB);
			stringBuilder.append(" AND ");
			stringBuilder.append(objectToFind);
			stringBuilder.append(" = ?");
			
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			int id = Integer.parseInt(txt);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			model.setColumnIdentifiers(colName);
			
			String[] str = new String[colName.length]; 
			while(rs.next()) {
				for(int i = 0; i < str.length; i++) {
					str[i] = rs.getString(i+1);	
				}
				model.addRow(str);	
			}
			ps.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}//end method FindObjectInConnectTableInMySQL
	
	//method AddInMySQL
	public void AddInMySQL(String[] elements,String[] txtA, String table, String data, String nValues) {
		try (Connection con = DatabaseConnection.getConnection()) {
			
			this.setTxt(table);
			this.setTxt(data);
			this.setTxt(nValues);
			this.txtA = elements;
			this.txtA = txtA;
			for(int i = 0; i < elements.length; i++) {
					elements[i] = txtA[i];
			}
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("INSERT INTO ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append("(");
			stringBuilder.append(data);
			stringBuilder.append(")");
			stringBuilder.append(" VALUES");
			stringBuilder.append("(");
			stringBuilder.append(nValues);
			stringBuilder.append(")");
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			for(int i = 0; i < elements.length; i++) {
				ps.setString(i+1,elements[i]);
			}
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
	}//end method AddInMySQL
	
	//method UndateFromTableInMySQL
	public void UndateFromTableInMySQL(String table, String data, JTable tbl, String[] elements, String id) {
		try(Connection con = DatabaseConnection.getConnection()) {
			this.setTxt(table);
			this.setTxt(data);
			this.tbl = tbl;
			this.txtA = elements;
			this.setTxt(id);
			DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			int rows = model.getRowCount();
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < elements.length; j++) {
					elements[j] = model.getValueAt(i,j).toString(); 
				}
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("UPDATE ");
				stringBuilder.append(schema);
				stringBuilder.append(".");
				stringBuilder.append(table);
				stringBuilder.append(" SET ");
				stringBuilder.append(data);
				stringBuilder.append("WHERE ");
				stringBuilder.append(id);
				stringBuilder.append(" =?");
				String querySQL = stringBuilder.toString();
				PreparedStatement ps = con.prepareStatement(querySQL);
				for(int y = 0; y < elements.length-1; y++) {
					ps.setString(y+1,elements[y+1]);
				}
				ps.setString(elements.length, elements[0]);
				ps.executeUpdate();
				ps.close();
			}
			con.close();
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
	}//endUndateFromTableInMySQL
	
	//method UpdateInMySQL
	public void UpdateInMySQL( String[] elements,  String[] txtA, String table,String data, String object, String txtS) {
		
		this.setTxt(table);
		this.setTxt(data);
		this.setTxt(object);
		this.setTxt(txtS);
		this.txtA = elements;
		this.txtA = txtA;
		try (Connection con = DatabaseConnection.getConnection()) {
			for(int i = 0; i < elements.length; i++) {
				elements[i] = txtA[i];
			}
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("UPDATE ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(" SET ");
			stringBuilder.append(data);
			stringBuilder.append("WHERE ");
			stringBuilder.append(object);
			stringBuilder.append(" =?");
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			
			for(int i = 0; i < elements.length; i++) {
				ps.setString(i+1,elements[i]);
			}
			int id = Integer.parseInt(txtS);
			ps.setInt(elements.length + 1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(SQLException ex) {
				System.out.println(ex);
		}
	}//end method UpdateInMySQL
	
	//method DeleteInMySQL
	public void DeleteInMySQL(String table, String object, String txtS) {
		
		this.setTxt(table);
		this.setTxt(object);
		this.setTxt(txtS);
		try (Connection con = DatabaseConnection.getConnection()){
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM ");
			stringBuilder.append(schema);
			stringBuilder.append(".");
			stringBuilder.append(table);
			stringBuilder.append(" WHERE ");
			stringBuilder.append(object);
			stringBuilder.append(" =?");
			String querySQL = stringBuilder.toString();
			PreparedStatement ps = con.prepareStatement(querySQL);
			int id = Integer.parseInt(txtS);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
	}//end method DeleteInMySQL

	//method myRefreshClients();
	public static void myRefreshClients() {
		
		DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
		try (Connection con = DatabaseConnection.getConnection()) {
			mySql.getFromMySQL(variables.tableC,Homepage.tblClient, variables.colNameC);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}//end method myRefreshClients();
	
	//method myRefreshWarehouse();
	public static void myRefreshWarehouse() {
		DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
		try(Connection con = DatabaseConnection.getConnection()){
			mySql.getFromMySQL(variables.tableW,Homepage.tblWarehouse,variables.colNameP);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}//end method myRefreshWarehouse();
	
	//method myRefreshDatabase();
	public static void myRefreshDatabase() {
		DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
		try (Connection con = DatabaseConnection.getConnection()) {
			mySql.get2ConnectedTableFromMySQL(variables.columnsD, variables.tableC, variables.tableW, variables.idC, variables.idCp, Homepage.tblDatabase, variables.colNameD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}	//end method myRefreshDatabase();
	
	//method myRefreshTables();
	public static void myRefreshTables() {
		
		DatabaseHomepage.tblClient.setModel(new DefaultTableModel());
		DatabaseHomepage.tblWarehouse.setModel(new DefaultTableModel());
		DatabaseHomepage.tblDatabase.setModel(new DefaultTableModel());
		DatabaseHomepage.tblClient.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		DatabaseHomepage.tblWarehouse.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		DatabaseHomepage.tblDatabase.setFont(new Font(variables.txtFamily, variables.txtStyle, variables.txtSize));
		
		myRefreshClients();
		myRefreshWarehouse();
		myRefreshDatabase();
	}//end method myRefreshTables();
	
	//method myRefreshButtonsHomepage();
	public static void myRefreshButtonsHomepage() {
		DatabaseHomepage.btnClearTblClient.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		DatabaseHomepage.btnClearTblInventory.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		DatabaseHomepage.btnClearDatabase.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));
		DatabaseHomepage.btnClearAll.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));	
		DatabaseHomepage.btnUpdateClient.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));	
		DatabaseHomepage.btnUpdateInventory.setFont(new Font(variables.btnFamily, variables.btnStyle, variables.btnSize));	
	}//end method myRefreshButtonsHomepage
	
	
	//method myRefreshMenusHomepage();
	public static void myRefreshMenusHomepage() {
		DatabaseHomepage.menuBar.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnShow.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmShowClientList.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmShowInventory.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmShowDatabase.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmShowAll.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnFind.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmFindClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmFindProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnAdd.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmAddClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmAddProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnDelete.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize)); 
		DatabaseHomepage.mntmDeleteClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmDeleteProduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnUpdate.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmUpdateClient.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize)); 
		DatabaseHomepage.mntmUpdateproduct.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnFont.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmCambriaMath.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));
		
		DatabaseHomepage.mnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
		DatabaseHomepage.mntmBold.setFont(new Font(variables.mnFamily,  Font.BOLD, variables.mnSize));
		DatabaseHomepage.mntmItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
		
		DatabaseHomepage.mnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntm12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
		DatabaseHomepage.mntm14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
		DatabaseHomepage.mnm16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
		
		DatabaseHomepage.mnEdit.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnLabels.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnlblFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmLblCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmLblComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmLblConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnLblStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmLblPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
		DatabaseHomepage.mntmLblBold.setFont(new Font(variables.mnFamily,  Font.BOLD, variables.mnSize));
		DatabaseHomepage.mntmLblItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
		DatabaseHomepage.mnlblSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmLbl12.setFont(new Font(variables.mnFamily, variables.mnStyle,12));
		DatabaseHomepage.mntmLbl14.setFont(new Font(variables.mnFamily, variables.mnStyle,14));
		DatabaseHomepage.mnmLbl16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
		
		DatabaseHomepage.mnButton.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnBtnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmBtnCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmBtnComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmBtnConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnBtnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmBtnPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize));
		DatabaseHomepage.mntmBtnBold.setFont(new Font(variables.mnFamily,  Font.BOLD, variables.mnSize));
		DatabaseHomepage.mntmBtnItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
		DatabaseHomepage.mnBtnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmBtn12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
		DatabaseHomepage.mntmBtn14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
		DatabaseHomepage.mnmBtn16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
		
		DatabaseHomepage.mnMenu.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mnmnFamily.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmMnCambria.setFont(new Font("Cambria Math", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmMnComic.setFont(new Font("Comic Sans MS", variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmMnConsolas.setFont(new Font("Consolas", variables.mnStyle, variables.mnSize));;
		DatabaseHomepage.mnMnStyle.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmMnPlain.setFont(new Font(variables.mnFamily, Font.PLAIN, variables.mnSize)); 
		DatabaseHomepage.mntmMnBold.setFont(new Font(variables.mnFamily,  Font.BOLD, variables.mnSize));
		DatabaseHomepage.mntmMnItalic.setFont(new Font(variables.mnFamily, Font.ITALIC, variables.mnSize));
		DatabaseHomepage.mnMnSize.setFont(new Font(variables.mnFamily, variables.mnStyle, variables.mnSize));
		DatabaseHomepage.mntmMn12.setFont(new Font(variables.mnFamily, variables.mnStyle, 12));
		DatabaseHomepage.mntmMn14.setFont(new Font(variables.mnFamily, variables.mnStyle, 14));
		DatabaseHomepage.mnmMn16.setFont(new Font(variables.mnFamily, variables.mnStyle, 16));
		
	}//end method myRefreshMenusHomepage
	
	//getter and setter
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public JTable getTbl() {
		return tbl;
	}
	public void setTbl(JTable tbl) {
		this.tbl = tbl;
	}
	public String[] getTxtA() {
		return txtA;
	}
	public void setTxtA(String[] txtA) {
		this.txtA = txtA;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
}
