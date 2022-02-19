<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pen</title>
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

<form class="container" action="add" style="max-width:50%;">
<h3>Detail of Desk</h3>
<div class="form-row">
    
    <div class="form-group col-md-6">
      <label >Material</label>
      <input type="text" class="form-control" name="material" required>
    </div>
    
    
    <div class="form-group col-md-6">
      <label >Company Name</label>
      <input type="text" class="form-control" name="compname" required>
    </div>
    
  <div class="form-group col-md-6">
    <label>Price</label>
    <input type="number" class="form-control" name="price" required>
  </div>
  
  <div class="form-group col-md-6">
    <label>Stock</label>
    <input type="number" class="form-control" name="stock" required>
  </div>
  
  </div>
  <div>
  <br>
  <button type="submit" class="btn btn-dark">Register</button>
  </div>
</form>

</body>
</html>