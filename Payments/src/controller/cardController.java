package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.card;

/**
 * Servlet implementation class cardController
 */
@WebServlet("/cardController")
public class cardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String save=request.getParameter("Submit");
		
		if(save.equals("Submit")) {
			
			
			String p=request.getParameter("payed");
			
	        String cname = request.getParameter("cname");
	        String ctype = request.getParameter("ctype");
	        
	        String cardNo = request.getParameter("cardNo");
		 	

		 	String cvvv = request.getParameter("cvvno");
		 

		 	String expDate = request.getParameter("expDate");
		 	
		 	
		 	
		 
			
			  
		 	cardServices c= new cardServices();
		 	String s=c.AddCard(p, cname, ctype, cardNo, cvvv, expDate);
		 	
	
		   
		        	out.println("<script>alert('payed');window.location.href='http://localhost:8080/IT15113214/views/invoice.jsp';</script>");
		        	
		      
		 	
		 	
		}
	}

}
