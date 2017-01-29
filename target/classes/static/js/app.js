var app = angular.module('app', [ "ngRoute" ]);

app.controller('JavaHttpGetBal', function($scope, $http) {
	$http.get('./getBankData').then(function(response) {
		console.log(response.data);
		$scope.bankData = response.data;
	});
});

app.controller('PlayerBoardCtrl', function($scope, $http) {
	$http.get('./getPlayerList').then(function(response) {
		console.log(response.data);
		$scope.players = response.data.playerList;
	});
});

app.controller('BoardCtrl', function($scope, $http) {
	$http.get("http://www.w3schools.com/angular/customers.php").then(
			function(response) {
			    console.log(response.data);
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
	}).when("/login", {
      		templateUrl : "/login.html"
    });
});
