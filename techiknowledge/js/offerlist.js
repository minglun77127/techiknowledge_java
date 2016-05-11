$(function() {
	//var lat;
	//var lng;
	navigator.geolocation.getCurrentPosition(
		function(position){
			var lat=position.coords.latitude;
			var lng=position.coords.longitude;
			$("[id^=mapdiv_]").each(function(){
				var pcode = $(this).attr("id").split("_")[2];
				$(this).googleMap();
				$(this).addWay({
			    	start: pcode, // Postal address for the start marker (obligatory)
					end: [lat,lng], // Postal Address or GPS coordinates for the end marker (obligatory)
					route : "way", // Block's ID for the route display (optional)
					langage : "english"// language of the route detail (optional)
				});
			});
		},
		function(error){
			$("[id^=mapdiv_]").each(function(){
				var pcode = $(this).attr("id").split("_")[2];
				$(this).googleMap({
					zoom: 30,
					type: "ROADMAP"
				});
				$(this).addMarker({
				      address: pcode, // GPS coords
				      //url: '#mapdiv_'+pcode, // Link to redirect onclick (optional)
				      id: 'marker_'+pcode // Unique ID for your marker
				});
			});
		}
	);
	
	/*if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
	function showPosition(position) {
	    var lat=position.coords.latitude;
	    var lng=position.coords.longitude;
	    $("[id^=mapdiv_]").each(function(){
			var pcode = $(this).attr("id").substring(7);
			$(this).googleMap();
			$(this).addWay({
		    	start: pcode, // Postal address for the start marker (obligatory)
				end: [lat,lng], // Postal Address or GPS coordinates for the end marker (obligatory)
				route : "way", // Block's ID for the route display (optional)
				langage : "english"// language of the route detail (optional)
			});
		});
	}
	function showError(error) {
	    switch(error.code) {
	        case error.PERMISSION_DENIED:
	            alert("User denied the request for Geolocation.");
	            break;
	        case error.POSITION_UNAVAILABLE:
	            alert("Location information is unavailable.");
	            break;
	        case error.TIMEOUT:
	            alert("The request to get user location timed out.");
	            break;
	        case error.UNKNOWN_ERROR:
	            alert("An unknown error occurred.");
	            break;
	    }
	    $("[id^=mapdiv_]").each(function(){
			var pcode = $(this).attr("id").substring(7);
			$(this).googleMap();
			$(this).addMarker({
			      address: pcode, // GPS coords
			      //url: '#mapdiv_'+pcode, // Link to redirect onclick (optional)
			      id: 'marker_'+pcode // Unique ID for your marker
			});
		});
	} */
	
	
	$( "[id^=delete_]" ).each(function(index, value){
		var offerId = $(this).attr("id").substring(7);
		$(this).click(function(){
			$.post(CONTEXT_ROOT+"/offer.html",{offerId:offerId, action:"DELETEOFFER"},function(){
				$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
					$("#li_"+offerId).hide('slide',{direction:'right'});
	    		});
			});
		});
	});
	/*$( "[id^=edit_]" ).each(function(index, value){
		var offerId = $(this).attr("id").substring(5);
		$(this).click(function(){
			$.post(CONTEXT_ROOT+"/offer.html",{offerId:offerId, action:"DELETEOFFER"},function(){
				$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
					$("#section").load(CONTEXT_ROOT+"/views/OfferList.jsp");
	    		});
			});
		});
	});*/
	
	$( "[id^=file_]" ).on("change", function(){
		var offerId = $(this).attr("id").substring(5);
		
		var reader = new FileReader();
		
		reader.onload=function(e){
			$.post(CONTEXT_ROOT+"/offer.html",{offerId:offerId,img:reader.result,action:"UPLOAD"})
			.done(function(res){
				$("#img_"+offerId).attr("src",reader.result);
			});
		}
		reader.readAsDataURL(document.getElementById($(this).attr("id")).files[0]);
	});
	
	$("[id^=accept_]").on("click", function(){
		
		var offerId = $(this).attr("id").substring(7);
		
		if(confirm("Are you sure you want to accept the bid?")){
			$.post(CONTEXT_ROOT+"/offer.html",{offerId:offerId,action:"ACCEPT"})
			.done(function(res){
				alert("Bid accepted");
				$("#section").load("OfferList.jsp");
			});
		}
	});
});