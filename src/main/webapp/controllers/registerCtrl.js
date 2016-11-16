'use strict';

/*
 * africaSaveurs.controller('registerCtrl',['registerService',
 * function($scope,registerService){
 * 
 * $scope.nom = null; $scope.prenom = null; $scope.email = null; //$scope.nom =
 * null; //$scope.nom = null;
 * 
 * 
 * $scope.register = function(){ alert("ok");
 * registerService.register($scope.nom,$scope.prenom,$scope.email); }
 * 
 * $scope.test = function(){ alert("test");
 * //registerService.register($scope.nom,$scope.prenom,$scope.email); }
 * 
 * function constructor () { alert("construct register"); //$scope.register(); }
 * constructor(); }]);
 */

africaSaveurs.controller('registerCtrl', [
		"$scope",
		"registerService","dtoService",
		function($scope, registerService,dtoService) {

			$scope.userDto = null;
			$scope.datas = null;
			$scope.nom = null;
			$scope.prenom = null;
			$scope.email = null;
			// $scope.nom = null;
			// $scope.nom = null;

			$scope.register = function() {
				registerService.initReponse();
				//put values in object
				$scope.userDto.nom = $scope.nom;
				$scope.userDto.prenom = $scope.prenom;
				$scope.userDto.mail = $scope.email;
				/*$scope.userDto.ville = $scope.nom;
				$scope.userDto.pays = $scope.nom;
				$scope.userDto.adresse = $scope.nom;
				$scope.userDto.mdp = $scope.nom;
				$scope.userDto.mobile = $scope.nom;
				$scope.userDto.date_de_naissance = $scope.nom;*/
				
					
				
				registerService.register($scope.userDto).then(function() {
					var reponse = registerService.getReponse();
					if (reponse.status) {
						$scope.datas = reponse.data
					} else {
						alert("Erreur " + reponse.message);
					}

				}, function() {
					alert("Erreur serveur!!");
				}

				);
			}

			$scope.test = function() {
				alert("test");
				// registerService.register($scope.nom,$scope.prenom,$scope.email);
			}

			function constructor() {
				dtoService.initReponse();
				dtoService.getUserDto().then(function() {
					var reponse = dtoService.getReponse();
					if (reponse.status) {
						$scope.userDto = reponse.data;
					} else {
						alert("Erreur " + reponse.message);
					}

				}, function() {
					alert("Erreur serveur!!");
				}

				);
			}

			constructor();
		} ]);