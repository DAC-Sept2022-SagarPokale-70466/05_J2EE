<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:useBean id="cat" class="beans.CategoryBean" scope="session"/>
<body>
<div style="background-color:aliceblue;">
            <h3>Blog Category</h3>
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
                            <h4>Blog Category</h4>
                            <table border="1">
                                <tr>
                                    <th>Category List</th>
                                    <th>Category Description</th>
                                </tr>
                                <c:forEach var="category" items="${sessionScope.cat.allCategories}">
                                	<tr>
                                	<td>${category.title}</td>
                                	<td>${category.description}</td>
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