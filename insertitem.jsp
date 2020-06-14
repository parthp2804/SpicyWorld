<html>
<head>
<title>Insert item</title>

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
		<div class="card-header">INSERT ITEM</div>
		<div class="card-body">
			<form action="InsertItemServlet" method="post" enctype="multipart/form-data">
				<table class="table">
				<tr>
						<td>Item id:<br></td>
						<td><input type="text" name="item_id"
							 class="form-control" /><br></td>
					</tr>
					<tr>
						<td>Item name:</td>
						<td><input type="text" name="item_name"
							 class="form-control" /></td>
					</tr>

					<tr>
						<td>Item category:</td>
						<td><input type="text" name="item_category"
							class="form-control" /></td>
					</tr>
					<tr>
						<td>Item price:<br></td>
						<td><input type="text" name="item_price" 
							class="form-control" /><br></td>
					</tr>
					<tr>
						<td>Item max quantity:</td>
						<td><input type="text" name="item_quantitymax" 
							class="form-control" /><br></td>
					</tr>
					<tr>
						<td>Item image:</td>
						<td><input type="file" name="item_image" 
							class="form-control" /><br></td>
					</tr>
					<tr>
						<td><input type="submit" class="btn btn-success" /></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>
<!--script type="text/javascript"> window.onload = alertName; </script-->
<%@ include file="common/footer_admin.jsp"%>
</body>
</html>