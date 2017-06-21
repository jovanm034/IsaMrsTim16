angular.module('webApp', ['ngRoute']).controller('systemManagerController', function($scope, $http, $location, $rootScope) {
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