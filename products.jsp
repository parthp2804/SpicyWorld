
<%@ include file="common/header_user.jsp"%>

<body>
	
	
		<% String user_id = (String)session.getAttribute("user_id");
		if(user_id != null){%>
		
		<%
		//session.setAttribute("userid", user_id);
		} else{ 
			response.sendRedirect("index.jsp");
		}%>
	
	
	<div style="background-color: #dddddd;" align="center">
		<h2>
			<%
			String cart_id = "0000C";
			if(user_id == null){
				session.setAttribute("ERROR", "No UserID Found");
				response.sendRedirect("error.jsp");
			}else{
				cart_id = "C"+user_id;
			}

				String ERROR = (String) session.getAttribute("ERROR" + cart_id);

				
			%>
			<%
				if (ERROR != null) {
					session.removeAttribute("ERROR" + cart_id);
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








	<%
		String category = request.getParameter("category");
		String spageid = request.getParameter("page");
		int pageid = Integer.parseInt(spageid);
		if (category == null) {
			session.setAttribute("ERROR", "No Category");
			response.sendRedirect("products.jsp");
		}
		int total = 16;
		if (pageid == 1) {
			pageid = 0;
		} else {
			pageid = pageid - 1;
			pageid = pageid * total;
		}
	%>
	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/spicy481_storemngt_db" user="spicy481_sunny123"
		password="******" />
		
	<sql:query var="listItems" dataSource="${myDS}">
		select * from item_tb where item_category='<%=category%>' order by item_id;
	</sql:query>
	<section id="product-grid">
		<div class="row mt-1"></div>
		<div class="row mt-5">
			<div class="col-md-2">
				<div class="row ml-4 pl-2 mb-5">
					<b style="text-transform: uppercase"> <%=category%>
					</b>
				</div>
				<ul class="side-list">
					<b>ALL DEPARTMENTS</b>
					<li class="mt-3"><a
						href="products.jsp?category=Biscuits and Toasts&page=1">Biscuits
							& Toasts</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Daal and Lentils&page=1">Daal
							& Lentils</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Wheat and Mix Flour&page=1">Wheat&Mix
							Flour</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Frozen&page=1">Frozen</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Health&page=1">Health</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Jaggery&page=1">Jaggery</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Mukhwas&page=1">Mukhwas(Mouth
							Freshner)</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Namkeens&page=1">Namkeens</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Noodles and Masala&page=1">Noodles,Soup
							& Masala</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Oil and Ghee&page=1">Oil
							& Ghee</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Papad and Papdi&page=1">Papad
							& Papdi</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Patanjali&page=1">Patanjali</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Pickles and Sauces&page=1">Pickles
							& Sauces</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Poha and Mamra&page=1">Poha
							& Mamra</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Rice&page=1">Rice</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Salt&page=1">Salt</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Tea and Coffee&page=1">Tea
							& Coffee</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Spices&page=1">Spices(Powder
							& Whole)</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Upvas&page=1">Upvas(Fasting
							Food)</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Yogurt and Panner&page=1">Yogurt&Panner</a></li>
					<hr class="mr-5">
					<li><a href="products.jsp?category=Ready To Eat&page=1">Ready
							To Eat</a></li>
					<hr class="mr-5">
				</ul>
			</div>
			<div class="col-md-10">
				<div class="row mt-5">
					<c:forEach var="item" items="${listItems.rows}">
						<div class="row mt-5 ml-3">
							<div class="col-md-3 ml-2">
								<div class="card" style="width: 15rem;">
									<img
										src="${pageContext.servletContext.contextPath}/ImageServlet?item_id=${item.item_id}"
										width="120" height="200" class="card-img-top"
										alt="${item.item_name}" />
									<div class="card-body">
										<h5 class="card-title">${item.item_name}</h5>
										<div class="row">
											<div class="col-xs-12 col-md-6">
												<p class="lead">$ ${item.item_price}</p>
											</div>
											<div class="col-xs-12 col-md-6"></div>
										</div>
										<c:choose>
											<c:when test="${item.item_quantitymax == 0 }">
												<a href="#" class="btn btn-sm btn-dark">Coming Soon</a>
											</c:when>
											<c:otherwise>
												<a
													href="<c:url value="/CartServlet">
        						<c:param name="action" value="addToCart"/>
        						<c:param name="item_id" value="${item.item_id}"/>
        						<c:param name="category" value="${item.item_category}"/>
        						</c:url>"
													class="btn btn-sm btn-success">Add to cart</a>
											</c:otherwise>
										</c:choose>

									</div>
								</div>
							</div>
						</div>
					</c:forEach>


				</div>
			</div>
		</div>
	</section>
	<nav aria-label="Page navigation example" class="mt-5"
		style="background-color: #fff;">
		<ul class="pagination pagination-lg justify-content-center">
			<li class="page-item"><a class="page-link"
				href="products.jsp?category=<%=category%>&page=1">1</a></li>
			<li class="page-item"><a class="page-link"
				href="products.jsp?category=<%=category%>&page=2">2</a></li>
			<li class="page-item"><a class="page-link"
				href="products.jsp?category=<%=category%>&page=3">3</a></li>
			<li class="page-item"><a class="page-link"
				href="products.jsp?category=<%=category%>&page=4">4</a></li>
		</ul>
	</nav>
	<%@include file="common/footer_user.jsp"%>