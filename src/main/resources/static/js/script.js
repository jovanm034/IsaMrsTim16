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
            
            .when('/user/profile',{
            	templateUrl : 'pages/userProfile.html',
            	controller  : 'UserProfileController'
            })
            
            .when('/user/resturants',{
            	templateUrl : 'pages/userAllResturants.html',
            	controller  : 'UserResturants'
            })
            
            .when('/user/reserveRest',{
            	templateUrl : 'pages/reserveRest.html',
            	controller  : 'UserReserveRest'
            })
            
            .when('/user/allReservations',{
            	templateUrl : 'pages/userReservations.html',
            	controller  : 'UserReservations'
            })
            
         
            
            //system manager mapping
            .when('/systemManager/home', {
                templateUrl : 'pages/systemManagerHome.html',
                controller  : 'systemManagerController'
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
            //provider mapping
            .when('/provider/home', {
            	templateUrl : 'pages/providerHome.html',
            	controller	: 'provider_Controller'
            })
            
            .when('/provider/firstLogin', {
            	templateUrl : 'pages/firstLogin.html',
            	controller	: 'provider_firstLogin_Controller'
            })
            
            .when('/provider/update', {
            	templateUrl : 'pages/providerUpdate.html',
            	controller	: 'provider_update_Controller'
            })
            
            .when('/provider/offers', {
            	templateUrl : 'pages/providerOffers.html',
            	controller	: 'provider_offers_Controller'
            })
            
            .when('/provider/orders', {
            	templateUrl : 'pages/providerOrders.html',
            	controller	: 'provider_orders_Controller'
            })
            //restaurant manager mapping
            .when('/restaurantManager/home', {
            	templateUrl : 'pages/restaurantManagerHome.html',
            	controller	: 'restaurantManager_home_Controller'
            })
            // rm -
            // rm -
            // rm - prikupljanje namirnica
            .when('/restaurantManager/registerProvider', {
            	templateUrl : 'pages/registerProvider.html',
            	controller	: 'restaurantManager_registerProvider_Controller'
            })
            
            .when('/restaurantManager/order', {
            	templateUrl : 'pages/restaurantManagerOrder.html',
            	controller	: 'restaurantManager_order_Controller'
            })
            
            .when('/restaurantManager/offers', {
            	templateUrl : 'pages/restaurantManagerOffers.html',
            	controller	: 'restaurantManager_offers_Controller'
            })
            
            .when('/logout', {
			  template: '', 
			  controller: 'LogoutController'
			})
            // rm -
            .otherwise({
            	redirectTo:'/'
            });
    });

    // create the controller and inject Angular's $scope
    
    webApp.controller('loginController', function($scope, $http, $location, $rootScope) {
    	$scope.usable = false;
    	$scope.onLoginClick = function(){
    		//Guest
    		if($scope.loginRoll == "1") {
    			
    			$http.get('/api/users').success(function(data) {
    	            $scope.korisnici = data.content; // get data from json
    	            angular.forEach($scope.korisnici, function(value, key){
    	            	if($scope.loginEmail == value.email){
    	            		$rootScope.loggedUser = value;
    	            		console.log("Uspesno");
    	            		$location.path('/user/home');
    	            	}
    	                
    	             });
    	        })
    			
    			/*
    			var user = {
    	    			firstname:"",
    	    			lastname:"",
    	    			email:$scope.loginEmail,
    	    			password:$scope.loginPassword
    	        	}
    				$http.post('/user/login', user).then(
    					function(response){
    						//Uspesno
    						$scope.usable = true;
    						$rootScope.loggedUser = response.data;
    						console.log("User " + response.data.firstname + " " + response.data.lastname + " logged in!");
    						$location.path('/user/home');
    					},
    					function(response){
    						//Neuspesno
    						
    						console.log("LOGIN FAILED");
    					}
    				)*/
    			
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
    			$http.get('api/restaurantManagers').then(
        				function(response){
        					var managers = response.data.content;
        					var found = 0;
        					for(i = 0; i<managers.length; i++){
    							if(managers[i].email == $scope.loginEmail){
    								if(managers[i].password == $scope.loginPassword){
    									found = 1;
    									$rootScope.loggedUser = managers[i];
    								}
    							}
    						}
    						if(found == 1){
    							$location.path('/restaurantManager/home');
    						}
        				},
        				function(response){}
        			)
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
    
    webApp.controller('restaurantManager_home_Controller', function($scope, $http, $location, $rootScope) {
    	//Profil restorana //TODO
    	//Evidencija zaposlenih //TODO
    	//Prikupljanje namirnica
    	$scope.onBtn9 = function(){
    		$location.path('/restaurantManager/registerProvider');
    	}
    	$scope.onBtn10 = function(){
    		$location.path('/restaurantManager/order');
    	}
    	$scope.onBtn11 = function(){
    		$location.path('/restaurantManager/offers');
    	}
    	//Izvestaj o poslovanju //TODO
    	//Logout - dodati i dugme //TODO
    });
    
    webApp.controller('restaurantManager_registerProvider_Controller', function($scope, $http, $location, $rootScope) {
    	$scope.onBtn1 = function(){
    		$http.get('api/providers').then(
    				function(response){
    					var users = response.data.content;
    					var found = 0;
    					for(i = 0; i<users.length; i++){
    						if(users[i].email == $scope.rmemail){
    							found = 1;
    						}
    					}
    					if(found == 0){
    						var rm = {
    			    			firstname:$scope.rmfname,
    			    			lastname:$scope.rmlname,
    			    			email:$scope.rmemail,
    			    			password:$scope.rmpassword
    			    		}
    						$http.post('/api/providers', rm).then(
    							function(response){
    								$location.path('/restaurantManager/home');
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
    });
    
    webApp.controller('userController', function($scope, $http, $location, $rootScope) {
    	
    	$scope.usable = true;
    	
    });
    
    
    webApp.controller("UserFriendsController", [ '$scope', '$http', '$rootScope', function($scope, $http, $rootScope){
    	
    	$scope.requests = [];
    	
    	$http.get('/api/users').success(function(data) {
            $scope.korisnici = data.content; // get data from json
            angular.forEach($scope.korisnici, function(value, key){
            	if(value.email == $rootScope.loggedUser.email && value.password == $rootScope.loggedUser.password){
            		var index = $scope.korisnici.indexOf(value);
            		$scope.korisnici.splice(index,1);
            	}
            	console.log("Korisnik: ")
            	console.log(value);
                
             });
        })
        
        /*
        
        $scope.users = [
    		{
    			firstName : "Petar",
    			lastName : "Petrovic"
    			
    		},
    		{
    			firstName : "Nikola",
    			lastName : "Nikolic"
    			
    		},
    		{
    			firstName : "Marko",
    			lastName : "Markovic"
    			
    		},
    	];
    	
    	
    	$scope.friends = [];
    	
    	$scope.sendRequest = function(user){
    		
        	
    		 $scope.requests.push({
    		        firstName: user.firstName,
    		        lastName: user.lastName
    		    });
    		 
    		 var index = $scope.users.indexOf(user);
    		 
    		 $scope.users.splice(index,1);
            
        	
        };
        
        $scope.addUser = function(user){
        	
        	$scope.friends.push({
		        firstName: user.firstName,
		        lastName: user.lastName
		    });
        	
        	var index = $scope.users.indexOf(user);
   		 
   		 	$scope.requests.splice(index,1);
            
        	
        };
    	
    	
        $scope.removeUser = function(user){
            var userToRemove = $scope.friends.indexOf(user);
             $scope.friends.splice(userToRemove, 1);
             var userToRemove2 = $rootScope.loggedUser.friends.indexOf(user);
             $rootScope.loggedUser.friends.splice(userToRemove2, 1);
             
             $http.put('/api/editUser/' + $rootScope.loggedUser.id, $rootScope.loggedUser).success(function(data) {
	                console.log("Uspesno modifikovan user");
	         });

        };
        
        $scope.request = function(user){
        	
        	user.requests.push($rootScope.loggedUser);
        	
        	$http.put('/api/editUser/' + user.id, user).success(function(data) {
                console.log("Uspesno modifikovan user");
            });         
        	
        	var index = $scope.users.indexOf(user);
   		 
   		 	$scope.korisnici.splice(index,1);
        	
        };
        
        $scope.addUser = function(user){
        	
        	if(user.email != $rootScope.loggedUser.email){
        	
	        	$rootScope.loggedUser.friends.push(user);
	        	
	        	$http.put('/api/editUser/' + $rootScope.loggedUser.id, $rootScope.loggedUser).success(function(data) {
	                console.log("Uspesno modifikovan user");
	            });
	        	
	        	
	        	$scope.friends = $rootScope.loggedUser.friends;
        	}
            
        	
        };*/
        
        

        

    }]);
    
    webApp.controller('RegisterController', function($scope, $http, $location, $rootScope) {
    	$scope.noMatch = false;
    	
    	$scope.onRegisterClick = function(){
    		if($scope.password != $scope.password2){
    			$scope.noMatch = true;
    		}else{
    			$scope.noMatch = false;
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
    		}
    		
    		
    	};
    });
    
    webApp.controller('UserProfileController', function($scope, $http, $location, $rootScope) {
    	$scope.saveEnabled = false;
    	$scope.showInput = false;
    	$scope.editEnabled = true;
    	
    	$scope.editUser = function(){
    		$scope.saveEnabled = true;
    		$scope.showInput = true;
    		$scope.editEnabled = false;
    	}
    	
    	$scope.saveUser = function(){
    		
    		$scope.saveEnabled = false;
    		$scope.showInput = false;
    		$scope.editEnabled = true;
    		$rootScope.loggedUser.passwordConfirm = $rootScope.loggedUser.password;
    		console.log($rootScope.loggedUser);
    		$http.put('/api/editUser/' + $rootScope.loggedUser.id, $rootScope.loggedUser).success(function(data) {
                console.log("Uspesno modifikovan user");
            });
    	}
    });
    
    webApp.controller('UserResturants', function($scope, $http, $location, $rootScope) {
    	
    	$scope.resturants = [
    		{
    			name : "Restoran1",
    			
    		},
    		{
    			name : "Restoran2",
    			
    		},
    		{
    			name : "Restoran3",
    			
    		},
    	]
    	
    	$http.get('/api/restaurants').success(function(data) {
            //$scope.returants = data.content; // get data from json
            
            console.log("Ucitani svi restorani");
        });
    	
    	$scope.reserveUser = function(resturant){
    		$rootScope.reserveResturant = resturant;
    		$location.path('/user/reserveRest');
    	}
    	
    	$scope.allReservations = function(){
    		$location.path('/user/allReservations');
    	}
    	
    	
    	
    });
    
    webApp.controller('UserReserveRest', function($scope, $http, $location, $rootScope) {
	 	
	
	 
	 $scope.reserveRest = function(){
		 
		 var reservation = {
		 			userEmail:$rootScope.loggedUser.email,
					date:$scope.date,
					time : $scope.sati + ":" + $scope.minuti
		 	}
		 
		 console.log($scope.date);
		 console.log($scope.sati)
		 console.log($scope.minuti)
    	$http.post('/api/reservation', reservation).success(function(data) {
            console.log("Uspesna rezervacija.")
        });
	 }
    	
    	
    });
 
 	webApp.controller('UserReservations', function($scope, $http, $location, $rootScope) {
	 	
	 $http.get('/api/reservations').success(function(data) {
         $scope.reservations = data.content; // get data from json
         
           
     })
    	
    	
    });
 
 	webApp.controller('LogoutController', function($scope, $http, $location, $rootScope, $window) {
	 	
 		$window.localStorage.clear();
 	    $location.path('/');
 	    	
 	    	
 	});
 
 
    
    
    
    
   
    

    
    