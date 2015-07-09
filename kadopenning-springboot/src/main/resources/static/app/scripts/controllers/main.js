
app.controller('MainCtrl', function ($scope, $http) {
	// example REST - Get
	
	$scope.printHello = function(){
	$http.get("http://localhost:8080/kadopenning/greeting/"+$scope.name)
		.success(function(response) {
			$scope.greeting = response.content;
			});
	}
	
  });
