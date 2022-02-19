<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
     	Stationary Shop
    </a>
  </div>
</nav>

<form class="container" action="check" method="post" style="max-width:50%;">
<h3>Register Product</h3>
<span style="color:red;">${error}</span>
<div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputState">Choose Product</label>
      <select id="inputState" class="form-control" name="product" required>
      	<option value="" selected disabled>Choose..</option>
        <option>Book</option>
        <option>Pen</option>
        <option>Desk</option>
        <option>Calculator</option>
      </select>
    </div>


    <div class="form-group col-md-6">
      <label for="email">Product ID</label>
      <input type="text" class="form-control" name="pId" required>
    </div>
    
    
    <div class="form-group col-md-6">
      <label for="mobile">Product Name</label>
      <input type="text" class="form-control" name="pName" required>
    </div>
    
  <div class="form-group col-md-6">
    <label for="inputAddress">Description</label>
    <input type="text" class="form-control" name="des" required>
  </div>
  </div>
  <div>
  <br>
  <button type="submit" class="btn btn-dark">Add new product</button>
  </div>
</form><br>
<div class='container' style='max-width:50%;'><h4><button class='btn btn-dark' onclick='history.back()' >Go Back</button></h4></div>
<div class='container' style='max-width:50%;'><h4><a class='btn btn-warning' href='updatestock.jsp' >Update existing stock</a></h4></div>
</body>
</html>