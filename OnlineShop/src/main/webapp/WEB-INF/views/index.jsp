<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page isELIgnored="false" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>INDEX</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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
					<a class="nav-link active mx-4" aria-current="page" href="#">Home</a> <a
						class="nav-link" href="#">Products</a> 
						<a class="nav-link mx-4"
						href="#">Shop</a> 
				</div>
			</div>
		</div>
	</nav>


<!-- Home page carousel -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src='<c:url value="/resources/img/book.jpg" />' height="600px" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Read Novels</h5>
        <button class='btn btn-success'>Explore Books</button>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/resources/img/book.jpg" />' height="600px" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Read Novels</h5>
        <button class='btn btn-success'>Explore Pens</button>
      </div>
    </div>
    <div class="carousel-item">
      <img src='<c:url value="/resources/img/book.jpg" />'  height="600px" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Read Novels</h5>
        <button class='btn btn-success'>Explore Desk</button>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
<!-- End carousel -->

<!--Products  -->
<div class="container" style="max-width:100%">


  <div class="row">
  <h3>Available Books</h3>
  <% for(int i = 0; i < 5; i+=1) { %>
    <div class="card mt-5 ms-auto" style="width: 18rem;">
  <img src='<c:url value="/resources/img/book.jpg" />' class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Product Name</h5>
    <p class="card-text">Product details Product details Product details Product details Product details Product details Product details Product details Product details Product details </p>
    <a href="#" class="btn btn-primary">Buy Now</a>
  </div>
</div>
    <% } %>
  </div>
    <div class="row mt-4">
  <h3>Available Pen</h3>
  <% for(int i = 0; i < 5; i+=1) { %>
    <div class="card mt-5 ms-auto" style="width: 18rem;">
  <img src='<c:url value="/resources/img/book.jpg" />' class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Product Name</h5>
    <p class="card-text">Product details Product details Product details Product details Product details Product details Product details Product details Product details Product details </p>
    <a href="#" class="btn btn-primary">Buy Now</a>
  </div>
</div>
    <% } %>
  </div>
  
	
</div>
<!--End Products  -->
</body>
</html>
