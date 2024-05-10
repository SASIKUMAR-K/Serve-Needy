<%-- 
    Document   : detailssent
    Created on : Mar 5, 2021, 9:36:18 PM
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
          <li><a href="userregister.html">USER</a></li>
          <li><a href="orphanage.html">ORPHANAGE</a></li>
          <li><a href="volunteer.html">VOLUNTEERS</a></li>
          
          <li><a href="##">ABOUT SYSTEM</a></li>
        </ul>
      </div>

    </div>
  </div>
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
              </tr>
              <%
                     }
                  
                connection.close();
}
          catch(Exception e)
          {
            out.println(e.getMessage());
          }
%>
            </table>
		    <p>
		    <p>&nbsp;  </p>
		    <p><a href="index.html">BACK</a></p>  
		    <p>&nbsp;</p>
          </div>
        </div>
      </div>
      <div class="sidebar">
        <div class="searchform">
        </div>
        <div class="clr"></div>
        <div class="gadget">
          <h2 class="star"><span> </span> </h2>
          <div class="clr"></div>
          
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

</div>
<div align=center></div>
</body>
</html>

        


