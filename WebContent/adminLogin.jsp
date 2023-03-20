<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin login Page</title>
</head>
<body>
	<h1 style='text-align: center;'>Admin Login</h1>
	<form action="./controller/admin" method="post">
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
				<td><button>
						<input type="submit" value="Login">
					</button></td>

			</tr>

		</table>

	</form>


</body>
</html>