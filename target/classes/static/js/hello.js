angular.module('hello', [])
  .controller('home', function($scope) {
	  
	$scope.salutation = {id: 'yyy', content: 'good bye!' } 
    $scope.greeting = {id: 'xxx', content: 'Hello World!'}
})