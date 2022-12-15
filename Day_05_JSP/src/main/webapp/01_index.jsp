<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">
		Session ID :
		<%=session.getId()%></h4>
	<h3>
		Welcome to JSP !!!!!!!!!!!!
		<%=new Date()%></h3>
	<h5>
		<a href="02_comments.jsp">Testing Comments</a>
	</h5>
	<h5>
		<a href="03_login.jsp">Testing Scriptlets , Expressions , EL Syntax</a>
	</h5>
	<h5>
		<a href="05_JSP_Declaraion.jsp">Testing JSP Declarations</a>
	</h5>
	<h5>
		<a href="06_Scope.jsp">Testing Different scopes of attributes</a>
	</h5>
	<h5>
		<a href="07_LogIn.jsp">User Login</a>
	</h5>
</body>
</html>