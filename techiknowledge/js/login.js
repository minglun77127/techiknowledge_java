$(function() {
    var dialog, form,
      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
      name = $( "#name" ),
      email = $( "#email" ),
      password = $( "#password" ),
      allFields = $( [] ).add( name ).add( email ).add( password ),
      tips = $( ".validateTips" );
    	
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
      setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );
        updateTips( "Length of " + n + " must be between " +
          min + " and " + max + "." );
        return false;
      } else {
        return true;
      }
    }
 
    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
        o.addClass( "ui-state-error" );
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }
 
    function addUser() {
    	
      var valid = true;
      allFields.removeClass( "ui-state-error" );
      
      //valid = valid && checkLength( name, "username", 3, 16 );
      
      valid = valid && checkLength( email, "email", 6, 80 );
      
      valid = valid && checkLength( password, "password", 1, 16 );
      
      //valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
      valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
      //valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
      
      if ( valid ) {
        $.post("customer.html",{email:email.val(),password:password.val(),action:"LOGIN"})
        .done(function(res){
        	
        	//var obj = $.parseJSON(res);
        	if(res.message==null){
        		$(location).attr("href",CONTEXT_ROOT+"/views/Offer.jsp");
        	}else{
        		alert(res.message);
        	}
        	
        	//var obj = $.parseJSON(res);
        	//alert(res);
        	//$("#header").load("include/menu.jsp");
        	//$.post("offer.html",{action:"LOADOFFER"},function(){
        		//$(location).attr("href",CONTEXT_ROOT+"/views/Offer.jsp");
        	//})
        	//alert(res);
        })
        .fail(function(res){
        	alert(res);
        });
        dialog.dialog( "close" );
       // $("#menu").reload();
      }
      return valid;
    }
 
    dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 400,
      width: 400,
      modal: true,
      buttons: {
        "Login": addUser,
        Cancel: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        form[ 0 ].reset();
        allFields.removeClass( "ui-state-error" );
      }
    });
 
    form = dialog.find( "form" ).on( "submit", function( event ) {
      event.preventDefault();
      addUser();
    });
    
    $( "#header" ).on( "click","#login-user", function() {
      dialog.dialog( "open" );
    });
    
    $( "#header" ).on( "click","#signup-user", function() {
    	if($("#signupform").length<=0){
	    	$("#background").hide("slideUp", function(){
	    		$("#background").load(CONTEXT_ROOT+"/views/SignUpForm.jsp",function(){
	        		$(this).show("slideDown");   		
	        	});
	    	});
    	}
      });
    
    $( "#header" ).on( "click","#logout-user", function() {
	    $.post(CONTEXT_ROOT+"/customer.html",{action:"LOGOUT"},function(){
	    	$(location).attr("href",CONTEXT_ROOT+"/index.jsp");
	    });
	});
    
    $( "#usermenu" ).on( "click","#btn_showoffer", function() {
    	toggleActiveButton("btn_showoffer");
    	if($("#offerform").length<=0){
	    	$("#background").hide("slide", function(){
	    		$("#background").load(CONTEXT_ROOT+"/views/OfferForm.jsp",function(){
	        		$(this).show("slide");
	        	});
	    	});
    	}
 	});
    
    $( "#usermenu" ).on( "click","#btn_showprofile", function() {
    	toggleActiveButton("btn_showprofile");
    	if($("#profileform").length<=0){	
	    	$("#background").hide("slide", function(){
	    		$("#background").load(CONTEXT_ROOT+"/views/ProfileForm.jsp",function(){
	        		$(this).show("slide");
	        	});
	    	});
    	}
 	});
    
    $( "#usermenu" ).on( "click","#btn_showrequest", function() {
    	toggleActiveButton("btn_showrequest");
    	$("#background").hide("slideUp", function(){
    		$(this).empty();
    	});
 	});
    
    $( "#usermenu" ).on( "click","#btn_showbid", function() {
    	toggleActiveButton("btn_showbid");
    	$("#background").hide("slideUp", function(){
    		$(this).empty();
    	});
 	});
    
    $( "#usermenu" ).on( "click","#btn_showmap", function() {
    	toggleActiveButton("btn_showmap");
	    	if($("#detailmap").length<=0){
	    	$("#background").show("silde", function(){
	    		$("#background").load(CONTEXT_ROOT+"/views/DetailMap.jsp",function(){
	        		$(this).show("fade");
	        	});
	    	});
    	}
 	});
    
    function toggleActiveButton(btnID){
    	
    	$("#usermenu a").each(function(){
    		
    		if($(this).attr("id")==btnID){
    			$(this).addClass("active");
    		}else{
    			$(this).removeClass("active");
    		}
    	});
    }
    /*-----OfferForm Controls------*/
    $( "#body" ).on( "submit","#offerform", function(event) {
    	event.preventDefault();
 	   $.post(CONTEXT_ROOT+"/offer.html",{
 	    	title:$( "#title" ).val(),
 	    	pay:$( "#pay" ).val(),
 	    	servType:$( "#servType" ).val(),
 	    	description:$("#description").val(),
 	    	action:"CREATEOFFER"},
 	    	function(res){
 	    		//alert(res);
 	    }).done(function(res){
 	    	alert("Request has been created");
 	    	$("#offerform").trigger("reset");
 	    	//$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
     		$("#section").load("OfferList.jsp");
     		//});
 		});
 	});
    /*-----ProfileForm Controls------*/
    /*$( "#body" ).on( "submit","#profileform", function(event) {
    	event.preventDefault();
 	   $.post(CONTEXT_ROOT+"/customer.html",{
 	    	title:$( "#title" ).val(),
 	    	pay:$( "#pay" ).val(),
 	    	servType:$( "#servType" ).val(),
 	    	description:$("#description").val(),
 	    	action:"UPDATEUSER"},
 	    	function(res){
 	    		//alert(res);
 	    }).done(function(res){
 	    	alert("Request has been created");
 	    	$("#offerform").trigger("reset");
 	    	//$.post(CONTEXT_ROOT+"/offer.html",{action:"LOADOFFER"},function(){
     		$("#section").load("OfferList.jsp");
     		//});
 		});
 	});*/
    /*-----DetailMap Controls------*/
	$( "#background" ).on( "click","[id^=btnview_]", function() {
		var offerId = $(this).attr("id").split("_")[1];
		
		$("#li_"+offerId).show();
 	});
	$( "#background" ).on( "click","[id^=btnbid_]", function() {
		if(confirm("Are you sure you want to bid on this request?")){
			var offerId = $(this).attr("id").split("_")[1];
			$.post(CONTEXT_ROOT+"/offer.html",{
		    	offerId:offerId,
		    	pay:Math.round(($("#pay_"+offerId).text()*9)/10),
		    	action:"BIDOFFER"}
			).done(function(res){
		    	$("#section").load(CONTEXT_ROOT+"/views/OfferList.jsp",function(){
		    		$("#background").load(CONTEXT_ROOT+"/views/DetailMap.jsp");
		    	});
			});
		}else{
			alert("discard bid");
		}
 	});	
	
	/*-----OfferList Controls------*/
	$( "#section" ).on( "mouseenter","[id^=abidder_]", function(event) {
		//alert(event.clientX+","+event.clientY);
		var bidderId = $(this).attr("id");
		
		$(this).parent().prev().css({"top":event.clientY+"px","left":event.clientX+"px"});
		//if($(this).parent().prev().length==0){
			$(this).parent().prev().show();
		//}
			//$(this).parent().prev().prev().css({"top":event.clientY+"px","left":event.clientX+"px"});
			//$(this).parent().prev().prev().show("fold");
 	});
	$( "#section" ).on( "mouseout","[id^=abidder_]", function() {
		//var bidderId = $(this).attr("id");
		//if($(this).parent().prev().length!=0){
			$(this).parent().prev().hide();
		//}
		//$(this).children().hide();
 	});
	/*$( "#section" ).on( "mouseover","[id^=divtip_]", function() {
		var bidderId = $(this).attr("id");
		//alert("block");
		$(this).show();
 	});
	$( "#section" ).on( "mouseout","[id^=divtip_]", function() {
		var bidderId = $(this).attr("id");
		$(this).hide("fade");
 	});*/
 });
