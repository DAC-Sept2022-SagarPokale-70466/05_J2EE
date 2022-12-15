<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
</head>

<body>
	<h4>List Of Products</h4>
	<c:forEach var="prod" items="${sessionScope.product.fetchProduct()}">
		<h5>${prod.id}${prod.productName}${prod.price} belongs to
			Category Name : ${prod.productCategory.categoryName}</h5>
	</c:forEach>


</body>

</html>