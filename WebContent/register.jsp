<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Registration</title>
</head>
<body align='center'>


	<form action="./controller/register" method="post">
		<table border='1' align="center">
			<tr>
				<td>Username</td>
				<td><input type='text' name='username' required="required">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='password' required="required">
				</td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type='text' name='email' required="required">
				</td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><input type='text' name='phone' required="required">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type='submit' value="Register"></td>

			</tr>

		</table>

	</form>
</body>
</html>