<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Sign Up</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-white">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">JustorderUtil.com</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		
			<div class="collapse navbar-collapse nav-right" id="navbarNavAltMarkup">
				<div class="navbar-nav ">					 
						<a class="nav-link mx-4" href="login"
						tabindex="-1" aria-disabled="true">Login</a>
				</div>
			</div>
		</div>
	</nav>
<div class="container" style="max-width:50%;">
<h3>Register Your Self</h3>

<form action="saveuser" method="POST" >
	<div class="mb-3">
    	<label for="name" class="form-label">Name</label>
    	<input type="text" class="form-control" id="name" name="name" placeholder="Enter Your Name">
  </div>
  
  <div class="mb-3">
    	<label for="email" class="form-label">Email</label>
    	<input type="email" class="form-control" id="email" name="email" placeholder="Enter Your Email">
  </div>
  
  <div class="mb-3">
    	<label for="mobile" class="form-label">Mobile</label>
    	<input type="text" class="form-control" id="moblie" name="mobile" placeholder="Enter Your Mobile">
  </div>

	<div class="mb-3">
    	<label for="address" class="form-label">Address</label>
    	<input type="text" class="form-control" id="address" name="hNo" placeholder="House No">
    	<input type="text" class="form-control" id="address" name="add1" placeholder="Address Line">
    	<input type="text" class="form-control" id="address" name="add2" placeholder="Street">
  	</div>
  	<div class="mb-3">
    	<label for="city" class="form-label">City</label>
    	<input type="text" class="form-control" id="city" name="city" placeholder="City">
  </div>
  
  <div class="mb-3">
    	<label for="pincode" class="form-label">Pincode</label>
    	<input type="text" class="form-control" id="pincode" name="pincode" placeholder="Pincode"> 
  </div>
  
  <div class="mb-3">
    	<label for="password" class="form-label">Password</label>
    	<input type="password" class="form-control" id="password" name="psw" placeholder="Enter Password">
  </div>
  
  <div class="mb-3">
    	<label for="conform" class="form-label">Conform Password</label>
    	<span id="message"></span>
    	<input type="password" class="form-control" id="conform" name="conpassword" placeholder="Conform Your Password">
  </div>
  
  <div class="mb-3">
  	<button class="btn btn-warning" type="submit">SUBMIT</button>
  </div>
</form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script >
$('#password, #conform').on('keyup', function () {
	  if ($('#password').val() == $('#conform').val()) {
	    $('#message').html('Matching').css('color', 'green');
	  } else 
	    $('#message').html('Not Matching').css('color', 'red');
	});

</script>
</body>
</html>