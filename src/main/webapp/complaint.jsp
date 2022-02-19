<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
     	Stationary Shop
    </a>
    <a class="navbar-brand navbar-right" href="login.jsp">Log Out</a>
    
  </div>
</nav>

<div class='container' style='max-width:50%'>
<h4>Raise an Issue in your past Order</h4>
<form action="processcomplaint" method='POST'>
<span style='color:red;'>${error}</span>
<span style='color:Green;'>${success}</span>
<div class="form-row">
<div class="form-group col-md-6">
<lable>Enter Order ID</lable>
<input type="text" class="form-control" name="ordid">
</div>

<div class="form-group col-md-6">
<lable>Choose Problem</lable>
<select class="form-control" name="option" required>
<option value="" selected required>Choose...</option>
<option>Product Defective</option>
<option>Product Not Delivered</option>
<option>Got Different Product</option>
<option>Other</option>
</select>
</div>

<div class="form-group col-md-6">
<lable>Explain Details</lable>
<textarea name="comp" row="8" class="form-control"></textarea>
</div>
</div>
<div>
  <br>
  <button type="submit" class="btn btn-dark">Raise Issue</button>
  </div>
</form>
</div>
<div class='container' style='max-width:50%;'>
<br>
<h4><button class='btn btn-dark' onclick='history.back()'>Back</button></h4>
</div>
</body>