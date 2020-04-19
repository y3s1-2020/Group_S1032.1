package controller;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.payment;

@Path("/paymentService")
public class paymentService {
	payment p=new payment();
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String AddPayment(@FormParam("patientName") String patientName, @FormParam("appoimentDate") String appoimentDate,
			@FormParam("doctorName") String doctorName, @FormParam("hosName") String hosName,@FormParam("hosFees") String hosFees,
			@FormParam("doctorfees") String doctorfees,@FormParam("total") String total,
			@FormParam("paydate") String paydate,@FormParam("appoiment") String appoiment) {
		String output = p.addPayment(patientName, appoimentDate,doctorName, hosName, hosFees, doctorfees, 
				total, paydate,appoiment );
		return output;
	}
	
}