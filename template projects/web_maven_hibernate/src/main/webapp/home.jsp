<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="product" class="beans.ProductBeance" scope="session" />
<body>
	<h3>
		Welcome 2 Web App with Hibernate @
		<%=new Date()%></h3>

	<h5>
		<a href="display.jsp">Display All Products</a>
	</h5>
</body>
</html>