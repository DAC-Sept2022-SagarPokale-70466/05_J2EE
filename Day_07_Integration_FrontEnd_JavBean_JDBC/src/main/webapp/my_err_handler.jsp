<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 style="color: red;">Error Details<%=exception%></h4>
	<h4 style="color: red;">Error Message<%=exception.getMessage()%></h4>
	<hr/>
	<h3>Error Details Via EL Syntax</h3>
	<h4 style="color: red;">Error Details : ${pageContext.exception}</h4>
	<h4 style="color: red;">Error Message : ${pageContext.exception.message}</h4>
	<h4 style="color: red;">Error Causing Page URI : ${pageContext.errorData.requestURI}</h4>
	<h4 style="color: red;">Error Code : ${pageContext.errorData.statusCode}</h4>
</body>
</html>