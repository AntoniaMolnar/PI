package Snakepack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

public static Connection CreateConnection()  {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	try {
	    Class.forName(driver);
	} 
	
	catch (ClassNotFoundException e) {
	  
	    e.printStackTrace();
	} 
	String url="jdbc:sqlserver://bd2021.database.windows.net;databaseName=eduardmatei;";

	String user="eduardmateiuser";
	String password="Y-$aWWNvA7JfXRQY";
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(url, 
		       user,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	
			

return conn;	
}
}
