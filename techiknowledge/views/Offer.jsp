<%@ include file="../include/header.jsp" %>

<body>
	<div id="header">
<%@ include file="../include/menu.jsp" %>
	</div>
<%@ include file="../include/usermenu.jsp" %>
	<div id="body">
		<div id="background">
			
		</div>
		<div id="section">
<%
if(session.getAttribute("User")!=null){
%>
		<%@ include file="OfferList.jsp" %>
<%
}
%>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>