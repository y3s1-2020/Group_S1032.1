package com;
import model.Doctor;

import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Doctors")
public class DoctorService
{
	Doctor doctorobject1 = new Doctor();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String read()
	{
		return doctorobject1.read();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insert(@FormParam("doctorName") String doctorName,
	@FormParam("doctorSpecialization") String doctorSpecialization) throws SQLException
	{
		String output = doctorobject1.insert(doctorName, doctorSpecialization);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String doctorData)
	{
		//Convert the input string to a JSON object
		JsonObject doctorobject2 = new JsonParser().parse(doctorData).getAsJsonObject();
		//Read the values from the JSON object
		String doctorID = doctorobject2.get("doctorID").getAsString();
		String doctorName = doctorobject2.get("doctorName").getAsString();
		String doctorSpecialization = doctorobject2.get("doctorSpecialization").getAsString();
		String output;
		output = doctorobject1.updateDoctor(doctorID, doctorName, doctorSpecialization);
		return output;
	
	}
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(String doctorData)
	{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());
		//Read the value from the element <itemID>
		String doctorID = doc.select("doctorID").text();
		String output;
		output = doctorobject1.delete(doctorID);
		return output;
	}

}