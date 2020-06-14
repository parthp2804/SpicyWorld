
<%@ include file="common/header_admin.jsp"%>
<body>
	
	<div class="card">
		<div class="card-header">SIGNUP</div>
		<div class="card-body">
			<form action="CreateOwnerServlet" method="post">
				<table class="table">
				<tr>
						<td>USERNAME:<br></td>
						<td><input type="text" name="username"
							placeholder="enter Username" class="form-control" /><br></td>
					</tr>
					<tr>
						<td>FIRSTNAME:</td>
						<td><input type="text" name="firstname"
							placeholder="enter Firstname" class="form-control" /></td>
					</tr>

					<tr>
						<td>LASTNAME:</td>
						<td><input type="text" name="lastname"
							placeholder="enter lastname" class="form-control" /></td>
					</tr>
					<tr>
						<td>AGE:<br></td>
						<td><input type="text" name="age" placeholder="enter Age"
							class="form-control" /><br></td>
					</tr>
					<tr>
						<td>GENDER:</td>
						<td><input type="radio" name="gender" value="Male"
							class="form-control" checked="checked">Male</input><input
							type="radio" name="gender" value="Female" class="form-control">Female</input>
							<input type="radio" name="gender" value="Male"
							class="form-control">Others</input><br></td>
					</tr>
					<tr>
						<td>MOBILE NUMBER :<br></td>
						<td><input type="text" name="mobileno"
							placeholder="enter Mobileno" class="form-control" /><br></td>
					</tr>
					
					<tr>
						<td>PASSWORD:<br></td>
						<td><input type="password" name="password"
							placeholder="enter Password" class="form-control" /><br></td>
					</tr>
					
					<tr>
						<td><input type="submit" class="btn btn-primary" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

<%@ include file="common/footer_admin.jsp"%>
</body>
</html>