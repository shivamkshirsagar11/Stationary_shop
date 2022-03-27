<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Logging out</title>
</head>
<body>
<h3>Please wait while we Log you out</h3>
<script>
function Redirect() 
{  
    window.location="login"; 
} 
document.write("You will be redirected to a new page in 3 seconds"); 
setTimeout('Redirect()', 3000);
</script>
</body>
</html>