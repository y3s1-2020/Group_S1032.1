package model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor{
	
public Connection connect() {
 
	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojectdb","root", "");		
		System.out.println("Successfully connected");	
	}catch(Exception e){
		System.out.println(e);
	}
	return con;
	}
	
public String insert(String dname, String dspecialization) throws SQLException{
	 
	String output = "";
		
	try {
		Connection con = connect();
		
		if(con == null)
		{
			return "Error while connecting to the database";
		}
		
		String query = "insert into `doctable`(`doctorID`, `doctorName`, `doctorSpecialization`) VALUES  (?, ?, ?)";
				
		PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
		
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, dname);
		preparedStmt.setString(3, dspecialization);
		preparedStmt.execute();
		con.close();
		output = "Data Inserted";
	}catch(Exception e){
		
		output = "Error while inserting";
		
		System.err.println(e.getMessage());
	}
	return output;
 }
	
	

public String read(){
		
	String output = ""; 
		
	try {
			
		Connection con = connect();
			
		if(con == null)
		{
			return "Error while connecting to the database for reading.";
		}
			
		output = "<table border=\"1\"><tr><th>Doctor Name</th>"
					+"<th>Doctor Specialization</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			
		String query = "select * from doctable";
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);	
		
		while (rs.next())
		{
			String doctorID    = Integer.toString(rs.getInt("doctorID"));
			String doctorName    = rs.getString("doctorName");
			String doctorSpecialization  = rs.getString("doctorSpecialization");
			
			
			// Add into the html table
			output += "<tr><td>" + doctorName + "</td>";
			output += "<td>" + doctorSpecialization + "</td>";
			
			
			
			// buttons
			output += "<td><input name=\"btnUpdate\" "
			+ " type=\"button\" value=\"Update\"></td>"
			+ "<td><form method=\"post\" action=\"doctors.jsp\">"
			+ "<input name=\"btnRemove\" "
			+ " type=\"submit\" value=\"Remove\">"
			+ "<input name=\"doctorID\" type=\"hidden\" "
			+ " value=\"" + doctorID + "\">" + "</form></td></tr>";
		}
			
		con.close();
		// Complete the html table
		output += "</table>";
			
		}catch (Exception e) {
			
			// TODO: handle exception
			output = "Error";
			System.err.println(e.getMessage());
		}
		
		
		return output;
 }
	
	
	
	
public String updateDoctor(String dID, String dname, String dspecialization){
	
	
	
	String output = "";
	
	try{
		
		Connection con = connect();
		if (con == null)
		{
			return "Error while connecting to the database for updating."; 
		}
		// create a prepared statement
		String query = "update doctable set doctorName=?,doctorSpecialization=? WHERE doctorID=?";
		
		
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, dname);
		preparedStmt.setString(2, dspecialization);
		preparedStmt.setInt(3, Integer.parseInt(dID));
	
		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Data Updated";
	  
	 }catch (Exception e){
		 
		output = "Error while updating.";
		System.err.println(e.getMessage());
	 }
	
   return output;
	
}
	
	
public String delete(String dID){
	
	String output = "";
	try {
		
		 Connection con = connect();
		 if (con == null)
		 {
		 	return "Error while connecting to the database for deleting.";
		 }
		 // create a prepared statement
		 String query = "delete from doctable where doctorID = ?";
		 PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(dID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted";
		
	   }catch (Exception e){
		   
		output = "Error";
		System.err.println(e.getMessage());
		
	   }
	 return output;
		
}
	
	

}