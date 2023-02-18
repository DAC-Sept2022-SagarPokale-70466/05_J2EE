<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
<div style="background-color:aliceblue;">
           <form action="registration.jsp" method="Post">
            <table border="1">
                <tr>
                    <td colspan="2" >Register</td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td>Full name</td>
                    <td><input type="text" name="fname"></td>
                </tr>
                <tr>
                    <td>Phone number</td>
                    <td><input type="number" name="phoneno"></td>
                </tr>
                <tr>
                    <td colspan="2" style="position:relative;"><input type="submit" value="Sign Up"></td>
                </tr>

            </table>
            </form>
        </div>
</body>
</html>