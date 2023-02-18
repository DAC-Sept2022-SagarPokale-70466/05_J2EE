<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Addition</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:useBean id="cat" class="beans.CategoryBean" scope="session"/>
<jsp:setProperty property="*" name="cat"/>
<body>
	<jsp:forward page="${sessionScope.cat.addCategory()}.jsp"/>
</body>
</html>