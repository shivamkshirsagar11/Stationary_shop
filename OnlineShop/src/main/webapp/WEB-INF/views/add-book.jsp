<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>ADD BOOK</title>
</head>
<body>
	<div class="container">
		<h3>Add Book</h3>
		<form action="addbook" method="POST" enctype="multipart/form-data">
	<div class="mb-3">
    	<label for="pid" class="form-label">Product ID</label>
    	<input type="text" class="form-control" id="pid" name="pid" placeholder="Enter Product ID">
  </div>
  <div class="mb-3">
    	<label for="pname" class="form-label">Product Name</label>
    	<input type="text" class="form-control" id="pname" name="pname" placeholder="Enter Product Name">
  </div>
  <div class="mb-3">
    	<label for="pdesc" class="form-label">Product Description</label>
    	<input type="text" class="form-control" id="pdesc" name="pdesc" placeholder="Enter Product Description">
  </div>
  <div class="mb-3">
    	<label for="compname" class="form-label">Publisher</label>
    	<input type="text" class="form-control" id="compname" name="compname" placeholder="Publisher">
  </div>
  <div class="mb-3">
    	<label for="price" class="form-label">Price</label>
    	<input type="number" class="form-control" id="price" name="price" placeholder="Enter Product Price">
  </div>
  <div class="mb-3">
    	<label for="stock" class="form-label">Stock</label>
    	<input type="number" class="form-control" id="stock" name="stock" placeholder="Enter No of Stock">
  </div>
  <div class="mb-3">
    	<label for="author" class="form-label">Author</label>
    	<input type="text" class="form-control" id="author" name="author" placeholder="Enter Name of Author">
  </div>
  
  <div class="mb-3">
    	<label for="pages" class="form-label">No of Pages</label>
    	<input type="text" class="form-control" id="pages" name="pages" placeholder="Enter No of pages">
  </div>
  
  <div class="form-group">
    <label for="pic" class="form-label">Picture's Url</label>
    	<input type="url" class="form-control" id="pic" name="picurl">
  </div>
  
    <div class="mb-3">
  	<button class="btn btn-success" type="submit">SUBMIT</button>
  	</div>
</form>
	</div>
</body>
</html>