<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--session.getAttribute("user") -- null -- session.setAttribute("user",new UserBean()); --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<%-- tell WC to create candidate bean n add it under session scope --%>
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />
<body>
	<h4 align="center">
		Session ID :
		<%=session.getId()%></h4>
	<h5 style="color: red;">${sessionScope.user.message}</h5>
	<!--  This msg will set after user Login and Become invalidate
	Not There is no message set in User Class -->

	<form action="authenticate.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>