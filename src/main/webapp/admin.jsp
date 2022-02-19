<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<html><head><title>Admin desk</title><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head>
<body>
<h1>Admin hello!!</h1>
<ul>
<li><a class='btn btn-dark' href='allcus'>All customers</a></li><br>
<li><a class='btn btn-dark' href='allitems'>Warehouse</a></li><br>
<li><a class='btn btn-dark' href='unsolved'>Unsolved complaints</a></li><br>
<li><a class='btn btn-dark' href='solved'>Solved complaints</a></li><br>
 <li><a href="addproduct.jsp" class='btn btn-dark'>Product Management</a></li>
</ul>
<%out.print("<h4><a href=\"login.jsp\" class='btn btn-danger'>Logout</a></h4></div>"); %>
</body>
</html>