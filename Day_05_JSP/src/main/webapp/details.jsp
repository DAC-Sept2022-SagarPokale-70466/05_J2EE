<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--session.getAttribute("cust_details") -- pw -->sent clnt --%>
	<h4>Validate Customer Details ${sessionScope.cust_details}</h4>
	<h5>
		<a href="logout.jsp">Log Me Out</a>
	</h5>
</body>
</html>