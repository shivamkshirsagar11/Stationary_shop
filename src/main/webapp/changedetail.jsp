<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
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

<form class="container" action="editcus" style="max-width:50%;">
<h3>Set up your Account</h3>
<span style="color:red;">${cuserror}</span>
<div class="form-row">
    <div class="form-group col-md-6">
      <label for="name">Name</label>
      <input type="text" class="form-control" name="name" required>
    </div>
    
    <div class="form-group col-md-6">
      <label for="mobile">DOB</label>
      <input type="dob" class="form-control" name="dob" required>
    </div>
    
    <div class="form-group col-md-6">
      <label for="email">Email</label>
      <input type="email" class="form-control" name="email" required>
    </div>

 <div class="form-group col-md-6">
    <label for="inputAddress">Address</label>
    <textarea name="address" rows="4" cols="50"></textarea>
  </div>
  
    <div class="form-group col-md-6" required>
      <label for="inputCity">City</label>
      <input type="text" class="form-control" name="city">
    </div>
    
    <div class="form-group col-md-2" required>
      <label for="inputZip">Pincode</label>
      <input type="text" class="form-control" name="pincode">
    </div>
    </div>
  <div>
  <br>
  <button type="submit" class="btn btn-dark">Update Details</button>
  </div>
</form>

</body>
</html>