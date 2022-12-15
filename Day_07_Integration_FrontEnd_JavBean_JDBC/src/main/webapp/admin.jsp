<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- message --%>
	<%-- session.getAttribute("user").getMessage()--sent to clnt --%>
	<h4>${sessionScope.user.message}</h4>
	<%-- user's greet with name --%>
	<h5>Hello , ${sessionScope.user.validatedUserDetails.firstName}</h5>		<!-- validateUserDetails Is set at Authenticate User -->
	<%--display top 2 --%>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Top 2 Candidates</caption>
		<tr>
			<th>Name</th>
			<th>Political Party</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="candi"
			items="${sessionScope.candidate.candidatesByVotes}">
			<tr>
				<td>${candi.name}</td>
				<td>${candi.partyName}</td>
				<td>${candi.votes}</td>
			</tr>
		</c:forEach>
	</table>




	<%-- display partywise analysis --%>
	${sessionScope.candidate.partyAnalysis}
	<table style="background-color: lightgrey; margin: auto">
		<caption>Partywise Analysis</caption>
		<tr>
			<th>Political Party</th>
			<th>Total Votes</th>
		</tr>
		<c:forEach var="entry" items="${sessionScope.candidate.partyAnalysis}">
			<tr>

				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>
	<%--dao cleanup --%>
	${sessionScope.user.userDao.cleanUp()}
	${sessionScope.candidate.candidateDao.cleanUp()}
	<%--discard http session --%>
	
	<%-- ${pageContext.session.invalidate()} --%>
	
	<h5>You have logged out</h5>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>

</body>
</html>