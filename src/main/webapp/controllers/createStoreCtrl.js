'use strict';

africaSaveurs.controller('createStoreCtrl', [ "$scope", "createStoreService",
		"dtoService", "paysService",
		function($scope, createAccountService, dtoService, paysService) {

			$scope.storeDto = null;
			$scope.datas = null;
			$scope.nom = null;
			$scope.prenom = null;
			$scope.email = null;

			$scope.selectedPays = null;
			$scope.pays = null;
			$scope.villes = null;
			// $scope.nom = null;
			// $scope.nom = null;

			$scope.register = function() {
				// createAccountService.initReponse();
				// put values in object
				$scope.userDto.nom = $scope.nom;
				$scope.userDto.prenom = $scope.prenom;
				$scope.userDto.mail = $scope.email;
				/*
				 * $scope.userDto.ville = $scope.nom; $scope.userDto.pays =
				 * $scope.nom; $scope.userDto.adresse = $scope.nom;
				 * $scope.userDto.mdp = $scope.nom; $scope.userDto.mobile =
				 * $scope.nom; $scope.userDto.date_de_naissance = $scope.nom;
				 */

				/*
				 * createAccountService.register($scope.userDto).then(function() {
				 * var reponse = registerService.getReponse(); if
				 * (reponse.status) { $scope.datas = reponse.data } else {
				 * alert("Erreur " + reponse.message); } }, function() {
				 * alert("Erreur serveur!!"); } );
				 */
			}

			function constructor() {
				dtoService.initReponse();
				dtoService.getStoreDto().then(function() {
					var reponse = dtoService.getReponse();
					if (reponse.status) {
						$scope.storeDto = reponse.data;
					} else {
						alert("Erreur " + reponse.message);
					}

				}, function() {
					alert("Erreur serveur!!");
				});
				paysService.initReponse();
				paysService.getPays().then(function() {
					var reponse = paysService.getReponse();
					if (reponse.status) {
						$scope.pays = reponse.data;
						$scope.selectedPays = $scope.pays[0];
						$scope.villes = $scope.selectedPays.listeVilles;
						alert($scope.villes);
					} else {
						alert("Erreur " + reponse.message);
					}

				}, function() {
					alert("Erreur serveur!!");
				});
			}

			constructor();
		} ]);