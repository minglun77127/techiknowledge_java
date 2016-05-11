$(function() {
    $( "#background" ).on( "submit","#registerform", 
    function(event) {
    	alert($("input[name='type']:checked").val());
    	event.preventDefault();
    	if($("#password1").val()==$("#password2").val()){
		   $.post(CONTEXT_ROOT+"/customer.html",{
		    	password:$( "#password1" ).val(),
		    	firstName:$( "#firstname" ).val(),
		    	lastName:$( "#lastname" ).val(),
		    	email:$( "#email" ).val(),
		    	phone:$( "#phone" ).val(),
		    	gender:$("input[name='gender']:checked").val(),
		    	address:$( "#address" ).val(),
		    	country:$( "#country" ).val(),
		    	province:$( "#province" ).val(),
		    	city:$( "#city" ).val(),
		    	postalCode:$( "#postalcode" ).val(),
		    	type:$("input[name='type']:checked").val(),
		    	action:"REGISTER"}
		   )
		   .done(function(res){
			   //$("#registerform").trigger("reset");
			   if(res.message==null){
				   alert("Account has been created, an activation link has been sent to your email.");
				   $(location).attr("href",CONTEXT_ROOT+"/index.jsp");
			   }else{
				   alert(res.message);
			   }
		   })
		   .fail(function(res){
			   alert("We are sorry but something went wrong");
		   });
    	}else{
    		alert("Password does not match. Please re-enter password");
    	}
	});

    $("#div_country").on("change","#country",function(){
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
});