<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Admin_login</title>

<style>
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}


</style>
</head>
<body>
<%@ include file="common/header_user.jsp" %>
<img src="images/logo.png" class=" mx-auto d-block" width="190" height="85" alt="..."/>
<div class="card mt-5">
<div class="card-header">LOGIN</div>
<div class="card-body">
<form action="Authenticator" method="post">
<div class="table">
USERNAME:<br>
<input type="text" name="username" placeholder="enter Username" class="form-control"/><br>
PASSWORD:<br>
<input type="password" name="password" placeholder="enter Password" class="form-control"/><br>
<input type="submit" class="btn btn-success" value="Login"/><br>
</div>
</form>
</div>
</div>
<!--  script type="text/javascript"> window.onload = alertName; </script-->
<%@ include file="common/footer_admin.jsp"%>
</body>
</html>