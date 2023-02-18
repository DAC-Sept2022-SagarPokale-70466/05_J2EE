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
				<td>Vehicle Id : ${requestScope.vehicle_details.vid}</td>
			</tr>
			<tr>
				<td>Vehicle Name :</td>
				<td><input type="text" name="vname"
					value="${requestScope.vehicle_details.vname}" /></td>
			</tr>
			<tr>
				<td>Company :</td>
				<td><input type="text" name="company"
					value="${requestScope.vehicle_details.company}" /></td>
			</tr>
			<tr>
				<td>Vehicle Number :</td>
				<td><input type="text" name="vnumber"
					value="${requestScope.vehicle_details.vnumber}" /></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><input type="text" name="type"
					value="${requestScope.vehicle_details.type}" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="uid"
					value=" ${requestScope.vehicle_details.user}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Vehicle" /></td>
			</tr>
		</table>
	</form>
</body>
</html>