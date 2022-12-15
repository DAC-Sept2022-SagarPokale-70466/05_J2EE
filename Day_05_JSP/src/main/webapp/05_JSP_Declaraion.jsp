<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!			//JSP declaration block
	int counter = 0;
	static String mesg = "some mesg!!!!";
	public void jspInit()		// @Override jspInit()
	{
		System.out.print("in jsp init");
	}
	int incrementMe()
	{
		return ++counter;
	}
	%>
<body>
<h5>Page Visits : <%= incrementMe() %></h5>
<h5>Message : <%= mesg %></h5>		<!--  mesg Will replace by some mesg -->
</body>
<%!
 public void jspDestroy()
 {
	System.out.print("in jsp destroy");
 }
%>
</html>