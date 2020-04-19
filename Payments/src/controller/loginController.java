package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.database;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String dbuname = null, dbpassword = null, dbUid = null;
		
		Connection conn = database.getConnection();
		String sql = "select patientID,username,password from patient where username='"
				+ username + "'";
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int count = 0;
			
			
			while (rs.next()) {

				dbUid = (rs.getString(1));
				dbuname = (rs.getString(2));
				dbpassword = (rs.getString(3));
				
				count += 1;
			}
			if (count == 1 && dbuname.equals(username)
					&& dbpassword.equals(password)) {
				HttpSession session = request.getSession();

				
				session.setAttribute("username", dbuname);
				session.setAttribute("password", dbpassword);
				
			
				response.sendRedirect("views/patient.jsp");
				 

			}
			else if (count == 1 && dbuname.equals(username)
					&& !dbpassword.equals(password)) {
				out.println("Password worng");
				response.sendRedirect("views/login.jsp" );
			}

			else  {
			
				response.sendRedirect("view/login.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
