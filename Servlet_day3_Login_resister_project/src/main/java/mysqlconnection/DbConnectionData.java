package mysqlconnection;

public interface DbConnectionData {
	//com.mysql.jdbc.Driver-depricated
	public static final String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DATABASE_URL="jdbc:mysql://localhost:3306/AndroLoginRegistration";
	public static final String DATABASE_USER="root";
	public static final String DATABASE_PASS="Root@123";

}
//database name is mot case sensetive