<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--session.getAttribute("cust_details").getName() --sent clnt browser --%>
	<h4>Hello , ${sessionScope.cust_details.name}</h4>
	<%-- can u access session via EL syntax : YES --%>
	<%--pageContext.getSession().invalidate() --%>
	<%-- ${pageContext.session.invalidate()} --%>
	<%
	 session.invalidate();
	%>
	<h5>You have been logged out....</h5>
	<h5>
		<a href="index.jsp">Visit Again</a>
	</h5>

</body>
</html>