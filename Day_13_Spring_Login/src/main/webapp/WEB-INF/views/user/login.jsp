<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">
		Session ID :
		<%=session.getId()%></h4>
	<!--   -->

	<h5 style="color: red">${requestScope.error}</h5>
	<!-- session.getAttribute("user").getMessage;  -->

	<!-- if action is not specified then same previous url is Used  /user/login  -->

	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="myEmail" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="myPassword" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>