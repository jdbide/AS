africaSaveurs.controller('mainCtrl',['registerService', function($scope,registerService) {
	$scope.register = function(){
		alert("ok");
		registerService.register($scope.nom,$scope.prenom,$scope.email);
	}
	
	
	function constructor () {
		
		//$scope.register();

	}
	constructor();
}]);