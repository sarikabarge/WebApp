<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:black; text-align: center;">Forgot Password</h1>
		<form action="MailSend" method="post">
			<table align="center">
				<tr>
					<td>Email Id:</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>

					<td><input type="submit" value="submit"></td>
					<td><a href="Login.jsp">Cancel</a></td>
				</tr>


			</table>
		</form>
</body>
</html>