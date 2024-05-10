/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author ABN_05
 */
@WebServlet("/hotel")
public class hotel extends HttpServlet {

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
            out.println("<title>Servlet hotel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hotel at " + request.getContextPath() + "</h1>");
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
                   Connection con=null;
                   Statement st=null;

        try{
            String hotelName = request.getParameter("hotelName");
            String address = request.getParameter("address");
           String contactNumber=request.getParameter("contactNumber");
           String foodDetail=request.getParameter("foodDetail");
           String expiryDate=request.getParameter("expiryDate");
           
           
          
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serve","root","password");
             st=con.createStatement();
             int rs=st.executeUpdate("Insert into hotel (hotelName,address,contactNumber,foodDetail,expiryDate) Values ('"+hotelName+"','"+address+"','"+contactNumber+"','"+foodDetail+"','"+expiryDate+"')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
            } 
    response.sendRedirect("hotel.html"); 
    }

    
  @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

