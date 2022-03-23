<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style type="text/css"> 
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&family=Poppins:wght@400;500;600&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body{
  background: linear-gradient(120deg,#2980b9, #8e44ad);
}
/*.center{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 400px;
  background: white;
  border-radius: 10px;
  box-shadow: 10px 10px 15px rgba(0,0,0,0.05);
}
.center h1{
  text-align: center;
  padding: 20px 0;
  border-bottom: 1px solid silver;
}


form .mb-3{
  position: relative;
  border-bottom: 2px solid #adadad;
  margin: 30px 0;
}
.mb-3 input{
  width: 100%;
  padding: 0 5px;
  height: 40px;
  font-size: 16px;
  border: none;
  background: none;
  outline: none;
}
.mb-3 label{
  position: absolute;
  top: 50%;
  left: 5px;
  color: #adadad;
  transform: translateY(-50%);
  font-size: 16px;
  pointer-events: none;
  transition: .5s;
}
.mb-3 span::before{
  content: '';
  position: absolute;
  top: 40px;
  left: 0;
  width: 0%;
  height: 2px;
  background: #2691d9;
  transition: .5s;
}*
.mb-3 input:focus ~ label,
.mb-3 input:valid ~ label{
  top: -5px;
  color: #2691d9;
}
.mb-3 input:focus ~ span::before,
.mb-3 input:valid ~ span::before{
  width: 100%;
}
.pass{
  margin: -5px 0 20px 5px;
  color: #a6a6a6;
  cursor: pointer;
}
.pass:hover{
  text-decoration: underline;
}
input[type="submit"]{
  width: 100%;
  height: 50px;
  border: 1px solid;
  background: #2691d9;
  border-radius: 25px;
  font-size: 18px;
  color: #e9f4fb;
  font-weight: 700;
  cursor: pointer;
  outline: none;
}
input[type="submit"]:hover{
  border-color: #2691d9;
  transition: .5s;
}
.signup_link{
  margin: 30px 0;
  text-align: center;
  font-size: 16px;
  color: #666666;
}
.signup_link a{
  color: #2691d9;
  text-decoration: none;
}
.signup_link a:hover{
  text-decoration: underline;
}*/
	</style>

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