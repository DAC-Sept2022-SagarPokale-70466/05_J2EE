<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome 2 Spring MVC @ ${requestScope.server_date}</h4>
	<h5>
		<a href="user/login">User Sign In</a>
	</h5>
	
	<a href="user/register">Register YourSelf</a>
	<h4>${requestScope.mesg}</h4> 
	
	
	<a href="user/login">Log-In</a>
</body>
</html>