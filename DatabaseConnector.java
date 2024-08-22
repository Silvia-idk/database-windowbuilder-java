import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static String hostName = "127.0.0.1";
	private static String port = "3306";
	private static String schema = "database";
    private static final String URL = "jdbc:mysql://" + hostName +":"+ port + "/" + schema;
    private static final String USER = "root";
    private static final String PASSWORD = "Database";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER , PASSWORD);
    }
}
