

app.controller('MainCtrl', function ($scope, $http) {
	// example REST - Get
	
	$http.get("http://www.w3schools.com/angular/customers.php")
    .success(function(response) {$scope.names = response.records;});
	
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.firstName = "John";
    $scope.lastName = "Doe";

  });
//alert('controller MainCtrl loaded')