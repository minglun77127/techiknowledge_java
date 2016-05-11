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
	<ul id="divul">
	<%
		for(Offer offer : offerList){
			if(user.getType()==1){
	%>
					<li id="li_<%=offer.getId()%>">
						<input id="file_<%=offer.getId()%>" type="file" name="file" size="50" accept="image/*"/>
						<img id="img_<%=offer.getId()%>" alt="No Picture Uploaded" height="200" width="300" src="<%=offer.getImage()%>" >
						<div id="showdiv_<%=offer.getId()%>">
							<%
				if(offer.getUser()!=null){
				%>
								
								<div id="divtip_<%=offer.getId()%>" class="nametip" style="width:300px;text-align:center">
									<div style="display:table-cell;width:100%;padding:5px;">
								   		 		<img src="<%=request.getContextPath()%>/images/ming.jpg" alt="Smiley face" style="width:300px;">
								   	</div>
								    <div style="display:table;width:100%;text-align:left;">
								    	<div style="display:table-row;width:100%">
								    		
								    		<div style="display:table-cell;width:100%;padding:5px;">Name: <%=offer.getUser().getFirstName()%> <%=offer.getUser().getLastName()%> (<%=(offer.getUser().getGender()==1?"Male":"Female")%>)</div>
								    	</div>
								    	<div style="display:table-row;width:100%">
								    		<div style="display:table-cell;width:100%;padding:5px;">Email: <%=offer.getUser().getEmail()%></div>
								    	</div>
								    	<div style="display:table-row;width:100%">
								    		<div style="display:table-cell;width:100%;padding:5px;">Phone: <%=offer.getUser().getPhone()%></div>
								    	</div>
								    </div>
								</div>
								<%-- <table id="tblbidder_<%=offer.getUser().getId()%>" style="background-color:#d9f2f2;position:fixed;display:none;text-align:left">
									<tr>
										<td><%=offer.getUser().getFirstName()%> <%=offer.getUser().getLastName()%> (<%=(offer.getUser().getGender()==1?"Male":"Female")%>)</td>
									</tr>
									<tr>
										<td><%=offer.getUser().getEmail()%></td>
									</tr>
									<tr>
										<td><%=offer.getUser().getPhone()%></td>
									</tr>
									<tr>
										<td><button>Accept</button></td>
									</tr>
								</table> --%>
				<%
				}
				%>
							<h4><%=offer.getTitle()%>(<%=offer.getServiceType()%>)$<%=offer.getPayAmount()%> <%=(offer.getUser().getFirstName()!=null)?"bid by":""%> <a id="abidder_<%=offer.getId()%>" class="tooltips" href="#"><%=(offer.getUser().getFirstName()!=null)?offer.getUser().getFirstName():""%></a> <%if(Integer.parseInt(offer.getAcceptedBy())==0 && offer.getUser().getFirstName()!=null){%><button id="accept_<%=offer.getId()%>">Accept</button><%}%>
							</h4>							
							<p>
								<%=offer.getDescription()%>
							</p>					
							<%-- <a id="edit_<%=offer.getId()%>" class="readmore">Edit &gt;&gt;</a> --%><a id="delete_<%=offer.getId()%>" class="readmore" >Delete &gt;&gt;</a>
						</div>
					</li>
	<%
			}else if(user.getType()==0){
	%>
					
					<li id="li_<%=offer.getId()%>" >
						<div id="mapdiv_<%=offer.getId()%>_<%=offer.getUser().getAddress().getPostalCode()%>" style="width: 300px; height: 300px;float:left;"></div>
						<div id="showdiv_<%=offer.getId()%>">
							<h3 id="h3_<%=offer.getId()%>"><%=offer.getTitle()%>[<%=offer.getServiceType()%>]$<span id="pay_<%=offer.getId()%>"><%=offer.getPayAmount()%></span></h3>
							<h4 id="h4_<%=offer.getId()%>"><%=offer.getUser().getAddress().getAddressLine()%> <%=offer.getUser().getAddress().getPostalCode()%> [<%=offer.getUser().getFirstName()%> <%=offer.getUser().getLastName()%>]</h4>
							<p id="p_<%=offer.getId()%>">
								<%=offer.getDescription()%>
							</p>					
						</div>
					</li>
	<%
			}
		}
	%>
	</ul>
	<%
	}else{
		if(user.getType()==1){
%>
	You currently do not have any request. Click on "Request Service" tab to make a request!
<%
		}else if(user.getType()==0){
%>
	There are currently no request available to you.
<%			
		}
	}
}
%>