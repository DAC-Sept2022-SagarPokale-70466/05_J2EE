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
	<!--JSP Expressioin  -->

	<%
	//JSP Scriptlet
	String email = request.getParameter("email");
	String pwd = request.getParameter("pass");
	out.print("<h4> Email : " + email + " Password : " + pwd + "</h4>");
	%>

	<hr />
	<h4 align="center">User Details via JSP Expression</h4>
	<h5>
		Email :
		<%=request.getParameter("email")%></h5>
	<h5>
		Password :
		<%=request.getParameter("pass")%></h5>

	<hr />

	<h4 align="center">EL Syntax</h4>
	<h5>param : ${param}</h5>
	<h5>Email: ${param.email}</h5>
	<h5>PWD : ${param.pass}</h5>

</body>
</html>