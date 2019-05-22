<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:black; text-align: center;">Registration Form</h1>
		<form action="RegisterServlet" method="post">


			<table align="center">
			
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" required></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" required></td>
				</tr>

                 <tr>
					<td>Email ID:</td>
					<td><input type="email" name="email" required ></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobileno" pattern="[7-9][0-9]{9}" title="mobile number must be 10 digit it's should start with 7,8 or 9" required></td>
				</tr>

                 <tr>
					<td>Password:</td>
					<td><input type="password" name="password" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" title="must be 8 alphabet with special symbol" required></td>
				</tr>
				<tr>
					<td>Re-type Password:</td>
					<td><input type="password" name="re-typepassword" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" required></td>
				</tr>

				<tr>

					<td><input type="submit" value="Register"></td>
					<td><a href="Login.jsp">Login Page</a></td>
				</tr>
			</table>
</form>
</body>
</html>