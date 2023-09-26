package mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionProvider {//singleton class
	//inhertance is not possible due to final
	static Connection con=null;
	private ConnectionProvider(){
		//now no object will be created
	}
	
	public static Connection getConnection() {
		//		try {
		//			Class.forName("com.mysql.cj.jdbc.Driver");//database connection of mysql
		//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AndroLoginRegistration","root", "Root@123");
		//		} 
		//		catch (ClassNotFoundException | SQLException e) {
		//			
		//			e.printStackTrace();
		//		}
		//or
		if(con==null) {
			try {
				Class.forName(DbConnectionData.DATABASE_DRIVER);//database connection of mysql
				con = DriverManager.getConnection(DbConnectionData.DATABASE_URL,DbConnectionData.DATABASE_USER,DbConnectionData.DATABASE_PASS);
			} 
			catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		}
		return con;

	}

}
