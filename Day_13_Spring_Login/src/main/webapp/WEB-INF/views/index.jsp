<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello @ ${requestScope.server_date }</h2>

	<h5>
		<a href="user/login">User SignIn</a>
	</h5>

	<h5>
		<a href="user/signup">User SignUp</a>
	</h5>
</body>
</html>