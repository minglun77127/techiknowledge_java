<%@ page import="com.techiknowledge.dao.*" %>
<div id="usermenu" style="text-align:center">
<%
if(session.getAttribute("User")!=null){
	User user = (User)session.getAttribute("User");
	if(user.getType()==1){
%>
	<ul>
		 <li><a id="btn_showrequest" class="active" href="#news">My Request</a></li>
	     <li><a id="btn_showoffer"  href="#home">Request Service</a></li>
		 <li><a id="btn_showprofile" href="#news">My Profile</a></li>
	</ul>
<%
	}else if(user.getType()==0){
%>
		<ul>
			 <li><a id="btn_showbid" class="active" href="#news">My Bid</a></li>
			 <li><a id="btn_showmap" href="#news">Available Request</a></li>
			 <li><a id="btn_showprofile" href="#news">My Profile</a></li>
		</ul>
<%		
	}
}
%>
</div>