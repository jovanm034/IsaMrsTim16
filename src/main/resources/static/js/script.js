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
   
    

    
    