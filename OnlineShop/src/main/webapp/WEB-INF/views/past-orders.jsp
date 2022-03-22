<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,th,td{
border: 2px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
<h1>Order History</h1>
<table>
<tr><th>Customer Name</th><td>${user.getName()}</td></tr>
<tr><th>Customer contact No</th><td>${user.getMobile()}</td></tr>
<tr><th>Customer current Address</th><td>${user.getAddress()}</td></tr>
</table>
<br>
<c:forEach var="y" items="${orderList}">
<table>
<tr><th>Ordering date</th><td>${y.getOrderingDate() }</td></tr>
<tr><th>Order ID</th><td>${y.getOrderId() }</td></tr>
<tr><th>Ordering cart ID</th><td>${y.getCartId() }</td></tr>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Quantity</th>
<th>added on</th>
</tr>
<c:forEach var="x" items="${y.getOrdersPerBatch()}">
<tr>
<td>${x.getItemId() }</td>
<td>${x.getItemName() }</td>
<td>${x.getItemPrice() }</td>
<td>${x.getItemCount() }</td>
<td>${x.getDateAndTime() }</td>
</tr>
</c:forEach>
<tr><th>Total Amount</th><td>${y.getTotal()}</td></tr>
</table>
<br>
</c:forEach>
</body>
</html>