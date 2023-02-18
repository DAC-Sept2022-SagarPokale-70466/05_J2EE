<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Blog</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:setProperty property="id" name="user"/>
<body>
<div style="background-color:aliceblue;">
            <h3>Edit Blog</h3>
            ${sessionScope.user.BlogById()}
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
                            <h4>Update here</h4>
                            <form action="updateblog.jsp" method="get">
                            <table border="1">
                            	<tr>
                            		<td colspan="2">Blog Id: <input type="text" name="id" value="${sessionScope.user.BlogById().id}" readonly="readonly"></td>
                            	</tr>
                                <tr>
                                    <td colspan="2">Title: <input type="text" name="title" value="${sessionScope.user.BlogById().title}"></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Category: <input type="text" name="cattitle" value="${sessionScope.user.BlogById().category.title}"readonly="readonly">
                                </td>
                                </tr>
                                <tr>
                                    <td colspan="2">Content: <input type="text" name="content" value="${sessionScope.user.BlogById().contents}"></td>
                                </tr>
                                
                                <tr>
                                    <td><input type="submit" value="Update"></td>
                                    
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