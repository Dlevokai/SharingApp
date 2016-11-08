var app = angular.module('hello', []);

    app.controller('home', function($scope) {
	  
	  $scope.salutation = {id: 'yyy', content: 'good bye!' } 
      $scope.greeting = {id: 'xxx', content: 'hard coded!'}
    })
    
    app.controller('httpTest', function($scope, $http) {
	$http.get('http://rest-service.guides.spring.io/greeting').
	    then(function(response) {
	        $scope.greeting = response.data;
	    });
    });
    
    app.controller('JavaHttpTest', function($scope, $http) {
    	$http.get('./angularJsCall').
    	    then(function(response) {
    	        $scope.greeting = response.data;
    	    });
        });