angular.module('webApp', ['ngRoute']).controller('systemManager_regSysMan_Controller', function($scope, $http, $location, $rootScope){
    	$scope.regSysMan_btnClick = function(){
    		var user = {
    			firstname:$scope.regSysMan_firstname,
    			lastname:$scope.regSysMan_lastname,
    			email:$scope.regSysMan_email,
    			password:$scope.regSysMan_password,
    			master:0
    		}
    		$http.post('/systemManager/addSystemManager', user).then(
				function(response){
					$location.path('/systemManager/home');
				},
				function(response){
					console.log("LOGIN FAILD")
				}
			)
    	};
    });