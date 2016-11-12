'use strict';

angular.module("africaSaveurs")
.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "main.html",
		controller : "mainCtrl"
	}).when("/register", {
		templateUrl : "register.html",
		controller : "registerCtrl"
	}).when("/login", {
		templateUrl : "login.html",
		controller : "loginCtrl"
	});
});
