<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
<style>
table,th,td{
border: 2px solid black;
}
</style>
</head>
<body>
<h2>Cart</h2><hr>
<c:if test="${cg != null}">
<table>
<tr><th>Cart uniq id</th><td>${cg.getId()}</td></tr>
<tr><th>Cart creation date</th><td>${cg.getCartGenerationDate()}</td></tr>
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Quantity</th>
<th>added on</th>
</tr>
<c:forEach var="x" items="${ucl}">
<tr>
<td>${x.getItemId() }</td>
<td>${x.getItemName() }</td>
<td>${x.getItemPrice() }</td>
<td><div class="container">
<input class="${x.getItemId()}" type="button" onclick="decrementValue('${x.getItemId()}')" value="-">

<input type="text" name="quantity" value="${x.getItemCount() }" maxlength="2" max="10" size="1" id="${x.getItemId()}" class="${x.getItemId()}" readonly>

<input type="button" onclick="incrementValue('${x.getItemId()}')" value="+" class="${x.getItemId()}">

<input type="text" style="display: none;"value="wait..."class="${x.getItemId()}" readonly>
</div></td>
<td>${x.getDateAndTime() }</td>
</tr>
</c:forEach>
</table>
<c:if test = "${ucl.size() > 0}">
<a class="btn btn-warning" href="billing">Make Payment</a>
</c:if>
</c:if>
<h3 style="color:red">${nullcarterror }</h3>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

function incrementValue(a)
{	var x = document.getElementsByClassName(a);
	x[0].style.display = "none";
	x[1].style.display = "none";
	x[2].style.display = "none";
	x[3].style.display = "inline-block";
var value = parseInt(document.getElementById(a).value, 10);
value = isNaN(value) ? 0 : value;
if(value<10){
    value++;
        document.getElementById(a).value = value;
        $.ajax({
    	    type : "POST",
    	    url : "addone",
    	    data : {
    	    "id":a,
    	    "qty":value,
    	    },
    	    success: function(data){
    	    	setTimeout(()=>{
        	    	x[0].style.display = "inline-block";
            		x[1].style.display = "inline-block";
            		x[2].style.display = "inline-block";
            		x[3].style.display = "none";
        	    	},3000)
    	    }
    	}); 
}
}
function decrementValue(a)
{
	var x = document.getElementsByClassName(a);
	x[0].style.display = "none";
	x[1].style.display = "none";
	x[2].style.display = "none";
	x[3].style.display = "inline-block";
		var value = parseInt(document.getElementById(a).value, 10);
	    value = isNaN(value) ? 0 : value;
	    if(value>1){
	        value--;
	            document.getElementById(a).value = value;
	            $.ajax({
	        	    type : "POST",
	        	    url : "removeone",
	        	    data : {
	        	    "id":a,
	        	    "qty":value,
	        	    },
	        	    success: function(data){
	        	    	setTimeout(()=>{
	        	    	x[0].style.display = "inline-block";
	            		x[1].style.display = "inline-block";
	            		x[2].style.display = "inline-block";
	            		x[3].style.display = "none";
	        	    	},3000)
	        	    }
	        	}); 
	    }
}
</script>
</body>
</html>