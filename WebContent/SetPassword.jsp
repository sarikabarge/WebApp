<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: black; text-align: center;">Reset Password</h1>
	<form action="SetPassword" method="post">
		<table align="center">
			<tr>
				<td>EmailId:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>

				<td>New Password:</td>
				<td><input type="password" name="password"
					pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required></td>
			</tr>
			<tr>
				<td>Re-type Password:</td>
				<td><input type="password" name="retypePassword"
					pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required></td>
			</tr>
			<tr>

				<td><input type="submit" value="Reset"></td>

			</tr>


		</table>
	</form>
</body>
</html>