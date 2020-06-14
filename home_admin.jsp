
<%@ include file="common/header_admin.jsp" %>


		<%
	   	String ERROR = (String)session.getAttribute("ERROR");
	   %> 
	    <% if (ERROR!= null){%>
	     <div class="row">
	     <h3>ERROR</h3>
	     </div>
	     <% session.removeAttribute("ERROR");
	    }else {}%>
<h1 style="text-align: center">
MANAGE ITEMS

</h1>
<form action = "insertitem.jsp">

<input type="submit" value="Insert Item" class="mx-auto d-block btn btn-danger" />
</form>
<br>
<form action = "updateitem.jsp">

<input type="submit" value="Update Item " class="mx-auto d-block btn btn-danger"/>
</form>
<br>
<form action = "deleteitem.jsp">

<input type="submit" value="Delete Item" class="mx-auto d-block btn btn-danger"/>
</form>
<br>

<%@ include file="common/footer_admin.jsp"%>
</body>
</html>