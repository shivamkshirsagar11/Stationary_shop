<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
  font-family: 'Josefin Sans', sans-serif;
}

body{
   background-color: #f3f3f3;
}

.wrapper{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  width: 550px;
  display: flex;
  box-shadow: 0 1px 20px 0 rgba(69,90,100,.08);
}

.wrapper .left{
  width: 35%;
  background: linear-gradient(to right,#01a9ac,#01dbdf);
  padding: 30px 25px;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  text-align: center;
  color: #fff;
}

.wrapper .left img{
  border-radius: 5px;
  margin-bottom: 10px;
}

.wrapper .left h4{
  margin-bottom: 10px;
}

.wrapper .left p{
  font-size: 12px;
}

.wrapper .right{
  width: 65%;
  background: #fff;
  padding: 30px 25px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
}

.wrapper .right .info,
.wrapper .right .projects{
  margin-bottom: 25px;
}

.wrapper .right .info h3,
.wrapper .right .projects h3{
    margin-bottom: 15px;
    padding-bottom: 5px;
    border-bottom: 1px solid #e0e0e0;
    color: #353c4e;
  text-transform: uppercase;
  letter-spacing: 5px;
}

.wrapper .right .info_data,
.wrapper .right .projects_data{
  display: flex;
  justify-content: space-between;
}

.wrapper .right .info_data .data,
.wrapper .right .projects_data .data{
  width: 45%;
}

.wrapper .right .info_data .data h4,
.wrapper .right .projects_data .data h4{
    color: #353c4e;
    margin-bottom: 5px;
}

.wrapper .right .info_data .data p,
.wrapper .right .projects_data .data p{
  font-size: 13px;
  margin-bottom: 10px;
  color: #919aa3;
}

.wrapper .social_media ul{
  display: flex;
}

.wrapper .social_media ul li{
  width: 45px;
  height: 45px;
  background: linear-gradient(to right,#01a9ac,#01dbdf);
  margin-right: 10px;
  border-radius: 5px;
  text-align: center;
  line-height: 45px;
}

.wrapper .social_media ul li a{
  color :#fff;
  display: block;
  font-size: 18px;
}
</style>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>profile</title>
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
</head>
<body>

<div class="wrapper">

    <div class="left">
    
        <img src="https://cdn5.vectorstock.com/i/thumb-large/45/79/male-avatar-profile-picture-silhouette-light-vector-4684579.jpg" 
        alt="user" width="100">
        <h4>${user.getName() }</h4>
         
    </div>
    <div class="right">
        <div class="info">
            <h3>Information <a href="updateuser"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg></a></h3>
            
            <div class="info_data">
                 <div class="data">
                    <h4>Email</h4>
                    <p>${user.getEmail() }</p>
                 </div>
                 <div class="data">
                   <h4>Phone</h4>
                    <p>${user.getMobile() }</p>
              </div>
            </div>
        </div>
      
      <div class="projects">
            <div class="projects_data">
                 <div class="data">
                    <h4>LastLogin</h4>
                    <p> ${user.getLastLogin() }</p>
                 </div>
                 <div class="data">
                    <h4>Address</h4>
                    <p> ${add.gethNo() }, ${add.getAddress1() }, ${add.getAddress2() }
                 	, ${add.getCity() }
                 	, ${add.getPincode() }</p>
                 </div>
            </div>
        </div>
      
    </div>
</div>

</body>
</html>