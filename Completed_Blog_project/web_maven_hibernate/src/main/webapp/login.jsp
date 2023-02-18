<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
 <div style="background-color:aliceblue;">
           <form action="authenticate.jsp">
            <h3>Login</h3>
            <table border="1">
                <tr>
                    <td colspan="2" >Login</td>
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
                    <td><input type="submit" value="Login"></td>
                    <td><input type="submit" value="Sign Up"><a href="register.jsp"></a></td>
                </tr>

            </table>
            </form>
        </div>

</body>
</html>