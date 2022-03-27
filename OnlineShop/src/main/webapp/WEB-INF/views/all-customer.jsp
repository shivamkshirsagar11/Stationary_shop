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

<title>All customers</title>
</head>
<body>
<div class="container my-5" style="max-width:50%;">
<c:if test="${ul != null }">
<h3>Total ${ul.size() } Customers found!</h3><hr>
<c:forEach var="x" items="${ul}" varStatus="loop">
<table class="table table-striped" style="border:2px solid black;">
<tr><th>Customer ID</th><td>${x.getId() }</td></tr>
<tr><th>Name</th><td>${x.getName() }</td></tr>
<tr><th>Email</th><td>${x.getEmail() }</td></tr>
<tr><th>Contact no</th><td>+91 ${x.getMobile() }</td></tr>
<tr><th>Total Order Placed</th><td>${tot.get(loop.index)}</td></tr>
</table>
</c:forEach>
</c:if>
</div>
</body>
</html>