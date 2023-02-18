<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Blog</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
<div style="background-color:aliceblue;">
            <h3>Search Blog</h3>
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
                            <div>
                            <form action="searchresults.jsp">
                            <input type="text" name="title" placeholder="Enter Title To Be Searched"> 
                            <input type="submit" value="Search">
                            </form>
                            </div>
                            <br>
                            <%-- <table border="1">
                            		
                                    <tr>
                                    <th>Blog Id</th>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Created Time</th>
                                    <th>Category</th>
                                    <th>Action</th>
                                </tr>
                             
                               <tr>
                                   		${sessionScope.user.searchBlog()}
                                	<td>${sessionScope.user.blog.id}</td>
                                    <td>${sessionScope.user.blog.title}</td>
                                    <td>${sessionScope.user.blog.user.fullName}</td>
                                    <td>${sessionScope.user.blog.createdTime}</td>
                                    <td>${sessionScope.user.blog.category.title}</td>
                                    <c:if test="${sessionScope.user.blog.user.email.equals(sessionScope.user.email)}">
                                    	<td>
                                    	<a href="update.jsp?id=${blog.id}"><input type="button" value="Edit"></a>
                                    	<a href="delete.jsp?id=${blog.id}"><input type="button" value="Delete"></a>
                                    	</td>
                                   	</c:if> 
                               </tr>
                            </table> --%>
                        </div>
                    </td>
                </tr>
                
            </table>
            <!-- <h4><a href="login.html">Login</a></h4> -->
            <!-- <h4><a href="register.html">Register</a></h4> -->
        </div>
</body>
</html>