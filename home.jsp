
<%@ include file="common/header_user.jsp"%>

<head>
<link rel="stylesheet" href="home.css">
</head>
<body>

	<% String user_id = (String)session.getAttribute("user_id");
		if(user_id != null){%>

	<%
		//session.setAttribute("userid", userid);
		} else{ 
			response.sendRedirect("index.jsp");
		}%>

	<section id="intro-part">

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<img class="img-fluid mx-auto d-block" src="images\spices1.png"
						height="100%" width="50%" />
				</div>
				<div class="col-md-6 mt-5 pt-5">
					<div class="col-md-10  main_content">
						<h2>
							WELCOME TO <b>SPICYWORLD ONLINE</b>
						</h2>
						<h3>SHOP ONLINE AND PICK UP FROM WAREHOUSE</h3>
						<div class="inner-content">Buy your favorite Indian
							groceries online at great prices! SpicyWorld now offers you to
							shop from home and pick up from our warehouse on your
							convenience. Just click on the link below and shop for all Indian
							grocery things!</div>
						<br> <a href="#cat-items">
							<button type="button" class="btn button-1 btn-lg">SHOP
								ONLINE</button>
						</a>
					</div>
				</div>
			</div>
	</section>

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


	<section id="cat-items">
		<div class="container-fluid">
			<div class="row pt-5">
				<div class="col-md-4 cat-items-1 mt-5">
					<div class="col-md-10 offset-md-2">
						<ul class="list">
							<li><a
								href="products.jsp?category=Biscuits and Toasts&page=1">Biscuits
									& Toasts</a></li>
							<li><a href="products.jsp?category=Daal and Lentils&page=1">Daal
									& Lentils</a></li>
							<li><a
								href="products.jsp?category=Wheat and Mix Flour&page=1">Wheat&Mix
									Flour</a></li>
							<li><a href="products.jsp?category=Frozen&page=1">Frozen</a></li>
							<li><a href="products.jsp?category=Health&page=1">Health</a></li>
							<li><a href="products.jsp?category=Jaggery&page=1">Jaggery</a></li>
							<li><a href="products.jsp?category=Mukhwas&page=1">Mukhwas(Mouth
									Freshner)</a></li>

						</ul>
					</div>
				</div>
				<div class="col-md-4 cat-items-2 mt-5">
					<div class="col-md-10 offset-md-2">
						<ul class="list ">
							<li><a href="products.jsp?category=Namkeens&page=1">Namkeens</a></li>
							<li><a
								href="products.jsp?category=Noodles and Masala&page=1">Noodles,Soup
									& Masala</a></li>
							<li><a href="products.jsp?category=Oil and Ghee&page=1">Oil
									& Ghee</a></li>
							<li><a href="products.jsp?category=Papad and Papdi&page=1">Papad
									& Papdi</a></li>
							<li><a href="products.jsp?category=Patanjali&page=1">Patanjali</a></li>
							<li><a
								href="products.jsp?category=Pickles and Sauces&page=1">Pickles
									& Sauces</a></li>
							<li><a href="products.jsp?category=Poha and Mamra&page=1">Poha
									& Mamra</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 cat-items-1 mt-5">
					<div class="col-md-10 offset-md-2">
						<ul class="list">
							<li><a href="products.jsp?category=Rice&page=1">Rice</a></li>
							<li><a href="products.jsp?category=Salt&page=1">Salt</a></li>
							<li><a href="products.jsp?category=Tea and Coffee&page=1">Tea
									& Coffee</a></li>
							<li><a href="products.jsp?category=Spices&page=1">Spices(Powder
									& Whole)</a></li>
							<li><a href="products.jsp?category=Upvas&page=1">Upvas(Fasting
									Food)</a></li>
							<li><a href="products.jsp?category=Yogurt and Panner&page=1">Yogurt&Panner</a></li>
							<li><a href="products.jsp?category=Ready To Eat&page=1">Ready
									To Eat</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</section>
	<%@include file="common/footer_user.jsp"%>
</body>

</html>