$(function() {
    $( "#background" ).on( "submit","#offerform", function() {
    	
	   $.post(CONTEXT_ROOT+"/offer.html",{
	    	title:$( "#title" ).val(),
	    	pay:$( "#pay" ).val(),
	    	servType:$( "#servType" ).val(),
	    	description:$("#description").val(),
	    	action:"CREATEOFFER"}
	   ).done(function(res){
	    	alert("Your request has been posted");
	    	$("#offerform").trigger("reset");
	    	//$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
    		$("#section").load("OfferList.jsp");
    		//});
		});
	});
});