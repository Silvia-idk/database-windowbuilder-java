import java.awt.Font;

public class variables {
	
	public static String tableC = "clients";
	public static String tableW = "warehouse";
	
	public static String idC = "idClient";
	public static String idP = "idProduct";
	public static String idCp = "idClientP";
	
	public static String[] colNameP = {"Product's ID", "Product's name", "Category", "Client's ID"};
	public static String[] colNameC = {"Client's ID", "Client's name", "Client's surname", "E-mail", "Phone number"};
	public static String[] colNameD = {"Product's ID", "Product's name", "Category", "Client's ID", "Client's name", "Client's surname", "E-mail", "Phone number"};
	public static String columnsD = "idProduct, productName, category, idClient, clientName, clientSurname, clientMail, phoneNumber";
	
	public static int txtSize = 12; //default size text
	public static String txtFamily = "Cambria Math";//default family text
	public static int txtStyle = Font.PLAIN; //default style text
	
	public static int lblSize = 12; //default size labels
	public static String lblFamily = "Cambria Math";//default family labels
	public static int lblStyle = Font.PLAIN; //default style labels
	
	public static int mnSize = 14; //default size menu
	public static String mnFamily = "Cambria Math";//default family menu
	public static int mnStyle = Font.PLAIN; //default style menu
	
	public static int btnSize = 14; //default size buttons
	public static String btnFamily = "Cambria Math";//default family buttons
	public static int btnStyle = Font.PLAIN; //default style buttons
	
	public static String[] elementsC = {"clientName", "clientSurname", "clientMail", "phoneNumber"};
	public static String dataC = "clientName, clientSurname, clientMail , phoneNumber";
	public static String nValuesC = "?,?,?,?";
	
	public static String[] elementsP = {"productName", "category", "idClientP"}; 
	public static String dataP = "productName, category, idClientP";
	public static String nValuesP = "?,?,?";
}
