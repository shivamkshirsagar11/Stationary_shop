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
	<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}
hr.new5 {
  border: 7px solid brown;
  border-radius: 5px;
}
</style>
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
						<form method="post" action="profile">
						<input type="hidden" name="userid" value="${user.getId() }">
						<button type="submit" class="btn btn-warning"
						>${user.getName()}'s Profile</button> </form>
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

<hr class="new5">
  <div class="row">
  <h3 style="color:brown;padding-left:680px;">Available Books</h3>
  <% for(int i = 0; i < 5; i+=1) { %>
    <div class="card">
  <img src="/w3images/jeans3.jpg" alt="Denim Jeans" style="width:100%">
  <h1>Tailored Jeans</h1>
  <p class="price">$19.99</p>
  <p>Some text about the jeans. Super slim and comfy lorem ipsum lorem jeansum. Lorem jeamsun denim lorem jeansum.</p>
  <p><button>Add to Cart</button></p>
</div>
    <% } %>
  </div>
  <hr class="new5">
    <div class="row mt-4">
  <h3 style="color:brown;padding-left:680px;">Available Pen</h3>
  <% for(int i = 0; i < 5; i+=1) { %>
    <div class="card">
  <img src="/w3images/jeans3.jpg" alt="Denim Jeans" style="width:100%">
  <h1>Tailored Jeans</h1>
  <p class="price">$19.99</p>
  <p>Some text about the jeans. Super slim and comfy lorem ipsum lorem jeansum. Lorem jeamsun denim lorem jeansum.</p>
  <p><button>Add to Cart</button></p>
</div>
    <% } %>
  </div>
  
	
</div>
<!--End Products  -->
</body>
</html>
