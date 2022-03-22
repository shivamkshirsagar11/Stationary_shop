<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,th,td{
border:2px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
<h1>Bill</h1>
<table id="thistable">
<tr><th>Ordering date</th><td>${bill.getOrderingDate() }</td></tr>
<tr><th>Order ID</th><td>${bill.getOrderId() }</td></tr>
<tr><th>Ordering cart ID</th><td>${bill.getCartId() }</td></tr>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Quantity</th>
<th>added on</th>
</tr>
<c:forEach var="x" items="${bill.getOrdersPerBatch()}">
<tr>
<td>${x.getItemId() }</td>
<td>${x.getItemName() }</td>
<td>${x.getItemPrice() }</td>
<td>${x.getItemCount() }</td>
<td>${x.getDateAndTime() }</td>
</tr>
</c:forEach>
<tr><th>Total Amount</th><td>${bill.getTotal()}</td></tr>
</table>
<a href="login" class="btn btn-alert">Logout</a>
</body>
</html>