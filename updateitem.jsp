<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="common/header_admin.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Update items</title>
</head>
<body style="background-color:powderblue">
<h1 style="text-align: center">
 UPDATE ITEM

</h1>
<form action = "updatepriceitem.jsp">

<input type="submit" value="Update Item Price" class="mx-auto d-block btn btn-danger"/>
</form>
<br>
<form action = "updatequantityitem.jsp">

<input type="submit" value="Update Item Max Quantity" class="mx-auto d-block btn btn-danger"/>
</form>
<br>
<form action = "updateimageitem.jsp">

<input type="submit" value="Update Item Image" class="mx-auto d-block btn btn-danger"/>
</form>
<br>
<br>



<%@ include file="common/footer_admin.jsp"%>
</body>

</html>