<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blogs</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:getProperty property="email" name="user"/>
<body>
<div style="background-color:aliceblue;">
            <table border="1">
                <tr>
                    <td >
                        <div><a href="addblog.jsp">Add Blog</a></div>
                        <div><a href="myblogs.jsp">My Blogs</a></div>
                        <div><a href="viewblogs.jsp">View Blogs</a></div>
                        <div><a href="addcategory.jsp">Add Blog Category</a></div>
                        <div><a href="showcategory.jsp">Show Blogs Category</a></div>
                        <div><a href="searchblogs.jsp">Search Blogs</a></div>
                        <div><a href="logout.jsp">Logout</a></div>
                    </td>
                    <td>
                        <div>
                            <table border="1">
                                <tr>
                                    <th>Blog Id</th>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Created Time</th>
                                    <th>Category</th>
                                    <th>Action</th>
                                </tr>
                                <c:forEach var="blog" items="${sessionScope.user.allblogs}">
                                <tr>
                                	<c:if test="${blog.user.email.equals(sessionScope.user.email)}">
                                    <td>${blog.id}</td>
                                    <td>${blog.title}</td>
                                    <td>${blog.user.fullName}</td>
                                    <td>${blog.createdTime}</td>
                                    <td>${blog.category.title}</td>
                                     <td>
                                    	<a href="update.jsp?id=${blog.id}"><input type="button" value="Edit"></a>
                                    	<a href="delete.jsp?id=${blog.id}"><input type="button" value="Delete"></a>
                                    </td>
                                    </c:if>
                                  </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                
            </table>
            <!-- <h4><a href="login.html">Login</a></h4> -->
            <!-- <h4><a href="register.html">Register</a></h4> -->
        </div>
</body>
</html>