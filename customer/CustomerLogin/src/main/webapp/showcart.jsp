<%@page import="com.onlineproject.bean.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<main>
		<table class="view" border="1">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
				</tr>
			</thead>
			
			<c:forEach var = "i" begin = "0" end = "${sessionScope.cartList.getCartlist().size()-1 }">
        		 <tr>
        		 <td>${sessionScope.cartList.getCartlist().get(i).getId()}</td>
        		 <td>${sessionScope.cartList.getCartlist().get(i).getCode()}</td>
        		 <td>${sessionScope.cartList.getCartlist().get(i).getName()}</td>
        		 <td>${sessionScope.cartList.getCartlist().get(i).getDescription()}</td>
        		 <td>${sessionScope.cartList.getCartlist().get(i).getPrice()}</td>
        		  <td><form action="./deletecart" method="post">
			<button type="submit" class="btn">Add to cart</button>
				
			</form></td>
        		 </tr>
     		 </c:forEach>
			
		</table>
		<br>

	</main>

</body>
</html>