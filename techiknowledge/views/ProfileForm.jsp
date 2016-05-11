<%@ page import="com.techiknowledge.dao.*" %>
<script src="<%=request.getContextPath()%>/js/profileform.js"></script>
<%if(session.getAttribute("User")!=null){
	User user=(User)session.getAttribute("User");
	String firstname = user.getFirstName();
	Address address = user.getAddress();
%>
<form id="profileform" class="dark-matter">
    <h1>My Profile
    <span>Click edit to edit your profile!</span>
    </h1>
    <label>
        <span>Your First Name :</span>
        <input id="firstname" type="text" name="firstname" placeholder="Your First Name" required="required" value="<%=user.getFirstName() %>"/>
    </label>
    
    <label>
        <span>Your Last Name :</span>
        <input id="lastname" type="text" name="lastname" placeholder="Your Last Name" required="required" value="<%=user.getLastName() %>"/>
    </label>
    <label>
        <span>Your Address:</span>
        <input id="addressline" type="text" name="addressline" placeholder="Valid Address" required="required" value="<%=address.getAddressLine() %>"/>
    </label>
    <label>
        <span>Country:</span>
        <select  style="float:left" id="country">
        		<option><%=address.getCountry() %></option>
		</select>
		Province:
        <select id="province">
        		<option><%=address.getProvince() %></option>
		</select>
		City:
        <input style="width:19%;display:inline" id="city" type="text" name="city" placeholder="City" required="required" value="<%=address.getCity() %>">
    </label>
    <label>
        <span>Postal Code:</span>
        <input id="postalCode" type="text" name="postalCode" placeholder="Valid Postal Code" required="required" value="<%=address.getPostalCode() %>"/>
    </label>
     <label>
        <span>&nbsp;</span> 
        <input type="submit" class="button" value="Update" /> 
    </label>   
</form>
<%
}
%>