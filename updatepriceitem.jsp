<html>
<head>
<title>Update items</title>

</head>
<%@ include file="common/header_admin.jsp"%>
<body>
	<%
	   	String ERROR = (String)session.getAttribute("ERROR");
	   %> 
	    <% if (ERROR!= null){%>
	     <div class="row">
	     <h3>ERROR</h3>
	     </div>
	     <% session.removeAttribute("ERROR");
	    }else {}%>
	<div class="card">
		<div class="card-header">UPDATE PRICE ITEM</div>
		<div class="card-body">
			<form action="UpdateItempriceServlet" method="post">
				<table class="table">
				<tr>
						<td>Item id:<br></td>
						<td><input type="text" name="item_id"
							 class="form-control" /><br></td>
					</tr>
					<tr>
						<td>Item price:</td>
						<td><input type="text" name="item_price"
							 class="form-control" /></td>
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