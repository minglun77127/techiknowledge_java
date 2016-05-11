		<script src="<%=request.getContextPath()%>/js/register.js"></script>
		<div id="signupform" class="div_signup">
			<form id="registerform" class="sky-form">
				<header>Register</header>
				<fieldset>					
		
					<div class="row">
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-user"></i>
								<input id="password1" type="password" placeholder="Password" required="required">
							</label>
						</section>
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-user"></i>
								<input id="password2" type="password" placeholder="Confirm Password" required="required">
							</label>
						</section>
					</div>
				</fieldset>
				<fieldset>					
					<div class="row">
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-user"></i>
								<input id="firstname" type="text" placeholder="First name" required="required">
							</label>
						</section>
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-user"></i>
								<input id="lastname" type="text" placeholder="Last name" required="required">
							</label>
						</section>
					</div>
					
					<div class="row">		
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-user"></i>
								<input id="email" type="text" placeholder="E-Mail" title="Invalid Email Address" required="required" pattern=".+\@.+\..+">
							</label>
						</section>
						<section class="col col-6">
							<label class="input">
								<i class="icon-prepend icon-phone"></i>
								<input id="phone" type="tel" placeholder="Phone" title="Invalid Phone Number" required="required" pattern="[0-9]{10}">
							</label>
						</section>
						<section class="col col-6">
							<div class="inline-group">
							<label class="radio"><input type="radio" name="gender" checked value="1"><i></i>Male</label>
							<label class="radio"><input type="radio" name="gender" value="0"><i></i>Female</label>
							<label class="radio"><input type="radio" name="gender" value="3"><i></i>Others</label>
						</div>
						</section>
					</div>
				</fieldset>
				
				<fieldset>
					<div class="row">
					<section>
						<label for="file" class="input">
							<input id="address" type="tel" placeholder="Address" required="required">
						</label>
					</section>
					</div>
					<div class="row" id="div_country">
						<section class="col col-3">
							<label class="select">
								<select id="country" required>
									<option value="" selected disabled>Country</option>
									<option value="Canada">Canada</option>
									<option value="America">America</option>
								</select>
								<i></i>
							</label>
						</section>
						
						<section class="col col-3">
							<label class="select">
								<select id="province" required>
									<option value="" selected disabled>Province</option>
								</select>
								<i></i>
							</label>
						</section>
						<section class="col col-3">
							<label class="input">
								<input id="city" type="tel" placeholder="City" required="required">
							</label>
						</section>
						
						<section class="col col-3">
							<label class="input">
								<input id="postalcode" type="tel" placeholder="Postal code" required="required">
							</label>
						</section>
					</div>
				</fieldset>
				
				<fieldset>
					<section>
							<label style="font-size:16px">What type of account do you want to register for?</label>
							<div class="inline-group">
							<label class="radio"><input type="radio" name="type" checked value="1"><i></i>Regular User</label>
							<label class="radio"><input type="radio" name="type" value="0"><i></i>Technician</label>
						</div>
						</section>
				</fieldset>
				
				<!--  <fieldset>
					<section>
						<div class="inline-group">
							<label class="radio"><input type="radio" name="radio-inline" checked><i></i>Visa</label>
							<label class="radio"><input type="radio" name="radio-inline"><i></i>MasterCard</label>
							<label class="radio"><input type="radio" name="radio-inline"><i></i>PayPal</label>
						</div>
					</section>					
					
					<section>
						<label class="input">
							<input type="text" placeholder="Name on card">
						</label>
					</section>
					
					<div class="row">
						<section class="col col-10">
							<label class="input">
								<input type="text" placeholder="Card numberd">
							</label>
						</section>
						<section class="col col-2">
							<label class="input">
								<input type="text" maxlength="3" placeholder="CVV2">
							</label>
						</section>
					</div>
					
					<div class="row">
						<label class="label col col-4">Expiration date</label>
						<section class="col col-5">
							<label class="select">
								<select>
									<option value="0" selected disabled>Month</option>
									<option value="1">January</option>
									<option value="1">February</option>
									<option value="3">March</option>
									<option value="4">April</option>
									<option value="5">May</option>
									<option value="6">June</option>
									<option value="7">July</option>
									<option value="8">August</option>
									<option value="9">September</option>
									<option value="10">October</option>
									<option value="11">November</option>
									<option value="12">December</option>
								</select>
								<i></i>
							</label>
						</section>
						<section class="col col-3">
							<label class="input">
								<input type="text" maxlength="4" placeholder="Year">
							</label>
						</section>
					</div>
				</fieldset>
				-->
				<footer id="signupfooter">
					<button id="btn_register" type="submit" class="button">Register</button>
				</footer>
			</form>
			
			
		</div>