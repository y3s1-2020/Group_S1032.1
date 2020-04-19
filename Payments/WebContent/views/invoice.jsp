<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="db.database"%>
<%@ page import="java.sql.*"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<style>

  table{
  	 	 font-weight: 300;
	 	 line-height: 40px;
	  
		 margin: auto;
   		 width: 50%;
   		 border: 3px solid green;
   		 padding: 100px;
   
   
	 }

 td {
   
    text-align: left;
    padding: 8px;
  
}

input[type=submit],input[type=reset] {
    width: 45%;
    height: 60px;
    background-color: blue;
    color: white;
   	left:50px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  
}

input[type=text],input[type=email] ,input[type=file]  {
    width: 70%;
    height: 35px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
</style>
<meta charset="ISO-8859-1">

<meta charset="utf-8" />
<link rel="icon" type="image/png" href="../font/assets/img/favicon.ico">
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Patient</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="../font/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="../font/assets/css/animate.min.css" rel="stylesheet"/>
<link href="../font/assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>
<link href="../font/assets/css/demo.css" rel="stylesheet" />
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
<link href="../font/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>

<body>
 <script src="../font/assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="../font/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="../font/assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../font/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="../font/assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="../font/assets/js/demo.js"></script>


	<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con =database.getConnection();
	String username = (String) session.getAttribute("username");

	PreparedStatement ps = con.prepareStatement("select * from patient where username=?");

	ps.setString(1, username);
	ResultSet rs = ps.executeQuery();

	if (null == username) {
		response.sendRedirect("login.jsp");
	}

	if (rs.next()) {
		username = rs.getString("username");
		//out.print("<b><span style='color:white;'>&nbsp;&nbsp;Hi&nbsp;  " + uname + "</span></b>");
	} else {
		username = "";

		//out.print("<b><span style='color:white;'>&nbsp;&nbsp;" + uname + "</span></b>");
	}
				%>
 
 <div class="wrapper">
 	<div class="sidebar" data-color="blue">
 		<div class="sidebar-wrapper">
 			<div class="logo">
                <a href="#" class="simple-text pe-7s-home ">
				<b>	Patient</b>
                </a>
            </div>
             <ul class="nav">
                <li class="active">
                    <a href="dashboard.jsp">
                        <i class="pe-7s-graph"></i>
                         Dashboard
                      
                    </a>
                </li>
               
               
              
            
                <li>
                    <a href="paymentHistory.jsp">
                        <i class="pe-7s-cash"></i>
                        Payment
                    </a>
                </li>
               
            </ul>
            
 		</div>
 	</div>
 	 <div class="main-panel">
 	 	 <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"></a>
                </div>
                <div class="collapse navbar-collapse">
                  <ul class="nav navbar-nav navbar-right">
                        <li> <a >Welcome <%=username %></a></li>
                         <li><a href="../Employee/employeeUserProfile.jsp">Profile</a> </li>
                        <li><a href="../controller/logoutcontroller.jsp">Log Out</a></li>
				  </ul>
                </div>
            </div>
        </nav>
    
    	
    	 <form action="" method=""   >
								<table >
								<%  
								String appoimentDate;
								String patientName;
								String doctorName;
								String hosName;
								int hosFees;
								int doctorfees;
								int total;
								String createDate;
								String hosAddress;
								int hosPhone;
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn =database.getConnection();
								String name = (String) session.getAttribute("username");
								

								PreparedStatement pss = conn.prepareStatement("select *,sum(hosFees+doctorfees)  from appoiment,patient,hospital,doctor where  username=? and pid=patientID and hid=hosID and did=doctorID and createDate=DATE(NOW())");

								pss.setString(1, name);
								ResultSet rss = pss.executeQuery();
								
								
								while(rss.next()){
									
									hosName=rss.getString("hosName");
									doctorName=rss.getString("doctorName");
									patientName=rss.getString("patientName");
									
									appoimentDate=rss.getString("appoimentDate");
									
									
									hosFees=rss.getInt("hosFees");
									doctorfees=rss.getInt("doctorfees");
									total=rss.getInt("sum(hosFees+doctorfees)");
									createDate=rss.getString("createDate");
								
							 %>
								
									<tbody>
									<tr>
									
										<td  >Hospital Name</td>
										<td><%=hosName %></td>
									</tr>
									<tr>
									
										<td  >Doctor Name</td>
										<td><%=doctorName %></td>
									</tr>
									<tr>
										<td  >Patient Name</td>
										<td><%=patientName %></td>
									</tr>
									<tr>
									
										<td  >Appoinment DateTime</td>
										<td><%=appoimentDate %></td>
									</tr>
									
									
										<tr>
									
										<td  >Hospital Charge</td>
										<td><%=hosFees %></td>
									</tr>
									<tr>
									
										<td  >Doctor Charge</td>
										<td><%=doctorfees %></td>
									</tr>
										
											
											<tr>
									
										<td  >Total</td>
										<td><%=total %></td>
									</tr>
									
									<tr>
									
										<td  >Payed Date</td>
										<td><%=createDate %></td>
									</tr>	
									
									<tr><td></td>
												<td ><a onclick="window.print()" target="_blank"><button>Print</button></a> </td>
											
										</tr>						
									</tbody>
								<%
								}
								%>
									
								</table>
								</form>
 	 	
</body>

</html>