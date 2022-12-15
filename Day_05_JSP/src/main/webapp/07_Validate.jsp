<%@page import="pojos.Customer"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	private HashMap<String, Customer> customers;
	static int idCounter = 1;

	public void jspInit() {
		customers = new HashMap<>();
		//id, String name, String password, int age)
		customers.put("Rama", new Customer(idCounter++, "Rama", "1234", 24));
		customers.put("Mihir", new Customer(idCounter++, "Mihir", "1235", 25));
		customers.put("Shubham", new Customer(idCounter++, "Shubham", "1236", 34));
		customers.forEach((k, v) -> System.out.println(v));
	}%>
<body>
	<%
	//JSP scriptlet : _jspService
	//1. read req params
	String custName = request.getParameter("name");
	String pwd = request.getParameter("pass");

	//validation ? get
	Customer customer = customers.get(custName);
	if (customer != null) {
		//=> name valid , chk pwd
		if (pwd.equals(customer.getPassword())) {
			//name n pwd matched !
			//navigation : clnt pull II
			//save validate customer details unde : session scope
			session.setAttribute("cust_details", customer);
			//redirect
			response.sendRedirect("details.jsp");
		} else {
	%>
	<h5 style="color: red;">
		Invalid Password ! , Please <a href="07_LogIn.jsp">Retry</a>
	</h5>
	<%
	}
	%>
	<%
	} else {
	%>
	<h5 style="color: red;">
		Invalid Login : Name doesn't exist !!!! , Please <a
			href="register.jsp">Register</a>
	</h5>
	<%
	}
	%>
</body>
</html>