<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog Addition</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:setProperty property="*" name="user"/>
<body>
	<jsp:forward page="${sessionScope.user.addBlog()}.jsp"/>
</body>
</html>