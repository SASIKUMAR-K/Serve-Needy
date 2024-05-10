/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ABN_05
 */
public class orphanagelogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet orphanagelogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet orphanagelogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		try{
			 String URL="localhost:3306/";
			 String DATABASE_NAME="serve";
			 String USERNAME="root";
			 String PASSWORD="password";
			
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+URL+DATABASE_NAME,USERNAME,PASSWORD);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * from orplogin where orp_name='"+name+"' and password='"+pass+"'");
			HttpSession session=request.getSession();
			if(rs.next()){
				String a=rs.getString("orp_name");
		    	session.setAttribute("password", a);
		    	RequestDispatcher rd=request.getRequestDispatcher("index.html");
		    	rd.include(request,response);
		    	  
		        
			}
			else{
				
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				
				out.print("<html><body>");
				out.print("<script type=\"text/javascript\">");
				out.print("alert('Incorrect username or password');");
				out.print("</script>");
				out.print("</body></html>");
				rd.include(request,response);
				
			}
			con.close();
			rs.close();
			st.close();
		}
		
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		}     
    }

