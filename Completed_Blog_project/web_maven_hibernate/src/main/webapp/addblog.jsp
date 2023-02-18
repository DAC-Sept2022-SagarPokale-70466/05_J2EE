<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Blog</title>
</head>
<body>
<div style="background-color:aliceblue;">
            <h3>Create Blog</h3>
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
                            <h4>Write here</h4>
                            <form action="bloginsertion.jsp">
                            <table border="1">
                                <tr>
                                    <td colspan="2">Title: <input type="text" name="title"></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Category: 
                                        <select name="categoryid">
                                        		<option id =-1>select category</option>
                                                <c:forEach var="category" items="${sessionScope.cat.allCategories}">
				                                <option value="${category.id}">${category.title}</option>			
				                                </c:forEach>
                                        </select>
                                </td>
                                </tr>
                                <tr>
                                    <td colspan="2">Content: <input type="text" name="content"></td>
                                </tr>
                                
                                <tr>
                                    <td><input type="submit" value="ADD"></td>
                                    
                                </tr>
                            </table>
                            </form>
                        </div>
                    </td>
                </tr>
                
            </table>
            <!-- <h4><a href="login.html">Login</a></h4> -->
            <!-- <h4><a href="register.html">Register</a></h4> -->
        </div>
</body>
</html>