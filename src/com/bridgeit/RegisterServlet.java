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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Loginmodule","root","Admin@123");
			PreparedStatement pr=con.prepareStatement("Insert into Registration1 values(?,?,?,?,?,?)");

			
			String fname=request.getParameter("firstName");
			String lname=request.getParameter("lastName");
			String email=request.getParameter("email");
			String mobileno=request.getParameter("mobileno");
			String pass=request.getParameter("password");
			String cpass=request.getParameter("re-typepassword");
		
		
			
			pr.setString(1,fname);
			pr.setString(2,lname);
			pr.setString(3,email);
			pr.setString(4,mobileno);
			pr.setString(5,pass);
			pr.setString(6,cpass);
		
			
			
			if(pass.equals(cpass))
			{
				pr.executeUpdate();
				pw.println("<html><body align='center'><font color='black'>Registered Successfully</font></body></html>");
				request.getRequestDispatcher("Login.jsp").include(request, response);
			}
			else 
			{
				pw.println("<html><body align='center'><font color='red'>Password and Confirm Password must be same</font></body</html>");
				request.getRequestDispatcher("Registration.jsp").include(request, response);
			}
		}catch(Exception e)
		{
			pw.println(e);
			e.printStackTrace();
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
