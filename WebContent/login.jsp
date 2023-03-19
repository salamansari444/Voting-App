<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Page</title>
</head>
<body>
<form action="./controller/login" method="post">
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
				<td><button> <input type="submit" value="Login"></button></td>
				<td><button> <a href="./register.jsp"/>SignUp</button></td>

			</tr>

		</table>

	</form>


</body>
</html>