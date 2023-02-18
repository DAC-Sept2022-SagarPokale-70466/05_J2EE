<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>
<body>
<div style="background-color:aliceblue;">
            <h3>Add Blog Category</h3>
            
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
                            <h4>Add Blog Category</h4>
                            <form action="cataddition.jsp" method="post">
                            <table border="1">
                                <tr>
                                    <td>Category title<input type="text" name="title"></td>
                                    <td>Category Description<input type="text" name="description"></td>
                                    <td><input type="submit" value="Add"></td>
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