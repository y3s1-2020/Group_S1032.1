package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.database;

public class payment {
	private int paymentID;
	private int appoimentID;
	private String appoimentDate;
	private String patientName;
	private String doctorName;
	private String hosName;
	private int hosFees;
	private int doctorfees;
	private int total;
	private String paydate;
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
	public String getAppoimentDate() {
		return appoimentDate;
	}
	public void setAppoimentDate(String appoimentDate) {
		this.appoimentDate = appoimentDate;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public int getHosFees() {
		return hosFees;
	}
	public void setHosFees(int hosFees) {
		this.hosFees = hosFees;
	}
	public int getDoctorfees() {
		return doctorfees;
	}
	public void setDoctorfees(int doctorfees) {
		this.doctorfees = doctorfees;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public int getAppoimentID() {
		return appoimentID;
	}
	public void setAppoimentID(int appoimentID) {
		this.appoimentID = appoimentID;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	
	public  static int paymentInsert(payment  p) {
		int result=0;
		try {
			Connection con = database.getConnection();
			
			String query = " insert into payment ( `patientName`,`appoimentDate`,`doctorName`,`hosName`,`hosFees`,`doctorfees`,`total`,`paydate`,`appoiment`)" + " values ( ?,?,?,?, ?, ?, ?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
	
			preparedStmt.setString(1, p.getPatientName());
			preparedStmt.setString(2, p.getAppoimentDate());
			preparedStmt.setString(3,p.getDoctorName());
			preparedStmt.setString(4,p.getHosName());
			preparedStmt.setInt(5,p.getHosFees());
			preparedStmt.setInt(6,p.getDoctorfees());
			preparedStmt.setInt(7,p.getTotal());
			preparedStmt.setString(8,p.getPaydate());
			preparedStmt.setInt(9,p.getAppoimentID());
			result= preparedStmt.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String addPayment(String patientName, String appoimentDate, 
			String doctorName, String hosName, String hosFees, String doctorfees, 
			String total,String paydate, String appoiment )
	{
		String output = "";
	try
	{
		Connection con = database.getConnection();
	if (con == null)
	{return "Error while connecting to the database for inserting."; }
	// create a prepared statement
	String query = " insert into payment ( `patientName`,`appoimentDate`,`doctorName`,`hosName`,`hosFees`,`doctorfees`,`total`,`paydate`,`appoiment`)" + " values ( ?,?,?,?, ?, ?, ?,?,?)";
	PreparedStatement preparedStmt = con.prepareStatement(query);

	// binding values
	
	preparedStmt.setString(1, patientName);
	preparedStmt.setString(2, appoimentDate);
	preparedStmt.setString(3, doctorName);
	preparedStmt.setString(4, hosName);
	preparedStmt.setString(5, hosFees);
	preparedStmt.setString(6, doctorfees);
	preparedStmt.setString(7, total);
	preparedStmt.setString(8, paydate);
	preparedStmt.setString(9, appoiment);
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Inserted successfully";
	}
	catch (Exception e)
	{
	output = "Error while inserting the patient detail.";
	System.err.println(e.getMessage());
	}
	return output;
	}
}



