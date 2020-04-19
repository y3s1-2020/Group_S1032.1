<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="db.database"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
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
                        <i class="pe-7s-tools"></i>
                        Payment History
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
    
    <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                        	 <div class="header">
                                <h4 class="title">Email Statistics</h4>
                                <p class="category">Last Campaign Performance</p>
                            </div>
                             <div class="content">
                              <div id="chartPreferences" class="ct-chart ct-perfect-fourth"></div>
                             
                             	<div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Open
                                        <i class="fa fa-circle text-danger"></i> Bounce
                                        <i class="fa fa-circle text-warning"></i> Unsubscribe
                                    </div>
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-clock-o"></i> Campaign sent 2 days ago
                                    </div>
                                </div>
                             </div>
 	 					</div>
 	 			    </div>
 	 			     <div class="col-md-8">
                        <div class="card">
                        	 <div class="header">
                                <h4 class="title">Users Behavior</h4>
                                <p class="category">24 Hours performance</p>
                            </div>
                             <div class="content">
                                <div id="chartHours" class="ct-chart"></div>
                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Open
                                        <i class="fa fa-circle text-danger"></i> Click
                                        <i class="fa fa-circle text-warning"></i> Click Second Time
                                    </div>
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-history"></i> Updated 3 minutes ago
                                    </div>
                                </div>
                            </div>
                      	</div>
                     </div>
                     
 	 			</div>
 	 	   </div>
 	 	  
 	 	</div> 

</div>
</div>
 	 	
</body>
</html>