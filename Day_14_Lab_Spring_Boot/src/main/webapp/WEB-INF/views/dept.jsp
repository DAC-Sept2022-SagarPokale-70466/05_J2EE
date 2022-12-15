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

	<h4 align="center" style="color: green;">${requestScope.mesg}</h4>
	<%-- <h5>Validated User Details : ${sessionScope.user_details}</h5> --%>
	<h5>Hello</h5>
	<spring:url var="url" value="/customer/products" />
	<form action="${url}">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Available Departments</caption>
			<c:forEach var="dept" items="${requestScope.dept_list}">
				<tr>
					<td><input type="radio" name="deptid" value="${dept.id}" /></td>
					<td>${dept.}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Choose A Catgory" /></td>
			</tr>

		</table>

	</form>

</body>
</html>