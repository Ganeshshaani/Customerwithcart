<%@page import="com.onlineproject.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Successful, Continue Shopping</h1><br>
<h2>Welcome, ${fn:toUpperCase(sessionScope.customer.customerName)} !</h2>
<a href="./ViewProduct">
		<button type="submit" class="btn">View Products</button>
	</a>
</body>
</html>