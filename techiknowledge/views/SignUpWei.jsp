<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.techiknowledge.dao.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TechiKnowledge Sign Up</title>

<!--  
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ajaxrequest.js"></script>
<script type="text/javascript">
  
  function callAjax(action, value, target){
	  alert("I am an alert box!");
	  if(encodeURIComponent){
		  
		  alert("----------1-----------------");
		  var req = new AjaxRequest();
		  alert("----------2-----------------");
	      var params = "action=" + action + "&value=" + encodeURIComponent(value) + "&target=" + target;
	      
	      alert("----------3-----------------");
	      req.setMethod("POST");
	      alert("----------4-----------------");
	      req.loadXMLDoc('<%=request.getContextPath()%>/customer.html', params);
	  }
  }
</script> -->
<script type="text/javascript">

    function callAjax(action, email, target){
    	<!-- alert("I am an alert box!"); -->
    	
    	var xhr = new XMLHttpRequest(); 
        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                   var response = this.responseText;
                   alert(response.trim().length);
                   
                   if(response != null || response.trim().length !== 0){
                       document.getElementById('res_account').innerHTML = response;
                   }
            }
        }
        var url = '<%=request.getContextPath()%>/customer.html?action=' + action + '&email=' + email;
        xhr.open('POST', url, true);
        xhr.send(null);
    }
    
</script>

</head>
<body>
    <% /* 
    <jsp:useBean id="User" scope="session" class="com.techiknowledge.dao.User">
        <jsp:setProperty name="user" property="*" />
    </jsp:useBean>
    */ %>
    
    <% User user = (User)session.getAttribute("User"); %>
    <%String message = (String)request.getAttribute("Message"); %> 
    <% if(message != null){ %>
        <h3><%=message %></h3>
    <% } message = null; %>

<% if(user != null){ %>
    <form id="signupform" name="signupform" method="post" action="<%=request.getContextPath()%>/customer.html">
      <br>
      <label for="firstName">First name:</label>
      <input type="text" name="firstName" id="firstName" class="txtfield" tabindex="1" value="<%=user.getFirstName() %>">
      <br>
      <label for="lastName">Last name:</label>
      <input type="text" name="lastName" id="lastName" class="txtfield" tabindex="2" value="<%=user.getLastName() %>">
      <br>
      <input type="radio" name="gender" value="1" checked tabindex="3"> Male
      <input type="radio" name="gender" value="0"> Female
      <input type="radio" name="gender" value="3"> Other
      
      <br>
      <label for="account">Account:</label>
      <input type="text" name="useraccount" id="useraccount" class="txtfield" tabindex="4" value="<%=user.getEmail() %>">
      <br>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" class="txtfield" tabindex="5">
      
      
      <br>
      <label for="phone">Phone:</label>
      <input type="text" name="phone" id="phone" class="txtfield" tabindex="6" value="<%=user.getPhone() %>">
      <br>
      <label for="address">Address:</label>
      <input type="text" name="address" id="address" class="txtfield" tabindex="7" value="<%=user.getAddress().getAddressLine() %>">
      <br>
      <label for="country">Country:</label>
      <select name="country" tabindex="8">
        <option value=""></option>
        <option value="Canada">Canada</option>
        <option value="U.S.A.">U.S.A.</option>
        <option value="Japan">Japan</option>
      </select>
      <br>
      <label for="province">Province:</label>
      <select name="province" tabindex="9">
        <option value=""></option>
        <option value="ON">Ontario</option>
        <option value="QC">Quebec</option>
        <option value="NS">Nova Scotia</option>
        <option value="NB">New Brunswick</option>
        <option value="MB">Manitoba</option>
        <option value="BC">British Columbia</option>
        <option value="PE">Prince Edward Island</option>
        <option value="SK">Saskatchewan</option>
        <option value="AB">Alberta</option>
        <option value="NL">Newfoundland and Labrador</option>
        <option value="NT">Northwest Territories</option>
        <option value="YT">Yukon</option>
        <option value="NU">Nunavut</option>
      </select>
      <br>
      <label for="city">City:</label>
      <input type="text" name="city" id="city" class="txtfield" tabindex="10" value="<%=user.getAddress().getCity() %>">
      <br>
      <label for="postalCode">Postal Code:</label>
      <input type="text" name="postalCode" id="postalCode" class="txtfield" tabindex="11" value="<%=user.getAddress().getPostalCode() %>">
      
      <div class="center">
        <input type="hidden" name="action" value="EDIT">
        <input type="submit" name="Editbtn" id="Editbtn" class="flatbtn-blu hidemodal" value="Edit" tabindex="12">
      </div>
    </form>
<% }else{ %>
    <form id="signupform" name="signupform" method="post" action="<%=request.getContextPath()%>/customer.html">
      <br>
      <label for="firstName">First name:</label>
      <input type="text" name="firstName" id="firstName" class="txtfield" tabindex="1">
      <br>
      <label for="lastName">Last name:</label>
      <input type="text" name="lastName" id="lastName" class="txtfield" tabindex="2">
      <br>
      <input type="radio" name="gender" value="1" checked tabindex="3"> Male
      <input type="radio" name="gender" value="0"> Female
      <input type="radio" name="gender" value="3"> Other
      
      <br>
      <label for="account">Account:</label>
      <input type="text" name="useraccount" id="useraccount" class="txtfield" tabindex="4" onchange="if(this.value != '') callAjax('CHECKEMAIL', this.value, this.id);">
      <div id="res_account"><!--  --></div>
      
      <br>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" class="txtfield" tabindex="5">
      
      <br>
      <label for="phone">Phone:</label>
      <input type="text" name="phone" id="phone" class="txtfield" tabindex="6">
      <br>
      <label for="address">Address:</label>
      <input type="text" name="address" id="address" class="txtfield" tabindex="7">
      <br>
      <label for="country">Country:</label>
      <select name="country" tabindex="8">
        <option value="Canada">Canada</option>
        <option value="U.S.A.">U.S.A.</option>
        <option value="Japan">Japan</option>
      </select>
      <br>
      <label for="province">Province:</label>
      <select name="province" tabindex="9">
        <option value="ON">Ontario</option>
        <option value="QC">Quebec</option>
        <option value="NS">Nova Scotia</option>
        <option value="NB">New Brunswick</option>
        <option value="MB">Manitoba</option>
        <option value="BC">British Columbia</option>
        <option value="PE">Prince Edward Island</option>
        <option value="SK">Saskatchewan</option>
        <option value="AB">Alberta</option>
        <option value="NL">Newfoundland and Labrador</option>
        <option value="NT">Northwest Territories</option>
        <option value="YT">Yukon</option>
        <option value="NU">Nunavut</option>
      </select>
      <br>
      <label for="city">City:</label>
      <input type="text" name="city" id="city" class="txtfield" tabindex="10">
      <br>
      <label for="postalCode">Postal Code:</label>
      <input type="text" name="postalCode" id="postalCode" class="txtfield" tabindex="11">
      
      <div class="center">
        <input type="hidden" name="action" value="REGISTER">
        <input type="submit" name="SignUpbtn" id="SignUpbtn" class="flatbtn-blu hidemodal" value="Sign Up" tabindex="12">
      </div>
    </form>
<%} %>

</body>
</html>