package getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String url="jdbc:mysql://127.0.0.1:3306/test";
	private static String user="root";
	private static String password="123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
		
	}
//	public static void main(String[] args) throws SQLException {
//		System.out.println(getConnection());
//	}
}
