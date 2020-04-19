package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.database;

public class card {
	private int CID;
	private int paymentID;
	private String cname;
	private String ctype;
	private String cardNo;
	private int cvv;
	private String expDate;
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public  static int cardInsert(card  p) {
		int result=0;
		try {
			Connection con = database.getConnection();
			
			String query = " insert into card (`paymentID`,`cname`,`ctype`,`cardNo`,`cvv`,`expDate`)" + " values (?,?,?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1,p.getPaymentID());
			preparedStmt.setString(2,p.getCname());
			preparedStmt.setString(3, p.getCtype());
			preparedStmt.setString(4, p.getCardNo());
			preparedStmt.setInt(5,p.getCvv());
			preparedStmt.setString(6,p.getExpDate());
		
			result= preparedStmt.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String addCard(String paymentID, String cname, 
			String ctype, String cardNo, String cvv, String expDate )
	{
		String output = "";
	try
	{
		Connection con = database.getConnection();
	if (con == null)
	{return "Error while connecting to the database for inserting."; }
	// create a prepared statement
	String query = " insert into card (`paymentID`,`cname`,`ctype`,`cardNo`,`cvv`,`expDate`)" + " values (?,?,?, ?, ?, ?)";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	
	preparedStmt.setString(1, paymentID);
	preparedStmt.setString(2, cname);
	preparedStmt.setString(3, ctype);
	preparedStmt.setString(4, cardNo);
	preparedStmt.setString(5, cvv);
	preparedStmt.setString(6, expDate);
	
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
