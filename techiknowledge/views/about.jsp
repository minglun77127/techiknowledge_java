<%@ include file="../include/header.jsp" %>
<body>
	<div id="header">
<%@ include file="../include/menu.jsp" %>
	<div id="dialog-form" title="Login" style="width:100%">
					  <p class="validateTips">All form fields are required.</p>
					  <form id="login" method="post" action="customer.html">
					    <fieldset>
					      <label for="email">Email</label>
					      <!-- <input type="text" name="email" id="email" value="johnwayne@gmail.com" class="text ui-widget-content ui-corner-all">
					      <label for="password">Password</label>
					      <input type="password" name="password" id="password" value="johnWayne" class="text ui-widget-content ui-corner-all"> -->
					      
					      <input type="text" name="email" id="email" value="minglun77127@gmail.com" class="text ui-widget-content ui-corner-all">
					      <label for="password">Password</label>
					      <input type="password" name="password" id="password" value="ming" class="text ui-widget-content ui-corner-all">
					 
					      <!-- Allow form submission with keyboard without duplicating the dialog button -->
					      
					      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
					    </fieldset>
					  </form>
	</div>
	</div>
	<div id="body">
		<div id="background">
			<div>
				<div style="width:100%">
					<div style="padding:100px 0 100px 0;width:100%">
						<h1>&#8220;About Us&#8221;.</h1>
						<p>
							Welcome to Techiknowledge, where our goal is to give you the best and fastest troubleshooting and repairing services for all of your technical needs. Our technicians will make a visit directly to your residence in order to assist with your technical issues. The requisitioner enjoys the benefits of staying home while their technical issues are fixed. In addition, our service allows various technicians to bid for the opportunity to provide you with their quality service and expertise.We would love to hear your feedback as we are constantly upgrading our system to improve our services.
						</p>
					</div>
				</div>
			</div>
		</div>
		<div id="section">
			
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>