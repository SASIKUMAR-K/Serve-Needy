 
  

<title>Attribute-based Encryption</title><%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%
	Connection connection = null;
 	try {
     	
	  	Class.forName("com.mysql.jdbc.Driver");	
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serve","root","password");
      	String sql="";

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
%>