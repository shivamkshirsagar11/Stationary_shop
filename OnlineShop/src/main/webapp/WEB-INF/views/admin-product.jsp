<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Admin Pages</h2>
	<div class="container my-5">
		<h3>Books</h3>
		<a href="bookform" class="btn btn-success">Add Book</a>
		<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Publisher</th>
				<th>Author</th>
				<th>No of Pages</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			</thead>
			<tr>
			</tr>


			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.getId() }</td>
					<td>${book.getName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getAuthor()}</td>
					<td>${book.getPages()}</td>
					<td>${book.getPrice() }/-</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatebookform">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
				<h3>Pens</h3>
		<a href="penform" class="btn btn-success">Add Pen</a>
		<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Publisher</th>
				<th>Color</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			</thead>
			<tr>

			</tr>


			<c:forEach var="book" items="${pen}">
				<tr>
					<td>${book.getId() }</td>
					<td>${book.getName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getColor()}</td>
					<td>${book.getPrice() }/-</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatepenform">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
		
				<h3>Desk</h3>
		<a href="deskform" class="btn btn-success">Add Desk</a>
		<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Company Name</th>
				<th>Material</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			</thead>
			<tr>

			</tr>


			<c:forEach var="book" items="${desk}">
				<tr>
					<td>${book.getId() }</td>
					<td>${book.getName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getMaterial()}</td>
					<td>${book.getPrice() }/-</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatedeskform">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletedesk">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
		
				<h3>Calculator</h3>
		<a href="calcform" class="btn btn-success">Add calculator</a>
		<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Company Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			</thead>
			<tr>

			</tr>


			<c:forEach var="book" items="${calc}">
				<tr>
					<td>${book.getId() }</td>
					<td>${book.getName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getType()}</td>
					<td>${book.getPrice() }/-</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatecalcform">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getProductTableId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>