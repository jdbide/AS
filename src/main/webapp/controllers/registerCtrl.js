'use strict';

africaSaveurs.controller('registerCtrl',["registerService", function($scope,registerService){
	
	$scope.nom = null;
	$scope.prenom = null;
	$scope.email = null;
	//$scope.nom = null;
	//$scope.nom = null;
	
	
	$scope.register = function(){
		
		registerService.register($scope.nom,$scope.prenom,$scope.email);
	}
	
	function constructor () {
		//alert("construct");
		//$scope.register();

	}
	constructor();
}]);