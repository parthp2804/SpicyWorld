<%@include file="common/header_user.jsp"%>

	<%
	   	String ERROR = (String)session.getAttribute("ERROR");
	   %> 
	    <% if (ERROR!= null){%>
	     <div  align="center" style="height: 300px; width: auto; padding-top: 150px; padding-bottom: 150px;">
	     <h3><%= ERROR %></h3>
	     </div>
	     <% session.removeAttribute("ERROR");
	    }else {%>
	    <div  align="center"  style="height: 300px;font-family: cursive; ; ;width: auto; padding-top: 150px; padding-bottom: 150px;">
	     	<h3>Sorry for Inconvenience</h3>
	     </div>
	     <%} %>
	    
<%@include file="common/footer_user.jsp"%>