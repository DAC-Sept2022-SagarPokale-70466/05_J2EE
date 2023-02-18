<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Vehicle Name :</td>
				<td><input type="text" name="vname" /></td>
			</tr>
			<tr>
				<td>Company :</td>
				<td><input type="text" name="company" /></td>
			</tr>
			<tr>
				<td>Vehicle Number :</td>
				<td><input type="text" name="vnumber" /></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><input type="text" name="type" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="uid" value="${requestScope.user_details.id}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Vehicle" /></td>
			</tr>
		</table>
	</form>

</body>
</html>