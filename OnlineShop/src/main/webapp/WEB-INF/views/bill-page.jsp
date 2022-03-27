<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Billing</title>

</head>
<body>
<div class="container my-5">

<table>
<tr><th>Shipping To:<br>_____________________</th></tr>

<tr>
<th>Name</th><td>${info.getName()}</td>
</tr>
<tr>
<th>Email</th><td>${info.getEmail()}</td>
</tr>
<tr>
<th>Contact no</th><td>${info.getMobile()}</td>
</tr>
<tr><th>_____________________</th></tr>
<tr>
<th>Dropping Location</th><td>&nbsp;&nbsp;&nbsp; ${shipping_address.gethNo() }, ${shipping_address.getAddress1() }, ${shipping_address.getAddress2() }</td>
</tr>
<tr>
<th>City</th><td>&nbsp;&nbsp;&nbsp;${shipping_address.getCity() }</td>
</tr>
<tr>
<th>Postal code</th><td>&nbsp;&nbsp;&nbsp;${shipping_address.getPincode() }</td>
</tr>
<tr><th>Status</th><td>
<img src='<c:url value="/resources/img/paid.png" />' height="100px" width="120px"></td></tr>
</table>
<br>
<table id="thistable" class="table table-striped">
<tr><th>Ordering date</th><td>${bill.getOrderingDate() }</td></tr>
<tr><th>Order ID</th><td>${bill.getOrderId() }</td></tr>
<tr><th>Ordering cart ID</th><td>${bill.getCartId() }</td></tr>
</table>


<table class="table table-striped">
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
<tr><td colspan="3"></td><th>Total Amount</th><td>${bill.getTotal()}/-</td></tr>
</table>
<p><b>Verified Payment</b>&nbsp;&nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
  <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
</svg></p>
<br>
<a href="login" class="btn btn-warning">Logout</a>&nbsp;&nbsp;&nbsp;
<button class="btn btn-dark" onclick="window.print()">Print Invoice</button>
</div>
</body>
</html>