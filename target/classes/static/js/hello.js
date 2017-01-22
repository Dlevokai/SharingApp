var app = angular.module('hello', [ "ngRoute" ]);

app.controller('home', function($scope) {

	$scope.salutation = {
		id : 'yyy',
		content : 'good bye!'
	}
	$scope.greeting = {
		id : 'xxx',
		content : 'hard coded!'
	}
});

app.controller('httpTest', function($scope, $http) {
	$http.get('http://rest-service.guides.spring.io/greeting').then(
			function(response) {
				$scope.greeting = response.data;
			});
});

app.controller('JavaHttpTest', function($scope, $http) {
	$http.get('./angularJsCall').then(function(response) {
		console.log(response.data);
		$scope.greeting = response.data;
	});
});

app.controller('H2DataTest', function($scope, $http) {
	$http.get('./getH2Data').then(function(response) {
		console.log(response.data);
		$scope.product = response.data;
	});
});

app.controller('JavaHttpGetBal', function($scope, $http) {
	$http.get('./getBankData').then(function(response) {
		console.log(response.data);
		$scope.bankData = response.data;
	});
});

app.controller('BoardCtrl', function($scope, $http) {
	$http.get("http://www.w3schools.com/angular/customers.php").then(
			function(response) {
				$scope.names = response.data.records;
			});
});

app.config(function($routeProvider) {
	$routeProvider.when("/graph", {
		templateUrl : "/graph.html"
	}).when("/", {
		templateUrl : "/home.html"
	}).when("/leaderboard", {
		templateUrl : "/leaderboard.html"
	});
});
