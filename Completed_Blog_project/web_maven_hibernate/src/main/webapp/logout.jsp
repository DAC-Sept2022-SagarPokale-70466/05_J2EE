<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged Out</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
	<h2>Logout Successful ${sessionScope.user.user.fullName}</h2>
	<%
	pageContext.getSession().invalidate();
	%>
	<a href="home.jsp"> Click here to login again</a>
</body>
</html>