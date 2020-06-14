

<%@include file="common/header_user.jsp"%>
<head>


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
		
		CartMain cartmain = (CartMain) session.getAttribute(cart_id);
		if (cartmain == null) {
			session.setAttribute("ERROR"+cart_id, "No Cart Found! Please Insert Item");
			response.sendRedirect("home.jsp");
		}
		//String ERROR = (String)session.getAttribute("ERROR");
	%>

	<div style="background-color: #dddddd;" align="center">
	<h2>
		<%
		
				String ERROR = (String) session.getAttribute("ERROR"+cart_id);
				
			%>
		<%
				if (ERROR != null) {
					session.removeAttribute("ERROR"+cart_id);
			%>

		<h3><%=ERROR%></h3>

		<%
				} else {
			%>



		<%
				}
			%>
	</h2>
</div>
	
	
	<div>
		<h1>CART DETAIL</h1>
	</div>
	<table>
		<tr>
			<th>Item Name</th>
			<th>Quantity</th>
			<th></th>
			<th></th>
			<th>Price</th>
			<th></th>
			
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
			<td>
				<div>
					<a href="
						<c:url value="/CartServlet">
        					<c:param name="action" value="delfromCart"/>
        						<c:param name="item_id" value="<%= me.getKey() %>"/>
        	
        			</c:url>">
        				<button class="minus-btn"  type="button" name="button"'>
        				<img src="images/minus.svg" alt="" width="15" height="15"/>
        			</button>
					</a>
				</div>
			</td>
			<td>
				<div>
					<a href="
						<c:url value="/CartServlet">
        					<c:param name="action" value="addToCartButon"/>
        						<c:param name="item_id" value="<%= me.getKey() %>"/>
        	
        				</c:url>">
        				<button class="plus-btn" type="button" name="button"'>
        					<img src="images/plus.svg" alt="" width="15" height="15"/>
        				</button>
					</a>
				</div>
			</td>
			<td>$ <%= price %></td>
			<td>
				<div>
					<a href="
						<c:url value="/CartServlet">
        					<c:param name="action" value="delItemfromCart"/>
        						<c:param name="item_id" value="<%= me.getKey() %>"/>
        	
        				</c:url>">
        				<button type="button" class="btn btn-sm btn-danger"name="button"'>
        					Remove From Cart
        				</button>
					</a>
				</div>
			</td>
		</tr>
		<% }%>
		<tr>
			
		</tr>
		<tr>
			<td>
				<div>
					<a href="
						<c:url value="/CartServlet">
        					<c:param name="action" value="emptyCart"/>
        						
        	
        				</c:url>">
        				<button type="button" class="btn  btn-sm btn-danger"name="button"'>
        					Remove Cart
        				</button>
					</a>
				</div>
			</td>
			<td></td>
			<td></td>
			<td></td><%total_price = (float) (Math.round(total_price * 100.0) / 100.0); %>
			<td>$<%= total_price %></td>
			<td>Total</td>
		</tr>
		<tr>
			
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<div>
					<a href="
						<c:url value="/customerinfo.jsp"></c:url>">
        				<button type="button" class="btn btn-success"name="button"'>
        					Proceed To Checkout
        				</button>
					</a>
				</div>
			</td>
		</tr>
	</table>

<%@include file="common/footer_user.jsp"%>