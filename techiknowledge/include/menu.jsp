<div id="menu">
			<img src="<%=request.getContextPath()%>/images/techilogo.jpg" height="306px" width="100%">
			<ul>
<%
if(session.getAttribute("User") == null){
%>
				<li>
					<a class="home" href="<%=request.getContextPath()%>/index.jsp">Home</a>
				</li>
				<li>
					<a class="about" href="<%=request.getContextPath()%>/about.jsp">About</a>
				</li>
				<li>
					<a class="services" href="<%=request.getContextPath()%>/services.jsp">Services</a>
				</li>
				<li>
					<a class="login" id="login-user" href="#">Login</a>|<a class="signup" id="signup-user" href="#">Sign Up</a>
				</li>
<%
}else{
%>
				<li>
					<a class="home" href="<%=request.getContextPath()%>/index.jsp">Home</a>
				</li>
				<li>
					<a class="about" href="<%=request.getContextPath()%>/about.jsp">About</a>
				</li>
				<li>
					<a class="services" href="<%=request.getContextPath()%>/services.jsp">Services</a>
				</li>
				<li>
					<a class="logout" id="logout-user" href="#">Logout</a>
				</li>
<%					
}
%>
			</ul>
</div>
					
	
