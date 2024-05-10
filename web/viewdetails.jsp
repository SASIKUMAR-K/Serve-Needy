<%-- 
    Document   : viewdetails
    Created on : Mar 5, 2021, 9:54:03 AM
    Author     : ABN_05
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@page import ="java.util.*"%>
<%@ include file="connect.jsp" %>
    <%@page import ="java.util.*,java.security.Key,java.util.Random,javax.crypto.Cipher,javax.crypto.spec.SecretKeySpec,org.bouncycastle.util.encoders.Base64"%>
    <%@ page import="java.sql.*,java.util.Random,java.io.PrintStream,java.io.FileOutputStream,java.io.FileInputStream,java.security.DigestInputStream,java.math.BigInteger,java.security.MessageDigest,java.io.BufferedInputStream" %>
<%@ page import ="java.security.Key,java.security.KeyPair,java.security.KeyPairGenerator,javax.crypto.Cipher"%>
 <%@page import ="java.util.*,java.text.SimpleDateFormat,java.util.Date,java.io.FileInputStream,java.io.FileOutputStream,java.io.PrintStream"%>
<head>
<title>SERVE NEEDY SYSTEM</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-ptsans.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<style type="text/css">
<!--
.style1 {font-size: 18px}
.style2 {font-size: 14px; }
-->
</style>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
       <!--  <h1 class="style1"><a href="index.html">Audit-Free Cloud Storage via Deniable</a></h1> -->
        <li><a class="active" href="index.html"><img src="Gallery/serve.png" style="margin-right:50px;height:100px;" align="center">SERVE NEEDY SYSTEM</img></a></li>
      </div>
      <div class="menu_nav">
        <ul>
          <li><a href="admin.html">USER</a></li>
          <li><a href="orphanage.html">ORPHANAGE</a></li>
          <li><a href="volunteer.html">VOLUNTEERS</a></li>
          
          <li><a href="##">ABOUT SYSTEM</a></li>
        </ul>
      </div>

    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>VIEW DETAILS</span></h2>
        </div>
        <div class="mainbar">
          <div class="article">

		    <table width="653" border="1" align="left">
              <tr>
                <td width="87" height="31"><div align="center"><span class="style5">Donate Id</span></div></td>
                <td width="87" height="31"><div align="center"><span class="style5">User Name</span></div></td>
                <td width="155"><div align="center"><span class="style5">Address</span></div></td>
                <td width="155"><div align="center"><span class="style5">Money</span></div></td>
                <td width="161"><div align="center"><span class="style5">Clothes</span></div></td>
                <td width="222"><div align="center"><span class="style5">Food</span></div></td>
                <td width="222"><div align="center"><span class="style5">Contact Number</span></div></td>
                 
              </tr>
                         <%

	
	String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",s10="",s11="",s12="",s13="";
	int i=0,j=0,k=0;

      	try 
	{
        
          
      		
      		 
      		
      		String query="select * from details "; 
           Statement st=connection.createStatement();
           ResultSet rs=st.executeQuery(query);
	while ( rs.next() )
	   {
		i=rs.getInt(1);
		s2=rs.getString(2);
		s3=rs.getString(3);
		s4=rs.getString(4);
                s5=rs.getString(5);
                s6=rs.getString(6);
                s7=rs.getString(7);
                s10=rs.getString(10);
                
		
		
	
		%>
              <tr>
                <td height="29"><div align="center"><%=i%></div></td>
                <td><div align="center"><%=s2%></div></td>
		<td><div align="center"><%=s3%></div></td>
                <td><div align="center"><%=s4%></div></td>
                <td><div align="center"><%=s5%></div></td>
                <td><div align="center"><%=s6%></div></td>  
                <td><div align="center"><%=s10%></div></td>
                </div></td>
            </tr>
                 <%
                }
 %>
            </table>
 <%
     query="select sum(money) from details where money is not null"; 
                st=connection.createStatement();
           rs=st.executeQuery(query);
           if(rs.next()){
               int totalMoney=rs.getInt(1);
               %>
             <p>Total Amount : <%=totalMoney%></p>
             <%
           }
           query="select count(food) from details where food is not null"; 
           st=connection.createStatement();
           rs=st.executeQuery(query);
           if(rs.next()){
               int food=rs.getInt(1);
               %>
             <p>Food Count : <%=food%></p>
             <%
           }
           query="select count(clothes) from details where clothes is not null"; 
           st=connection.createStatement();
           rs=st.executeQuery(query);
           if(rs.next()){
               int cloth=rs.getInt(1);
               %>
             <p>Cloth Count : <%=cloth%></p>
             <%
           }
                connection.close();
                }
         
          catch(Exception e)
          {
            out.println(e.getMessage());
          }
%>
                    
                    
                    
		    <p>
		    <p>&nbsp;  </p>
		    <p><a href="admin.html">BACK</a></p>  
		    <p>&nbsp;</p>
          </div>
        </div>
      </div>
      <div class="sidebar">
                        <div class="searchform">
                        </div>
                        <div class="clr"></div>
                        <div class="gadget">
                            <h2 class="star"><span>Menu </span> </h2>
                            <div class="clr"></div>
                            <ul class="sb_menu"><li>
                                    <ul class="sb_menu">
                                        <li><a href="viewdetails.jsp">All Details</a></li>
                                        <li><a href="viewvolunteer.jsp">VIEW VOLUNTEERS</a></li>
                                        <li><a href="viewhotel.jsp">Hotel Food Details</a></li>
                                        
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
      <div class="clr"></div>
    </div>
  </div>

</div>
<div align=center></div>
</body>
</html>

        