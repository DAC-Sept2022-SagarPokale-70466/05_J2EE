<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<spring:url var="url" value="/vehicle/addVehicle" />
	<spring:url var="lg" value="/user/logout" />

	<h1>Welcome ${requestScope.user_details.uname}</h1>
	<a href="${url}" type="button" class="btn btn-success">Add Vehicle
		| </a>
	<a type="button" class="btn btn-warning" href="${lg}">Logout</a>
	<br />
	<br />
	<div>
		<table style="color: 1px solid black">
			<tr>
				<th>Vehicle Id</th>
				<th>Vehicle Name</th>
				<th>Company</th>
				<th>Vehicle Number</th>
				<th>Vehicle Type</th>
				<th>Vehicle Owner Id</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="vehicle" items="${sessionScope.user_info.vehicles}">
				<tr>
					<td>${vehicle.vid}</td>
					<td>${vehicle.vname}</td>
					<td>${vehicle.company}</td>
					<td>${vehicle.vnumber}</td>
					<td>${vehicle.type}</td>
					<td>${vehicle.user.id}</td>
					<td><a type="button"
						href="<c:url value='/vehicle/update/${vehicle.vid}' />">Update</a></td>
					<td><a type="button" class="btn btn-warning"
						href="<c:url value='/vehicle/delete/${vehicle.vid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>