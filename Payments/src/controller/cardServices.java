package controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.card;



import javax.ws.rs.FormParam;
@Path("/cardServices")
public class cardServices {
	
	card c=new card();

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String AddCard(@FormParam("paymentID") String paymentID, @FormParam("cname") String cname,
			@FormParam("ctype") String ctype, @FormParam("cardNo") String cardNo,@FormParam("cvv") String cvv,
			@FormParam("expDate") String expDate
		) {
		String output = c.addCard(paymentID, cname,ctype, cardNo, cvv, expDate);
		return output;
	}
	
}
