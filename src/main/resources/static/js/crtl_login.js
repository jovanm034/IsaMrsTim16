angular.module('webApp', ['ngRoute']).controller('loginController', function($scope, $http, $location, $rootScope) {
	$scope.onLoginClick = function(){
		//Guest
		if($scope.loginRoll == "1") {
			
		}
		//Waiter
		if($scope.loginRoll == "2"){
			
		}
		//Cook
		if($scope.loginRoll == "3"){
			
		}
		//Bartender
		if($scope.loginRoll == "4"){
			
		}
		//Provider
		if($scope.loginRoll == "5"){
			
		}
		//Restaurant manager
		if($scope.loginRoll == "6"){
			
		}
		//System manager
		if($scope.loginRoll == "7"){
			var user = {
    			firstname:"",
    			lastname:"",
    			email:$scope.loginEmail,
    			password:$scope.loginPassword,
    			master:0
        	}
			$http.post('/systemManager/login', user).then(
				function(response){
					//Uspesno
					$rootScope.loggedUser = response.data;
					console.log("System manager " + response.data.firstname + " " + response.data.lastname + " logged in!");
					$location.path('/systemManager/home');
				},
				function(response){
					//Neuspesno
					
					console.log("LOGIN FAILD");
				}
			)
		}
		//User
		if($scope.loginRoll == "8"){
			var user = {
	    			firstname:"",
	    			lastname:"",
	    			email:$scope.loginEmail,
	    			password:$scope.loginPassword
	        	}
				$http.post('/user/login', user).then(
					function(response){
						//Uspesno
						$rootScope.loggedUser = response.data;
						console.log("User " + response.data.firstname + " " + response.data.lastname + " logged in!");
						$location.path('/user/home');
					},
					function(response){
						//Neuspesno
						
						console.log("LOGIN FAILED");
					}
				)
		}
		
		
		
		
	};
	$scope.onRegisterClick = function(){
		var user = {
			firstName:$scope.firstName,
			lastName:$scope.lastName,
			email:$scope.registerEmail,
			password:$scope.password,
			passwordConfirm:$scope.passwordConfirm
		}
		console.log(user);
		$http.post('/user/register', user).then(
			function(response){
				//Uspesno
				
				console.log("User " + response.data.firstName + " " + response.data.lastName + " registered!");
				$location.path('/user/home');
			},
			function(response){
				//Neuspesno
				console.log("REGISTRATION FAILED");
			}
		)
	};
});