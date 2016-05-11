$(function() {
	if(lat===undefined){
		$("#detailmap").googleMap({
			zoom:15
		});
	}else{
		$("#detailmap").googleMap({
			zoom: 15, 
			coords: [lat, lng],
			type: "ROADMAP"
		});
	
		$("#detailmap").addMarker({
		      coords: [lat, lng], // GPS coords
		      //url: "javascript:alert('test');",//'#mapdiv_'+pcode, // Link to redirect onclick (optional)
		      id: 'marker_current', // Unique ID for your marker
		      title: "My Location", // Title
		      text: "My current Location"
		});
	}
	
	$("[id^=mapdiv_]").each(function(){
		var offerId = $(this).attr("id").split("_")[1];
		var pcode = $(this).attr("id").split("_")[2];
		var tobid = Math.round(($("#pay_"+offerId).text()*9)/10)
		$("#detailmap").addMarker({
		      address: pcode, // GPS coords
		      //url: "javascript:alert('test');",//'#mapdiv_'+pcode, // Link to redirect onclick (optional)
		      id: 'marker_'+pcode, // Unique ID for your marker
		      title: $("#h3_"+offerId).text(), // Title
		      text:  "<p>"+$("#p_"+offerId).text()+"</p>&nbsp&nbsp&nbsp<button id='btnbid_"+offerId+"'>Bid $"+tobid+"</button>"
		});
	});	
	
		  /*var map = new google.maps.Map(document.getElementById('detailmap'), {
		    zoom: 13,
		    center: {lat: 59.325, lng: 18.070}
		  });

		  marker = new google.maps.Marker({
		    map: map,
		    draggable: true,
		    animation: google.maps.Animation.DROP,
		    position: {lat: 59.327, lng: 18.067}
		  });
		  marker.addListener('click', toggleBounce);*/
	/*var map;
    function initMap() {
      map = new google.maps.Map(document.getElementById('detailmap'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
      });
    }*/
	
});



