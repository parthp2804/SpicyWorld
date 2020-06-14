<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin_home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<link rel="stylesheet" href="resources/mycss/header_admin.css">
<% 		
		session = request.getSession();
		String USERNAME = session.getAttribute("USERNAME").toString();
      	if(USERNAME == null){
	      RequestDispatcher rd = request.getRequestDispatcher("login_admin.jsp");
		  rd.forward(request, response);
   }
%>
</head>
<body style="background-color:#fff">
<nav class="navbar navbar-expand-lg navbar-light navi sticky-top">
    <a class="navbar-brand" href="index.jsp">
    <img src="images/logo.png" width="190" height="85" alt="" class="ml-5"/>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav ">
    <li class="nav-item mr-3">
      <a class="nav-link" href="home_admin.jsp">Manage</a>
      </li>
    <li class="nav-item mr-3">
      <a class="nav-link" href="signup.jsp">Signup</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="home.jsp">Products</a>
        </li>
    <li class="nav-item mr-3 cart">
      <a class="nav-link" href="login_admin.jsp">Logout</a>
      </li>
    </ul>
    </nav>
