<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: black; text-align: center">Login Page</h1>  
	<form action="LoginServlet" method="post">
     
		<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="email" name="email"  id="name"required></td>

			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" required></td>

			</tr>
			<tr>
				
				<td >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="Login"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
			<tr>
			    <td><a href="Registration.jsp">Register</a>&nbsp;</td>
				<td><a href="Forgotpassword.jsp">Forgot Password</a></td>
			
			</tr>
		</table>
   
	</form>


</body>
</html>