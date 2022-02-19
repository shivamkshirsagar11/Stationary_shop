<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Stock</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form class="container" style="max-width:50%; margin-top:20px; margin-left:35%;" method="post" action="update">
<h4>Update Stock of Available Product</h4>
<span style="color: red;">${updateerror}</span>
<div class="form-row">

<div class="form-group col-md-6">
<label for="inputState">Choose Product</label>

      <select class="form-control" name="product" required>
      	<option value="" selected disabled>Choose..</option>
        <option>Book</option>
        <option>Pen</option>
        <option>Desk</option>
        <option>Calculator</option>
      </select>
</div>

<div class="form-group col-md-6">
	
	<label>Enter Product ID:</label>
	<input type="text" class="form-control" name="id">
</div>

<div class="form-group col-md-6">
<label>Enter no of stock:</label>
<input type="number" class="form-control" name="stock" min="0">
</div>

<div>
<br>
<button class="btn btn-dark">Update Stock</button>
</div>
</form>
<c:if test=${invalid.equal('true')}">Product Not Found!!!</c:if>
</body>
</html>