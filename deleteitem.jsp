
<%@ include file="common/header_admin.jsp"%>
<body>
<%@ include file="common/setError.jsp"%>
	<div class="card">
		<div class="card-header">DELETE ITEM</div>
		<div class="card-body">
			<form action="DeleteItemServlet" method="post">
				<table class="table">
				<tr>
						<td>Item id:<br></td>
						<td><input type="text" name="item_id"
							 class="form-control" /><br></td>
					</tr>
					
					<tr>
						<td><input type="submit" class="btn btn-success" /></td>
					</tr>
					
					
				</table>
			</form>
		</div>
	</div>

<%@ include file="common/footer_admin.jsp"%>	
</body>
</html>