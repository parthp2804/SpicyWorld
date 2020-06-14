
<%@ include file="common/header_user.jsp"%>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	
	<%
		String flag = (String) request.getAttribute("flag");
		if (flag.equals("true")) {
			session.removeAttribute("flag");
	%>
	<div width="100%" align="center">
		<br> <br> <br>
		<h1>Thanks for Shopping</h1>
		<h5>*Check your mail for order details*</h5>
		<div align="center" class="mt-5">
			<br> <a href="index.jsp">
				<button type="button" name="button" class="btn btn-success">
					Continue Shopping</button>
			</a>
		</div>
	</div>
	<%
		} else {
			session.setAttribute("ERROR", "Shop First");
			response.sendRedirect("home.jsp");
		}
	%>
	<%
		response.setHeader("Cache-Control", "no-cache");

		//Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control", "no-store");

		//Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0);

		//Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma", "no-cache");
		//HTTP 1.0 backward enter code here
	%>
	<br>
	<br>

	<%@ include file="common/footer_user.jsp"%>