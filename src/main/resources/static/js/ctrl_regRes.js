angular.module('webApp', ['ngRoute']).controller('systemManager_regRes_Controller', function($scope, $http, $location, $rootScope){
    	$scope.regRes_btnClick = function(){
    		var res = {
    			name:$scope.regRes_name,
    			type:$scope.regRes_type
    		}
    		$http.post('/systemManager/addRestaurant', res).then(
				function(response){
					console.log("Restaurant " + res.name + " registered.");
					$location.path('/systemManager/home');
				},
				function(response){
					console.log("Restaurant registration faild.")
				}
			)
    	};
    });