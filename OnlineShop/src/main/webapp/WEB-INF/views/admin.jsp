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

<title>Administrative page</title>
</head>
<body>

<div class="container my-5">
<h2>Welcome to Admin Pages</h2><hr>
<a class="btn btn-dark" href="adminproduct">Manage Store Products</a><br><br>
<a class="btn btn-dark" href="all-customer">Get all Customers</a><br><br>
<a class="btn btn-danger" href="login">Logout</a>
</div>
</body>
</html>