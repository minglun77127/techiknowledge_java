<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Techiknowledge</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		    	<span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span> 
		    </button>
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Techiknowledge</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
	          				<li><a href="#">Page 1-2</a></li>
	          				<li><a href="#">Page 1-3</a></li> 
						</ul>
					</li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-right navbar-nav">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      			<li class="dropdown">
	      				<a class="dropdown-toggle" href="#form_login" data-toggle="collapse"><span class="glyphicon glyphicon-log-in"></span> Login</a>
	      				<div id="form_login" class="dropdown-menu collapse" style="padding: 15px; padding-bottom: 0px;">
				             <div>
								 <input style="margin-bottom: 15px;" type="text" size="30" />
								 <input style="margin-bottom: 15px;" type="password" size="30" />

								 <input class="btn btn-primary" style="padding-bottom:10px; clear: left; width: 100%; height: 32px; font-size: 13px;" type="submit" name="commit" value="Sign In" />
							 </div> 
				        </div>
	      			</li>
				</ul>
			</div>
		</div>
	</nav>
	
</body>
</html>