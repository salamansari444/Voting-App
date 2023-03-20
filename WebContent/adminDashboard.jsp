<%@page import="java.util.List"%>
<%@page import="com.jforce.dto.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1" cellspacing="2" cellpadding="2"
		style='margin-left: auto; margin-right: auto';>

		<tr>
			<th>Candidate Name</th>
			<th>Votes</th>

		</tr>

		<%
			// Use an iterator to loop through the ArrayList
		List<Candidate> candidateAll = (List<Candidate>) request.getAttribute("allCandidates");
		java.util.Iterator<Candidate> iterator = candidateAll.iterator();
		while (iterator.hasNext()) {
			Candidate CurrCandidate = iterator.next();
		%>
		<tr>
			<td><%=CurrCandidate.getCandidateName()%></td>
			<td><%=CurrCandidate.getVoteCount()%></td>

		</tr>
		<%
			}
		%>
	</table>
	
	<form method ="post" action="./logout">
	<input type="submit" value="Logout">

	</form>

</body>
</html>