
<%@include file="common/header_user.jsp"%>
<body>
	<body>
	<% 
	
	String cart_id = "0000C";
	String user_id= (String)session.getAttribute("user_id");
	if(user_id==null){
		session.setAttribute("ERROR", "No UserID Found");
		response.sendRedirect("error.jsp");
	}else{
		cart_id = "C"+user_id;
	}
	
	
	CartMain cartmain = (CartMain)session.getAttribute(cart_id);
	if(cartmain!=null){
		session.setAttribute(cart_id, cartmain);
		
	}else{
		session.setAttribute("ERROR", "No Cart Found");
		response.sendRedirect("error.jsp");
	}
	
	%>
	<div class="card">
		<div class="card-header">SIGNUP</div>
		<div class="card-body">
			<form action="CustomerServlet" method="get">
				<table class="table">
					<tr>
						<td>FIRSTNAME:</td>
						<td><input type="text" name="firstname" required
							placeholder="enter Firstname" class="form-control" /></td>
					</tr>

					<tr>
						<td>LASTNAME:</td>
						<td><input type="text" name="lastname" required
							placeholder="enter lastname" class="form-control" /></td>
					</tr>
					<tr>
						<td>ADDRESS:<br></td>
						<td><textarea  rows="4" cols="50" name="address" placeholder="enter Your Address" required
							class="form-control" ></textarea><br></td>
					</tr>
					<tr>
						<td>MOBILE NUMBER :<br></td>
						<td><input type="tel" name="mobileno" pattern="^\(\+61)[0-9]{1}[0-9]{4}[0-9]{4}$" required
							placeholder="+61 x xxxx xxxx" class="form-control" /><br></td>
					</tr>
					
					<tr>
						<td>EMAIL:<br></td>
						<td><input type="email" name="emailid" required
							placeholder="enter Email" class="form-control" /><br></td>
					</tr>
					<tr>
						<td>PICKUP DATE:<br></td>
						<td><input type="date" name="pickdate" required
							placeholder="enter Pickup date" class="form-control" /><br></td>
					</tr>
					<tr>
						<td>PICKUP TIME:<br></td>
						<td><input type="time" name="picktime" min="10:00:00" max="18:00:00" required
							placeholder="enter Pickup time" class="form-control" /><br></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="btn btn-primary" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>