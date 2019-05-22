package com.bridgeit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter pw=response.getWriter();
		 String email=request.getParameter("email");	
		 String password=request.getParameter("password");
		 HttpSession session=request.getSession(true);
		 try { 
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginmodule","root","Admin@123");
				PreparedStatement pr=con.prepareStatement("Select * from Registration1 where email=? and password=?");
				pr.setString(1,email);
				pr.setString(2, password);
				ResultSet rs=pr.executeQuery();
				
				if(rs.next()) 
				{
					pw.print("<html><body align='center'><font color='black'><h3>You are Logged in Successfully,Welcome</h3></body></html>"+email);
					session.setMaxInactiveInterval(30);
				}
				else 
				{
					pw.println("<html><body align='center'><font color='red'>Password does not matched,Try Again!!!</font></body></html>");
					request.getRequestDispatcher("Login.jsp").include(request, response);
				}
				}catch(Exception e) {
					pw.println(e);
					pw.close();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
