$(function(){
	
	if($("#country").val()=="Canada"){
		$("#postalCode").attr("pattern","[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]");
		$("#country").html("");
		$("#country").append("<option value='Canada' selected>Canada</option>");
		$("#country").append("<option value='America'>America</option>");
		
		//$("#province").html("");
		$("#province").append("<option value='Alberta'>Alberta</option>" +
				"<option value='British Columbia'>British Columbia</option>" +
				"<option value='Manitoba'>Manitoba</option>" +
				"<option value='New Brunswick'>New Brunswick</option>" +
				"<option value='Newfoundland'>Newfoundland</option>" +
				"<option value='Northwest Territories'>Northwest Territories</option>" +
				"<option value='Nova Scotia'>Nova Scotia</option>" +
				"<option value='Nunavut'>Nunavut</option>" +
				"<option value='Ontario'>Ontario</option>" +
				"<option value='Prince Edward Island'>Prince Edward Island</option>" +
				"<option value='Quebec'>Quebec</option>" +
				"<option value='Saskatchewan'>Saskatchewan</option>" +
				"<option value='Yukon Territory'>Yukon Territory</option>");
		
	}else if($("#country").val()=="America"){
		$("#postalCode").attr("pattern","(\\d{5}([\\-]\\d{4})?)");
		$("#country").html("");
		$("#country").append("<option value='America'>America</option>");
		$("#country").append("<option value='Canada'>Canada</option>");
		
		//$("#province").html("");
		$("#province").html("<option value='Alabama'>Alabama</option>" +
				"<option value='Alaska'>Alaska</option>" +
				"<option value='Arizona'>Arizona</option>" +
				"<option value='Arkansas'>Arkansas</option>" +
				"<option value='California'>California</option>" +
				"<option value='Colorado'>Colorado</option>" +
				"<option value='Connecticut'>Connecticut</option>" +
				"<option value='Delaware'>Delaware</option>" +
				"<option value='District of Columbia'>District of Columbia</option>" +
				"<option value='Florida'>Florida</option>" +
				"<option value='Georgia'>Georgia</option>" +
				"<option value='Hawaii'>Hawaii</option>" +
				"<option value='Idaho'>Idaho</option>" +
				"<option value='Illinois'>Illinois</option>" +
				"<option value='Indiana'>Indiana</option>" +
				"<option value='Iowa'>Iowa</option>" +
				"<option value='Kansas'>Kansas</option>" +
				"<option value='Kentucky'>Kentucky</option>" +
				"<option value='Louisiana'>Louisiana</option>" +
				"<option value='Maine'>Maine</option>" +
				"<option value='Maryland'>Maryland</option>" +
				"<option value='Massachusetts'>Massachusetts</option>");
	}
	
	$("#profileform").on("change","#country",function(){
		$("#postalCode").attr("pattern","[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]");
    	$("#province").html("");
    	if($(this).val()=="Canada"){
    		$("#province").html("<option value='Alberta'>Alberta</option>" +
    				"<option value='British Columbia'>British Columbia</option>" +
    				"<option value='Manitoba'>Manitoba</option>" +
    				"<option value='New Brunswick'>New Brunswick</option>" +
    				"<option value='Newfoundland'>Newfoundland</option>" +
    				"<option value='Northwest Territories'>Northwest Territories</option>" +
    				"<option value='Nova Scotia'>Nova Scotia</option>" +
    				"<option value='Nunavut'>Nunavut</option>" +
    				"<option value='Ontario'>Ontario</option>" +
    				"<option value='Prince Edward Island'>Prince Edward Island</option>" +
    				"<option value='Quebec'>Quebec</option>" +
    				"<option value='Saskatchewan'>Saskatchewan</option>" +
    				"<option value='Yukon Territory'>Yukon Territory</option>");
    		
    	}else if($(this).val()=="America"){
    		$("#postalCode").attr("pattern","(\\d{5}([\\-]\\d{4})?)");
    		$("#province").html("<option value='Alabama'>Alabama</option>" +
    				"<option value='Alaska'>Alaska</option>" +
    				"<option value='Arizona'>Arizona</option>" +
    				"<option value='Arkansas'>Arkansas</option>" +
    				"<option value='California'>California</option>" +
    				"<option value='Colorado'>Colorado</option>" +
    				"<option value='Connecticut'>Connecticut</option>" +
    				"<option value='Delaware'>Delaware</option>" +
    				"<option value='District of Columbia'>District of Columbia</option>" +
    				"<option value='Florida'>Florida</option>" +
    				"<option value='Georgia'>Georgia</option>" +
    				"<option value='Hawaii'>Hawaii</option>" +
    				"<option value='Idaho'>Idaho</option>" +
    				"<option value='Illinois'>Illinois</option>" +
    				"<option value='Indiana'>Indiana</option>" +
    				"<option value='Iowa'>Iowa</option>" +
    				"<option value='Kansas'>Kansas</option>" +
    				"<option value='Kentucky'>Kentucky</option>" +
    				"<option value='Louisiana'>Louisiana</option>" +
    				"<option value='Maine'>Maine</option>" +
    				"<option value='Maryland'>Maryland</option>" +
    				"<option value='Massachusetts'>Massachusetts</option>");
    	}
    });
	
	$( "#profileform" ).on( "submit", function(event) {
    	event.preventDefault();
 	   $.post(CONTEXT_ROOT+"/customer.html",{
 	    	firstName:$( "#firstname" ).val(),
 	    	lastName:$( "#lastname" ).val(),
 	    	address:$( "#addressline" ).val(),
 	    	country:$("#country").val(),
 	    	province:$("#province").val(),
 	    	city:$("#city").val(),
 	    	postalCode:$("#postalCode").val(),
 	    	action:"EDIT"},
 	    	function(res){
 	    		//alert(res);
 	    })
 	    .done(function(res){
 	    	alert("Your Information has been updated successfully");
 	    	$("#section").load("OfferList.jsp");
 	    	//$("#profileform").trigger("reset");
 	    	//$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
     		//$("#section").load("OfferList.jsp");
     		//});
 		})
 		.fail(function(res){
 			alert(res);
 		});
 	});
});