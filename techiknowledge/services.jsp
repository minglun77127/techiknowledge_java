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
						<h1>&#8220;Our Servcies&#8221;.</h1>
						<p>
							We will make sure to provide fast service and the best prices. Techiknowledge troubleshoots and repairs software and/or hardware issues. Such issues include, but are not limited to the following:
						</p>
							<ul style="padding:0 0 0 0;list-style-type:circle;min-height:0px">
								<li style="height:15px">Mobile</li>
								<li style="height:15px">Computers and laptop repair</li>
								<li style="height:15px">Printers</li>
								<li style="height:15px">Windows and Apple OS</li>
								<li style="height:15px">Hardware and software issues</li>
								<li style="height:15px">Office Suite</li>
								<li style="height:15px">Networking service like internet and wireless networks</li>
								<li style="height:15px">Backup, recovery, and virus/spam protection</li>
							</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="section">
			
		</div>
	</div>
<%@ include file="include/footer.jsp" %>