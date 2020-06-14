<%@ include file="common/header_user.jsp"%>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.minus-btn img {
  margin-bottom: 3px;
}
.plus-btn img {
  margin-top: 2px;
}

div{
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
</style>
</head>
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
		Customer customer = (Customer)session.getAttribute("customer"+cart_id);
	%>
	<div align="center" >Personal Detail
	<table>
		<tr>
			<th>Order ID</th>
			<th><%= customer.getOrder_ID() %></th>
		</tr>
		<tr>
			<td>First Name</td>
			<td><%= customer.getFirstname() %></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><%= customer.getLastname() %></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><%= customer.getAddress() %></td>
		</tr>
		<tr>
			<td>Mobile No</td>
			<td><%= customer.getMobileno() %></td>
		</tr>
		<tr>
			<td>Email ID</td>
			<td><%= customer.getEmailid() %></td>
		</tr>
		<tr>
			<td>Pick Up Date</td>
			<td><%= customer.getPickdate() %></td>
		</tr>
		<tr>
			<td>Pick Up Time</td>
			<td><%= customer.getPicktime() %></td>
		</tr>
	</table>
	</div>
	<div align="center" >Cart Detail</div>
	<table>
		<tr>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Price</th>
			
		</tr>

		<%
 		Map< String ,Integer> cart =  cartmain.getCartListHash();
 		Set< Map.Entry< String,Integer> > st = cart.entrySet();
 		ItemImpl itemimpl =  new ItemImpl();
 		Item item = new Item();
		float total_price = 0;
 		for (Map.Entry<String, Integer> me : st) 
 		 {
 			item =itemimpl.getItem_info(me.getKey(), me.getValue());
 			
 		 	if(item==null){
 		 		break;
 		 	}
 		 	float price = item.getItem_price()*item.getItem_quantitymax();
 		 	price = (float) (Math.round(price * 100.0) / 100.0);
 		 	total_price = price + total_price;
 		 	
 		 	%>
		<tr>
			<td><%= item.getItem_name() %></td>
			<td><%= item.getItem_quantitymax() %></td>
			<td>$ <%= price %></td>
		</tr>
		<% }%>
		<tr>
			<td></td>
			<td>Total Price</td><%total_price = (float) (Math.round(total_price * 100.0) / 100.0); %>
			<td>$<%= total_price %></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td>
				<div><% session.setAttribute("cart", cartmain);
							session.setAttribute("customer", customer);%>
					<a href="
						<c:url value="/MailServlet"></c:url>">
						
        				<button type="button" name="button">
        					Checkout
        				</button>
					</a>
				</div>
			</td>
		</tr>
	</table>
	
<%@include file="common/footer_user.jsp"%>