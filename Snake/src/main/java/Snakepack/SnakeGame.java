package Snakepack;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class SnakeGame {
	public static Connection conn=DBConnection.CreateConnection();
	public static int CurrentUser=-1;
	public static  int PointsPerApp=150;
	public static String ColorPickerMode=null;
	public static int SnakeR=235;
	public static int SnakeG=119;
	public static int SnakeB=52;
	public static int MapR=56;
	public static int MapG=43;
	public static int MapB=36;
	public static int Points=0;
	public static int speed=100;
	public static String UserName=null;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
	
		   Statement stmt= conn.createStatement();
		
		   
		  
		   String CheckDatabase="IF (EXISTS (SELECT *"
		   		+ "   FROM INFORMATION_SCHEMA.TABLES"
		   		+ "   WHERE TABLE_SCHEMA = 'dbo'"
		   		+ "   AND TABLE_NAME = '"+"SnakeUser"+"'))"
		   		+ "   BEGIN "
		   		+"WAITFOR DELAY '00:00:00'"
		   		+ "   END;"
		   		+ "ELSE"
		   		+ "   BEGIN"
		   		+ " CREATE TABLE ["+"SnakeUser"+"]("
		   		+ " [user_id] int IDENTITY(1,1) NOT NULL,"
		   		+ " [username] varchar(25) NOT NULL,"
		   		+ " [password] varchar(30) NOT NULL,"
		   		
		   		+ ");"
		   		+ "   END;";
	System.out.println(CheckDatabase);
	stmt.execute(CheckDatabase);
	 
	   String CheckDatabase2="IF (EXISTS (SELECT *"
	   		+ "   FROM INFORMATION_SCHEMA.TABLES"
	   		+ "   WHERE TABLE_SCHEMA = 'dbo'"
	   		+ "   AND TABLE_NAME = '"+"SnakeScor"+"'))"
	   		+ "   BEGIN "
	   		+"WAITFOR DELAY '00:00:00'"
	   		+ "   END;"
	   		+ "ELSE"
	   		+ "   BEGIN"
	   		+ " CREATE TABLE ["+"SnakeScor"+"]("
	   		+ " [user_id] int NOT NULL,"
	   		+ " [points] int NOT NULL,"
	   		
	   		
	   		+ ");"
	   		+ "   END;";
System.out.println(CheckDatabase2);
stmt.execute(CheckDatabase2);
	
	LogIn.showWindow();
	}
	
	
	
}
