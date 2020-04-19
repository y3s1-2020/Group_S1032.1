package model;

import java.sql.*;



public class Hospital {

	


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






public String insertHospital(String code, String name, String type, String number, String desc, String place) throws SQLException{
	 
		
	String output = "";
		
		
	try {
	
		Connection con = connect();
		
		if(con == null)
		{
			return "Error while connecting to the database";
		}
		
	
				
				String query = "insert into `hospitaltable`(`hospitalID`, `hospitalCode`, `hospitalName`, `hospitalType`, `hospitalNumber`, `hospitalDesc`, `hospitalPlace`) VALUES  (?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
		
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, code);
				preparedStmt.setString(3, name);
				preparedStmt.setString(4, type);
				preparedStmt.setInt(5, Integer.parseInt(number));
				preparedStmt.setString(6, desc);
				preparedStmt.setString(7, place);
				preparedStmt.execute();
				con.close();
				output = "Data Inserted";
				
			
	}catch(Exception e){
		
		output = "Error while inserting";
		
		System.err.println(e.getMessage());
	}
	 
	return output;
 }
	
	





public String readHospital(){
		
	String output = ""; 
		
	try {
			
		Connection con = connect();
			
		if(con == null)
		{
			return "Error while connecting to the database for reading.";
		}
			
		output = "<table border=\"1\"><tr><th>Hospital Code</th>"
					+"<th>Hospital Name</th>"
					+"<th>Hospital Type</th>"
					+"<th>Hospital Number</th>"
					+"<th>Description</th>"
					+"<th>Location</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			
		String query = "select * from hospitaltable";
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);	
		
		while (rs.next())
		{
			String hospitalID    = Integer.toString(rs.getInt("hospitalID"));
			String hospitalCode    = rs.getString("hospitalCode");
			String hospitalName  = rs.getString("hospitalName");
			String hospitalType  = rs.getString("hospitalType");
			String hospitalNumber = Integer.toString(rs.getInt("hospitalNumber"));
			String hospitalDesc  = rs.getString("hospitalDesc");
			String hospitalPlace  = rs.getString("hospitalPlace");
			
			// Add into the html table
			output += "<tr><td>" + hospitalCode + "</td>";
			output += "<td>" + hospitalName + "</td>";
			output += "<td>" + hospitalType + "</td>";
			output += "<td>" + hospitalNumber + "</td>";
			output += "<td>" + hospitalDesc + "</td>";
			output += "<td>" + hospitalPlace + "</td>";
			
			// buttons
			output += "<td><input name=\"btnUpdate\" "
			+ " type=\"button\" value=\"Update\"></td>"
			+ "<td><form method=\"post\" action=\"hospitals.jsp\">"
			+ "<input name=\"btnRemove\" "
			+ " type=\"submit\" value=\"Remove\">"
			+ "<input name=\"hospitalID\" type=\"hidden\" "
			+ " value=\"" + hospitalID + "\">" + "</form></td></tr>";
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
	



public String updateHospital(String Id, String code, String name, String type, String number, String desc, String place){
	
	

	
	String output = "";
	
	try{
		
		Connection con = connect();
		if (con == null)
		{
			return "Error while connecting to the database for updating."; 
		}
		

		
		String query = "update hospitaltable set hospitalCode=?,hospitalName=?,hospitalType=?,hospitalNumber=?,hospitalDesc=?,hospitalPlace=? WHERE hospitalID=?";
		

		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, code);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, type);
		preparedStmt.setInt(4, Integer.parseInt(number));
		preparedStmt.setString(5, desc);
		preparedStmt.setString(6, place);
		preparedStmt.setInt(7, Integer.parseInt(Id));

		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Updated";
	  
	 }catch (Exception e){
		 
		output = "Error while updating.";
		System.err.println(e.getMessage());
	 }
	
   return output;
	
}
	


public String deleteHospital(String hospitalID){

String output = "";
try {
	
	 Connection con = connect();
	 if (con == null)
	 {
	 	return "Error while connecting to the database for deleting.";
	 }
	 // create a prepared statement
	 String query = "delete from hospitaltable where hospitalID = ?";
	 PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(hospitalID));
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
