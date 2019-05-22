package com.bridgeit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/* String page = "Forgotpassword.jsp";
	        request.getRequestDispatcher(page).forward(request, response);
		*/
	    PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		HttpSession session=request.getSession();
		session.setAttribute("email",email);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginmodule","root","Admin@123");
			PreparedStatement pr=con.prepareStatement("Select * from Registration1 where email=?");
			pr.setString(1,email);
			
			ResultSet rs=pr.executeQuery();
			
			if(rs.next()) 
			{
				response.sendRedirect("SetPassword.jsp");
			}
			else
			{
				pw.println("<font color='red'>Enter correct data</font>");
				request.getRequestDispatcher("Forgotpassword.jsp").include(request, response);
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
