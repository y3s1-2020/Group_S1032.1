package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class database {
	public static Connection getConnection(){
		   Connection connection=null;
		   System.out.println("Connection called");
		  try {
		    Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helthcare","root", "");
		  } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		    return connection;
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   System.out.println(database.getConnection());
		
		
	}
	
	
}
