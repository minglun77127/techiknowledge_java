(function(){
	
	var app = angular.module("technicianlist",[]);
	
	app.directive("requestTitle", function(){
		return {
			restrict: "E",
			templateUrl: "../views/request.jsp"
		};
	});
	
	app.directive("reviewForm", function(){
		return {
			restrict: "E",
			templateUrl:"../views/review-form.jsp",
			
			controller: function(){
				this.review = {};
				this.addReview = function(technician){
					technician.reviews.push(this.review);
					this.review = {};
				};
			},
			
		    controllerAs: "reviewCtrl"
		};
	});
	
	app.controller("ListController",function(){
		this.technicians = technicians;
	});
	
	app.controller("PanelController",function(){
		this.tab = 1;
		this.selectTab = function(setTab){
			this.tab = setTab;
		};
		this.isSelected = function(checkTab){
			return this.tab === checkTab;
		};
	});
	
	app.controller("ReviewController", function(){
		this.review = {};
		this.addReview = function(technician){
			technician.reviews.push(this.review);
			this.review = {};
		};
	});
	var technicians = [
		{
			name:"Ming Yen",
			pricePerHr:20,
			background:"something",
			approved:true,
			introduction:"I'm godlike",
			reqComplete: [
			    {
			    	title: "fix my shit"
			    },
			    {
			    	title: "fix my shit 2"
			    }
			],
			reviews: [
			    {
			        stars: 5,
			        comment:"this guy is too good",
			    },
			    {
			    	stars: 5,
			        comment:"too good",
			    }
			]
		},
		{
			name:"Wei Wei",
			pricePerHr:20.95,
			background:"something",
			approved:false,
			introduction:"I'm rocky",
			reviews: [
			    {
					 stars: 1,
					 comment:"rocky guy",
			    },
			    {
					 stars: 1,
					 comment:"rocky guy again",
				}
			]
		}
	];
})();
