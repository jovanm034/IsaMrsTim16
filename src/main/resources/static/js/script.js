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
            
            .when('/user/register', {
            	templateUrl : 'pages/registerUser.html'
                
            })
            
            .when('/user/friends', {
            	templateUrl : 'pages/userFriends.html',
                controller  : 'UserFriendsController'
                
            })

            .when('/systemManager/registerRestaurant', {
                templateUrl : 'pages/registerRestaurant.html',
                controller  : 'systemManager_regRes_Controller'
            })
            
            .when('/systemManager/registerRestaurantManager', {
                templateUrl : 'pages/registerRestaurantManager.html',
                controller  : 'systemManager_regResMan_Controller'
            })
            
            .when('/systemManager/registerSystemManager', {
                templateUrl : 'pages/registerSystemManager.html',
                controller  : 'systemManager_regSysMan_Controller'
            })
            
            .when('/provider/home', {
            	templateUrl : 'pages/providerHome.html',
            	controller	: 'provider_Controller'
            })
            
            .when('/provider/firstLogin', {
            	templateUrl : 'pages/firstLogin.html',
            	controller	: 'provider_firstLogin_Controller'
            })
            
            .when('/provider/update', { //TODO
            	templateUrl : 'pages/providerUpdate.html',
            	controller	: 'provider_update_Controller'
            })
            
            .when('/provider/offers', { //TODO
            	templateUrl : 'pages/providerOffers.html',
            	controller	: 'provider_offers_Controller'
            })
            
            .when('/provider/orders', { //TODO
            	templateUrl : 'pages/providerOrders.html',
            	controller	: 'provider_orders_Controller'
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
    			$http.get('api/providers').then(
    				function(response){
    					var providers = response.data.content;
    					var found = 0;
    					for(i = 0; i<providers.length; i++){
							if(providers[i].email == $scope.loginEmail){
								if(providers[i].password == $scope.loginPassword){
									found = 1;
									$rootScope.loggedUser = providers[i];
								}
							}
						}
						if(found == 1){
							if($rootScope.loggedUser.logedBefore == 0){
								$location.path('/provider/firstLogin');
							}else{
								$location.path('/provider/home');
							}
						}
    				},
    				function(response){}
    			)
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
    		}  		
    		
    	};
    	
    });
    
    webApp.controller('systemManager_regSysMan_Controller', function($scope, $http, $location, $rootScope){
    	$scope.regSysMan_btnClick = function(){
    		$http.get('api/systemManagers').then(
				function(response){
					var users = response.data.content;
					var found = 0;
					for(i = 0; i<users.length; i++){
						if(users[i].email == $scope.regSysMan_email){
							found = 1;
						}
					}
					if(found == 0){
						var sysm = {
			    			firstname:$scope.regSysMan_firstname,
			    			lastname:$scope.regSysMan_lastname,
			    			email:$scope.regSysMan_email,
			    			password:$scope.regSysMan_password,
			    			master:0
			    		}
						$http.post('/api/systemManagers', sysm).then(
							function(response){
								$location.path('/systemManager/home');
							},
							function(response){
								
							}
						)
					}
				},
				function(response){
					//Nikada nije neuspesno
				}
			)
    	};
    });
    
    webApp.controller('systemManager_regRes_Controller', function($scope, $http, $location, $rootScope){
    	$scope.regRes_btnClick = function(){
    		$http.get('api/restaurants').then(
					function(response){
						var ress = response.data.content;
						var found = 0;
						for(i = 0; i<ress.length; i++){
							if(ress[i].name == $scope.regRes_name){
								found = 1;
							}
						}
						if(found == 0){
							var res = {
				    			name:$scope.regRes_name,
				    			type:$scope.regRes_type
				    		}
							$http.post('/api/restaurants', res).then(
								function(response){
									$location.path('/systemManager/home');
								},
								function(response){
									
								}
							)
						}
					},
					function(response){
						//Nikada nije neuspesno
					}
			
			)
    	};
    });
    
    webApp.controller('systemManager_regResMan_Controller', function($scope, $http, $location, $rootScope){
    	$http.get('api/restaurants').then(
				function(response){
					$scope.regResMan = {
						availableOptions: response.data.content,
						selectedOption: {}
					}
					$scope.regResMan.selectedOption = $scope.regResMan.availableOptions[0];
				},
				function(response){
					//Nikada nije neuspesno
				}
		
		)
    	$scope.regResMan_btnClick = function(){
    		console.log($scope.regResMan.selectedOption);
    		console.log($scope.regResMan.selectedOption.name);
    		if($scope.regResMan.selectedOption.name != undefined){
    			$http.get('api/restaurantManagers').then(
    					function(response){
    						var users = response.data.content;
    						var found = 0;
    						for(i = 0; i<users.length; i++){
    							if(users[i].email == $scope.regResMan_email){
    								found = 1;
    							}
    						}
    						if(found == 0){
    							var rest = {
									id:$scope.regResMan.selectedOption.id,
									name:$scope.regResMan.selectedOption.name,
									type:$scope.regResMan.selectedOption.type
    							}
    							var resm = {
									firstname:$scope.regResMan_firstname,
					    			lastname:$scope.regResMan_lastname,
					    			email:$scope.regResMan_email,
					    			password:$scope.regResMan_password,
					    			restaurant:rest
    				    		}
    							$http.post('/api/restaurantManagers', resm).then(
    								function(response){
    									$location.path('/systemManager/home');
    								},
    								function(response){
    									
    								}
    							)
    						}
    					},
    					function(response){
    						//Nikada nije neuspesno
    					}
    			
    			)
    		}
    		
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
    
    webApp.controller('provider_Controller', function($scope, $http, $location, $rootScope) {
    	$scope.onBtn1 = function(){
    		$location.path('/provider/update');
    	}
    	$scope.onBtn2 = function(){
    		$location.path('/provider/offers');
    	}
    	$scope.onBtn3 = function(){
    		$location.path('/provider/orders');
    	}
    	$scope.onBtn4 = function(){
    		$location.path('/');
    	}
    	
    });
    
    webApp.controller('provider_firstLogin_Controller', function($scope, $http, $location, $rootScope) {
    	$scope.onButtonClick = function(){
    		$rootScope.loggedUser.logedBefore = 1;
        	$rootScope.loggedUser.password = $scope.flpass;
        	$http.put('/api/providers/'+$rootScope.loggedUser.id, $rootScope.loggedUser).then(
        		function(response){
        			$rootScope.loggedUser = response.data;
        			console.log($rootScope.loggedUser);
        			$location.path('/provider/home');
        		},
        		function(response){}
        	)
    	}
    	
    	
    });
    
    webApp.controller('provider_update_Controller', function($scope, $http, $location, $rootScope) {
    	$scope.onBtn1 = function(){
    		$rootScope.loggedUser.firstname = $scope.updatedFName;
    		$rootScope.loggedUser.lastname = $scope.updatedLName;
        	$rootScope.loggedUser.password = $scope.updatedPassword;
        	$http.put('/api/providers/'+$rootScope.loggedUser.id, $rootScope.loggedUser).then(
        		function(response){
        			$rootScope.loggedUser = response.data;
        			$location.path('/provider/home');
        		},
        		function(response){}
        	)
    	}
    	
    	
    });
    
    webApp.controller('userController', function($scope, $http, $location, $rootScope) {
    	
    	
    });
    
    webApp.controller("UserFriendsController", [ '$scope', '$http', function($scope, $http){
    	
    	$http.get('/api/users').success(function(data) {
            $scope.users = data.content; // get data from json
            
              angular.forEach($scope.users, function(item){
                   console.log(item.firstName);
                  
                
               })
        });
    	
        $scope.removeUser = function(user){
            var userToRemove = $scope.addedUsers.indexOf(user);
             $scope.addedUsers.splice(userToRemove,1);

        }
        
        $scope.addUser = function(user){
        	$scope.addedUsers = [];
        	console.log("Usao u add User");
        	$scope.addedUsers.push(user);
        }

        

    }]);
    
    webApp.controller('RegisterController', function($scope, $http, $location, $rootScope) {
    	
    	$scope.onRegisterClick = function(){
    		var user = {
    			firstName:$scope.ime,
    			lastName:$scope.prezime,
    			email:$scope.email,
    			password:$scope.password,
    			passwordConfirm:$scope.password2
    		}
    		console.log(user);
    		$http.post('/api/users', user).then(
    			function(response){
    				//Uspesno
    				
    				console.log("User " + response.data.firstName + " " + response.data.lastName + " registered!");
    				$location.path('/');
    			},
    			function(response){
    				//Neuspesno
    				console.log("REGISTRATION FAILED");
    			}
    		)
    	};
    });
   
    

    
    