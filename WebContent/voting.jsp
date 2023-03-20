<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix = 'c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting</title>
</head>
<body>
	
<h1 style='color:red; text-align:center'>Voting Time....</h1>




	<form action="./validatevote" method="post">
		<table align="center">
		<tr>
		<td>
		<input type="radio" name="c1" value="candidate1">Candidate 1
		</td>
		</tr>
		
		<tr>
		<td>
		<input type="radio" name="c1"  value="candidate2" >Candidate 2
		</td>
		</tr>
		
		<tr>
		<td>
		<input type="radio" name="c1" value="candidate3" >Candidate 3
		</td>
		</tr>
		
		<tr>
		<td>
		<input type="radio" name="c1" value="candidate4" >Candidate 4
		</td>
		</tr>
		
		
		<tr>
		
		<td></td>
		<td>
		<input type="submit" value="Vote">
		
		</td>
		</tr>
		</table>
		
		
		
	</form>
	


</body>
</html>