package com;

import model.Patient;
import java.sql.SQLException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


@Path("/Patients")
public class PatientService {

	Patient p1 = new Patient();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient()
	{
			return p1.readPatient();
	}

	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("fullName") String fullName,
			@FormParam("address") String address,
			@FormParam("sex") String sex,
			@FormParam("cNumber") String cNumber,
			@FormParam("age") String age,
			@FormParam("nic") String nic,
			@FormParam("dob") String dob) throws SQLException 
		{
			String output = p1.insertPatient(firstName, lastName, fullName, address, sex, cNumber, age, nic, dob);
			return output;
		}
	
	
	

@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String patientData)
	{
			//Convert the input string to a JSON object
		JsonObject p2 = new JsonParser().parse(patientData).getAsJsonObject();
		
			//Read the values from the JSON object
		String patientID = p2.get("patientID").getAsString();
		String firstName = p2.get("firstName").getAsString();
		String lastName = p2.get("lastName").getAsString();
		String fullName = p2.get("fullName").getAsString();
		String address = p2.get("address").getAsString();
		String sex = p2.get("sex").getAsString();
		String cNumber = p2.get("cNumber").getAsString();
		String age = p2.get("age").getAsString();
		String nic = p2.get("nic").getAsString();
		String dob = p2.get("dob").getAsString();
		String output = p1.updatePatient(patientID,firstName, lastName, fullName, address, sex, cNumber, age, nic, dob);

		return output;
	}


@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData)
	{
			//Convert the input string to an XML document
		Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());
			//Read the value from the element <itemID>
		String patientID = doc.select("patientID").text();
		String output = p1.deletePatient(patientID);
		return output;
	}



}
