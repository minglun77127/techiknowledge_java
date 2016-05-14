<form name="reviewForm" ng-submit="reviewForm.$valid && reviewCtrl.addReview(technician)" novalidate>
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