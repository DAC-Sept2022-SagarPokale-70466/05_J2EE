<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto">
		<caption>Available Employee</caption>
		<c:forEach var="emp" items="${requestScope.empList }">
			<tr>
				<td>${emp.dept}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>