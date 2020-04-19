package com;
import model.Appointment;

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
@Path("/Appointments")
public class AppointmentService
{
Appointment Object1 = new Appointment();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readAppointment()
{
return Object1.readAppointment();
}


@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertAppointment(@FormParam("patientName") String patientName,
@FormParam("doctorName") String doctorName,
@FormParam("appointmentNumber") String appointmentNumber,
@FormParam("hospitalName") String hospitalName,
@FormParam("time") String time,
@FormParam("date") String date) throws SQLException
{
String output = Object1.insertAppointment(patientName, doctorName, appointmentNumber, hospitalName, time, date);
return output;
}




@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateAppointment(String appointmentData)
{
//Convert the input string to a JSON object
JsonObject Objecttwo = new JsonParser().parse(appointmentData).getAsJsonObject();
//Read the values from the JSON object
String appointmentID = Objecttwo.get("appointmentID").getAsString();
String patientName = Objecttwo.get("patientName").getAsString();
String doctorName = Objecttwo.get("doctorName").getAsString();
String appointmentNumber = Objecttwo.get("appointmentNumber").getAsString();
String hospitalName = Objecttwo.get("hospitalName").getAsString();
String time = Objecttwo.get("time").getAsString();
String date = Objecttwo.get("date").getAsString();
String output = Object1.updateAppointment(appointmentID, patientName, doctorName, appointmentNumber, hospitalName, time, date);

return output;
}


@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deleteAppointment(String appointmentData)
{
//Convert the input string to an XML document
Document doc = Jsoup.parse(appointmentData, "", Parser.xmlParser());
//Read the value from the element <itemID>
String appointmentID = doc.select("appointmentID").text();
String output = Object1.deleteAppointment(appointmentID);
return output;
}


}