<%@ page import="java.util.ArrayList" %>
<%@ page import="com.techiknowledge.dao.*" %>
<script src="<%=request.getContextPath()%>/js/offerlist.js"></script>

<%
System.out.println("-------------listpage-----------");
if(session.getAttribute("User")!=null){
	User user = (User)session.getAttribute("User");
	String city = user.getAddress().getCity();
	ArrayList<Offer> offerList=null;
//}
//if(session.getAttribute("offerList")!=null){
	System.out.println("generateList");
	OfferImp offerimp = new OfferImp();
	
     //ArrayList<Offer> offerList = (ArrayList<Offer>)session.getAttribute("offerList");
    if(user.getType()==1){
    	offerList = offerimp.getOfferByUser(user);
    }else if(user.getType()==0){
    	offerList = offerimp.getOfferDetailByCity(city);
    }
    if(!offerList.isEmpty()){
	%>
	<ul>
	<%
		for(Offer offer : offerList){
	%>
					<li id="li_<%=offer.getId()%>">
						<input type="file" name="file" size="50" accept="image/*"/>
						<div id="showdiv_<%=offer.getId()%>">
							<h4><%=offer.getTitle()%>(<%=offer.getServiceType()%>)$<%=offer.getPayAmount()%></h4>
							<p>
								<%=offer.getDescription()%>
							</p>
	<%
			if(user.getType()==1){	
	%>
							
							<a id="edit_<%=offer.getId()%>" class="readmore">Edit &gt;&gt;</a><a id="delete_<%=offer.getId()%>" class="readmore" >Delete &gt;&gt;</a>
	<%
			}
	%>
						</div>
					</li>
	<%
		}
	%>
	</ul>
	<%
	}else{
%>
	You currently do not have any request. Click on "Request Service" tab to make a request!
<%
	}
}
%>