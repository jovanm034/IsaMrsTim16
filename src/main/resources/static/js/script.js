// script.js

    // create the module and name it scotchApp
    var webApp = angular.module('webApp', ['ngRoute']);

 // configure our routes
    webApp.config(function($routeProvider) {
        $routeProvider

            .when('/', {
                templateUrl : 'pages/login.html',
                controller  : 'loginController'
            })

            .when('/systemManager/home', {
                templateUrl : 'pages/systemManagerHome.html',
                controller  : 'systemManagerController'
            })
            
            .when('/user/home', {
            	templateUrl : 'pages/userHome.html',
                controller  : 'userController'
                
            })

            .when('/systemManager/registerRestaurant', {
                templateUrl : 'pages/registerRestaurant.html',
                controller  : 'systemManager_regRes_Controller'
            })
            
            .when('/systemManager/registerRestaurantManager', {
                templateUrl : 'pages/registerRestaurantManager.html',
                controller  : 'systemManagerController'
            })
            
            .when('/systemManager/registerSystemManager', {
                templateUrl : 'pages/registerSystemManager.html',
                controller  : 'systemManager_regSysMan_Controller'
            })
            .otherwise({
            	redirectTo:'/'
            });
    });

    // create the controller and inject Angular's $scope
    
    webApp.controller('loginController', function($scope, $http, $location, $rootScope) {
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
    			$http.get('api/systemManagers').then(
    					function(response){
    						var users = response.data.content;
    						var found = 0;
    						for(i = 0; i<users.length; i++){
    							if(users[i].email == $scope.loginEmail){
    								if(users[i].password == $scope.loginPassword){
    									found = 1;
    									$rootScope.loggedUser = users[i];
    								}
    							}
    						}
    						if(found == 1){
    							$location.path('/systemManager/home');
    						}
    					},
    					function(response){
    						//Nikada nije neuspesno
    					}
    			
    			)
    			/*var user = {
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
    			)*/
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
    
    webApp.controller('systemManager_regSysMan_Controller', function($scope, $http, $location, $rootScope){
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
    
    webApp.controller('systemManager_regRes_Controller', function($scope, $http, $location, $rootScope){
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
    
    webApp.controller('systemManagerController', function($scope, $http, $location, $rootScope) {
    	//Samo predefinisani menadzer sistema moze da registruje druge menadzere sistema
    	if($rootScope.loggedUser.master == 0){
    		$scope.regSysMBtn = 1;
    	};

    	$scope.onRegisterRestaurantClick = function(){
    		$location.path('/systemManager/registerRestaurant');
    	};
    	
    	$scope.onRegisterRestaurantManagerClick = function(){
    		$location.path('/systemManager/registerRestaurantManager');
    	};
    	
    	$scope.onRegisterSystemManagerClick = function(){
    		$location.path('/systemManager/registerSystemManager');
    	};
    	
    	$scope.onLogoutClick = function(){
    		console.log($rootScope.loggedUser.firstname);
    		$location.path('/');
    	};
    });
    
    webApp.controller('userController', function($scope, $http, $location, $rootScope) {
    	
    	
    });
   
    

    
    