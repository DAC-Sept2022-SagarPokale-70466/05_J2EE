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
	<form action="07_Validate.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>