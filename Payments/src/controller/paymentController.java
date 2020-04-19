package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import model.payment;

/**
 * Servlet implementation class paymentController
 */
@WebServlet("/paymentController")
public class paymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String save=request.getParameter("Submit");
		
		if(save.equals("Submit")) {
			
		 	
		 	
		 	
	        String patientName = request.getParameter("patientName");
	        String appoimentDate = request.getParameter("appoimentDate");
	        String doctorName = request.getParameter("doctorName");
	        String hosName = request.getParameter("hosName");
	       
	        String hosFees = request.getParameter("hosFees");
		 	//int hfee=Integer.parseInt(hosFees);

		 	String docfee=request.getParameter("doctorfee");
		 	//int docf=Integer.parseInt(docfee);

		 	String total = request.getParameter("total");
		 //	int tot=Integer.parseInt(total);
		 	
		 	String paydate=request.getParameter("paydate");
		 	String app = request.getParameter("appo");
		 	//int apoi=Integer.parseInt(app);
		 	
		 	paymentService s= new paymentService();
		 	
		 	 String r=s.AddPayment(patientName, appoimentDate, doctorName, hosName, hosFees, docfee, total, paydate, app);
	        
	  
	        	out.println("<script>window.location.href='http://localhost:8080/IT15113214/views/card.jsp';</script>");
	        
	      
		}
	}

}
