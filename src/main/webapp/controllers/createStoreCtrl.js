'use strict';

africaSaveurs.controller('createStoreCtrl', [ "$scope", "createStoreService", "dtoService", "paysService", 'Upload', '$timeout', function($scope, createAccountService, dtoService, paysService, Upload, $timeout) {

	$scope.selected = 'restaurantSelected';
	$scope.userDto = null;
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

	$scope.selectedPaysChange = function() {
		// alert($scope.selectedPays);
		$scope.villes = $scope.selectedPays.listeVilles;
	}

	$scope.register = function() {
		// createAccountService.initReponse();
		// put values in object
		$scope.userDto.nom = $scope.nom;
		$scope.userDto.prenom = $scope.prenom;
		$scope.userDto.mail = $scope.email;
		/*
		 * $scope.userDto.ville = $scope.nom; $scope.userDto.pays = $scope.nom;
		 * $scope.userDto.adresse = $scope.nom; $scope.userDto.mdp = $scope.nom;
		 * $scope.userDto.mobile = $scope.nom; $scope.userDto.date_de_naissance =
		 * $scope.nom;
		 */

		/*
		 * createAccountService.register($scope.userDto).then(function() { var
		 * reponse = registerService.getReponse(); if (reponse.status) {
		 * $scope.datas = reponse.data } else { alert("Erreur " +
		 * reponse.message); } }, function() { alert("Erreur serveur!!"); } );
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
				// $scope.selectedPays = $scope.pays[0];
			} else {
				alert("Erreur " + reponse.message);
			}

		}, function() {
			alert("Erreur serveur!!");
		});

	}

	constructor();

	$scope.uploadFiles = function(files, errFiles) {
		$scope.files = files;
		$scope.errFiles = errFiles;
		angular.forEach(files, function(file) {
			Upload.rename(file, '1-R-Main' + "." + getFileExtension(file.name))
			file.upload = Upload.upload({
				// url :
				// 'https://angular-file-upload-cors-srv.appspot.com/upload',
				url : 'http://localhost:8080/africasaveurs/webservices/file/upload',
				data : {
					file : file
				}
			});

			file.upload.then(function(response) {
				$timeout(function() {
					file.result = response.data;
				});
			}, function(response) {
				if (response.status > 0)
					$scope.errorMsg = response.status + ': ' + response.data;
			}, function(evt) {
				file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
			});
		});
	}
	function getFileExtension(filename) {
		return filename.split('.') // Split the string on every period
		.slice(-1)[0]; // Get the last item from the split
	}

} ]);