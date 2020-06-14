<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ page import="au.com.spicyworld.dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="au.com.spicyworld.model.Item"%>
<%@ page import="au.com.spicyworld.dao.CartMain" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.stream.Collectors"%>
<%@ page import="au.com.spicyworld.model.Customer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>SpicyWorld</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="resources/mycss/header_user.css">
<link rel="stylesheet" href="resources/mycss/footer_user.css">
<link rel="stylesheet" href="resources/mycss/products.css">
<link rel="stylesheet" href="resources/mycss/home.css">
</head>

<nav class="navbar navbar-expand-lg navbar-light navi sticky-top">
    <a class="navbar-brand" href="home.jsp">
    <img src="images\logo.png" width="190" height="85" alt="" class="ml-5"/>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav ">
    <li class="nav-item mr-3 home">
      <a class="nav-link" href="home.jsp">Home</a>
      </li>
      <li class="nav-item mr-3">
        <a class="nav-link" href="home.jsp#cat-items">All Departments</a>
        </li>
    <li class="nav-item mr-3 cart">
      <a class="nav-link" href="
      <c:url value="/CartServlet">
        	<c:param name="action" value="viewCart"/>
        	
        
        </c:url>
      ">Cart</a>
      </li>
    </ul>
    </div>
    </nav>
 <div style="background-color:red;color:white;">
<marquee>Due to this pandemic situation,products could be bought in limited quantity.Sorry for inconvenience</marquee>
</div>