package com.bridgeit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetPassword
 */
@WebServlet("/SetPassword")
public class SetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		String password=request.getParameter("password");
		String retypePassword=request.getParameter("retypePassword");
		String email=request.getParameter("email");
		
		System.out.println(email);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginmodule","root","Admin@123");
			PreparedStatement pr=con.prepareStatement("Update Registration1 set password=?,retypePassword=? where email=?");
			
			pr.setString(1,password);
			pr.setString(2, retypePassword);
			pr.setString(3, email);
			
			if(password.equals(retypePassword))
			{
				pr.executeUpdate();
				pw.println("<html><body align='center'><font color='blue'>Password changed successfully,Now you can Login</font></body></html>");
				request.getRequestDispatcher("Login.jsp").include(request, response);
			}
			else
			{
				pw.println("<html><body align='center'>Password and Confirm Password does not match,Try Again!!!</body></html>");
				request.getRequestDispatcher("SetPassword.jsp").include(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
