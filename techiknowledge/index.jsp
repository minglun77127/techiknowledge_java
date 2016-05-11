<%@ include file="include/header.jsp" %>
<body>
	<div id="header">
<%@ include file="include/menu.jsp" %>
	<div id="dialog-form" title="Login" style="width:100%">
					  <p class="validateTips">All form fields are required.</p>
					  <form id="login" method="post" action="customer.html">
					    <fieldset>
					      <label for="email">Email</label>
					      <!-- <input type="text" name="email" id="email" value="johnwayne@gmail.com" class="text ui-widget-content ui-corner-all">
					      <label for="password">Password</label>
					      <input type="password" name="password" id="password" value="johnWayne" class="text ui-widget-content ui-corner-all"> -->
					      
					      <input type="text" name="email" id="email" class="text ui-widget-content ui-corner-all">
					      <label for="password">Password</label>
					      <input type="password" name="password" id="password" class="text ui-widget-content ui-corner-all">
					 
					      <!-- Allow form submission with keyboard without duplicating the dialog button -->
					      
					      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
					    </fieldset>
					  </form>
	</div>
	</div>
	<div id="body">
		<div id="background">
			<div>
				<div>
					<div style="padding:100px 0 100px 0">
						<h1>&#8220;Welcome to our Website&#8221;.</h1>
						<p>
							Having trouble with technical issues and cannot find the right person to fix it for you? Don't worry you have come to the right place. On our website, you can find the right technician in a flash!
						</p>
					</div>
				</div>
			</div>
		</div>
		<div id="section">
			
		</div>
	</div>
<%@ include file="include/footer.jsp" %>