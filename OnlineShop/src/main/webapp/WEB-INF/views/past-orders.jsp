<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Insert title here</title>
<style type="text/css">
table,th,td{
border: 2px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
<div class="container my-5">
<table class="table table-striped">
<tr><th>Customer Name</th><td>${user.getName()}</td></tr>
<tr><th>Customer contact No</th><td>${user.getMobile()}</td></tr>
<tr><th>Customer current Address</th><td>${user.getAddress()}</td></tr>
</table>
<br>
<c:forEach var="y" items="${orderList}">
<table class="table table-striped">
<tr><th>Ordering date</th><td colspan="4">${y.getOrderingDate() }</td></tr>
<tr><th>Order ID</th><td colspan="4">${y.getOrderId() }</td></tr>
<tr><th>Ordering cart ID</th><td colspan="4">${y.getCartId() }</td></tr>
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
<tr><td colspan="3"></td><th>Total Amount</th><td>${y.getTotal()}/-</td></tr>
</table>
<br>
</c:forEach>
<button class="btn btn-dark" onclick="window.print()">Print Orders List</button>
</div>
</body>
</html>