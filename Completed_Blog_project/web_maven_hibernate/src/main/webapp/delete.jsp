<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Blog</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:setProperty property="id" name="user"/>
<body>
<jsp:forward page="${sessionScope.user.deleteBlog()}.jsp"/>
</body>
</html>