<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Techiknowledge</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/cupertino/jquery-ui.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
	<script src="<%=request.getContextPath()%>/js/login.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sky-forms.css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<!-- google map apis -->
<script type="text/javascript" src="//www.google.fr/jsapi"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.googlemap.js"></script>
	<script type="text/javascript"> 
		var CONTEXT_ROOT = '<%= request.getContextPath() %>'; 

		var lat;
		var lng;
		navigator.geolocation.getCurrentPosition(
			function(position){
				lat=position.coords.latitude;
				lng=position.coords.longitude;
			},
			function(error){
				
			}
		);
		google.load("maps", "3.4", {
	    	other_params: "sensor=false&language=fr"
	    });
	</script> 
</head>