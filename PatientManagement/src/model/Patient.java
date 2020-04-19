package model;

import java.sql.*;

public class Patient {

	public Connection connect() {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojectdb","root", "");		
			System.out.println("Successfully connected");
			
		} catch (Exception e) {
			System.out.println("DB connection Faild");
			
		}
		return con;
	}
	
	
	
	public String readPatient() {
		
		String output = ""; 
		
		try {
				
			Connection con = connect();
				
			if(con == null)
			{
				return "Error while connecting to the database for reading.";
			}
				
			output = "<table border=\"1\"><tr>"
						+ "<th>First Name</th>"
						+"<th>Last Name</th>"
						+"<th>Full Name</th>"
						+"<th>Address</th>"
						+"<th>Sex</th>"
						+"<th>Contac Number</th>"
						+"<th>Age</th>"
						+"<th>NIC</th>"
						+"<th>DOB</th>"
						+ "<th>Update</th><th>Remove</th></tr>";
				
				
			String query = "select * from patienttable";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);	

			while (rs.next())
			{
				String patientID    = Integer.toString(rs.getInt("patientID"));
				String firstName    = rs.getString("firstName");
				String lastName  = rs.getString("lastName");
				String fullName  = rs.getString("fullName");
				String address  = rs.getString("address");
				String sex  = rs.getString("sex");
				String cNumber = Integer.toString(rs.getInt("cNumber"));
				String age = Integer.toString(rs.getInt("age"));
				String nic  = rs.getString("nic");
				String dob  = rs.getString("dob");
				
				
				// Add into the HTML table
				output += "<tr><td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + fullName + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + sex + "</td>";
				output += "<td>" + cNumber + "</td>";
				output += "<td>" + age + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + dob + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" "
				+ " type=\"button\" value=\"Update\"></td>"
				+ "<td><form method=\"post\" action=\"patients.jsp\">"
				+ "<input name=\"btnRemove\" "
				+ " type=\"submit\" value=\"Remove\">"
				+ "<input name=\"patientID\" type=\"hidden\" "
				+ " value=\"" + patientID + "\">" + "</form></td></tr>";
			}
				
			con.close();
			// Complete the HTML table
			output += "</table>";
				
			}catch (Exception e) {
				
				// TODO: handle exception
				output = "Error";
				System.err.println(e.getMessage());
			}
		
			return output;
	}
	
	
	
	
	

	public String insertPatient(String fname, String lname, String funame, String paddress, String psex, String pcontac, String age, String pnic, String pdob) throws SQLException{
		 
		String output = "";
			
			try {
		
			Connection con = connect();
			
			if(con == null)
			{
				return "Error while connecting to the database";
			}
			
					String q = "insert into `patienttable`(`patientID`, `firstName`, `lastName`, `fullName`, `address`, `sex`, `cNumber`, `age`, `nic`, `dob`) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(q);
			
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, fname);
					preparedStmt.setString(3, lname);
					preparedStmt.setString(4, funame);
					preparedStmt.setString(5, paddress);
					preparedStmt.setString(6, psex);
					preparedStmt.setInt(7, Integer.parseInt(pcontac));
					preparedStmt.setString(8, age);
					preparedStmt.setString(9, pnic);
					preparedStmt.setString(10, pdob);
					preparedStmt.execute();
					con.close();
					output = "Inserted";
				
		}catch(Exception e){
			
			output = "Error while inserting";
			
			System.err.println(e.getMessage());
		}
		 
		return output;
	 }

	
	
	
	
	public String updatePatient(String pID, String fname, String lname, String funame, String paddress, String psex, String pcontac, String age, String pnic, String pdob){
		
		String output = "";
		
		try{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for updating."; 
			}
		
			String query = "update patienttable set firstName=?,lastName=?,fullName=?,address=?,sex=?,cNumber=?,age=?,nic=?,dob=? WHERE patientID=?";


			PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
			preparedStmt.setString(1, fname);
			preparedStmt.setString(2, lname);
			preparedStmt.setString(3, funame);
			preparedStmt.setString(4, paddress);
			preparedStmt.setString(5, psex);
			preparedStmt.setInt(6, Integer.parseInt(pcontac));
			preparedStmt.setInt(7, Integer.parseInt(age));
			preparedStmt.setString(8, pnic);
			preparedStmt.setString(9, pdob);
			preparedStmt.setInt(10, Integer.parseInt(pID));

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
	
	
	

	public String deletePatient(String pID){
		
		String output = "";
		try {
			
			 Connection con = connect();
			 if (con == null)
			 {
			 	return "Error while connecting to the database for deleting.";
			 }
			 	// create a prepared statement
			 String query = "delete from patienttable where patientID = ?";
			 PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			 	// binding values
			 preparedStmt.setInt(1, Integer.parseInt(pID));
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
