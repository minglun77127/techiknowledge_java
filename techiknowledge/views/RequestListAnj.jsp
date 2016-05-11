<%@ page import="java.util.ArrayList" %>
<%@ page import="com.techiknowledge.dao.*" %>

<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="../js/angular.js"></script>

<div ng-app="technicianlist" >
	
		<div ng-controller="ListController as list">
			<div ng-repeat="technician in list.technicians">
				<h1>{{technician.name}}</h1>	
				<h2>{{technician.pricePerHr | currency}}</h2>
				<p>{{technician.background}}</p>
				<button ng-show="!technician.approved">Approve</button>
				
				<div ng-init="tab = 1" ng-controller="PanelController as panel">
					<ul class="nav nav-pills">
						<li>
							<a href ng-click="panel.selectTab(1)">Self-Introduction</a></li>
						<li>
							<a href ng-click="panel.selectTab(2)">Request Completed</a></li>
						<li>
							<a href ng-click="panel.selectTab(3)">Review</a></li>
					</ul>
					<blockquote ng-show="panel.isSelected(1)">
						<p>{{technician.introduction}}</p>
					</blockquote>
					<blockquote ng-show="panel.isSelected(2)" ng-repeat="request in technician.reqComplete">
						<p>{{request.title}}</p>
					</blockquote>
					<blockquote ng-show="panel.isSelected(3)" ng-repeat="review in technician.reviews">
						<h2>Stars: {{review.stars}}</h2>
						<p>{{review.comment}}</p>
						
						<form name="reviewForm" ng-controller="ReviewController as reviewCtrl"
												ng-submit="reviewForm.$valid && reviewCtrl.addReview(technician)" novalidate>
						    <blockquote>
						    	<h2>Stars: {{reviewCtrl.review.stars}}</h2>
								<p>{{reviewCtrl.review.comment}}</p>
						    </blockquote>
							<select ng-model="reviewCtrl.review.stars" required>
								<option value="1">1 star</option>
								<option value="2">2 stars</option>
							</select>
							<textarea ng-model="reviewCtrl.review.comment" required></textarea>
							<input type="submit" value="Submit"/>
						</form>
					</blockquote>
				</div>		
			</div>					
		</div>
</div>

