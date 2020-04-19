package com;
import model.Hospital;


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
@Path("/Hospitals")
public class HospitalService
{
Hospital hospitalobj = new Hospital();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readHospital()
{
	return hospitalobj.readHospital();
}



@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertHospital(@FormParam("hospitalCode") String hospitalCode,
@FormParam("hospitalName") String hospitalName,
@FormParam("hospitalType") String hospitalType,
@FormParam("hospitalNumber") String hospitalNumber,
@FormParam("hospitalDesc") String hospitalDesc,
@FormParam("hospitalPlace") String hospitalPlace) throws SQLException
{
String output = hospitalobj.insertHospital(hospitalCode, hospitalName, hospitalType, hospitalNumber, hospitalDesc, hospitalPlace);
return output;
}




@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateHospital(String hospitalData)
{
//Convert the input string to a JSON object
JsonObject hosptitalobj2 = new JsonParser().parse(hospitalData).getAsJsonObject();
//Read the values from the JSON object
String hospitalID = hosptitalobj2.get("hospitalID").getAsString();
String hospitalCode = hosptitalobj2.get("hospitalCode").getAsString();
String hospitalName = hosptitalobj2.get("hospitalName").getAsString();
String hospitalType = hosptitalobj2.get("hospitalType").getAsString();
String hospitalNumber = hosptitalobj2.get("hospitalNumber").getAsString();
String hospitalDesc = hosptitalobj2.get("hospitalDesc").getAsString();
String hospitalPlace = hosptitalobj2.get("hospitalPlace").getAsString();
String output = hospitalobj.updateHospital(hospitalID, hospitalCode, hospitalName, hospitalType, hospitalNumber, hospitalDesc, hospitalPlace);

return output;
}



@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deleteHospital(String hospitalData)
{
//Convert the input string to an XML document
Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());
//Read the value from the element <itemID>
String hospitalID = doc.select("hospitalID").text();
String output = hospitalobj.deleteHospital(hospitalID);
return output;
}


}