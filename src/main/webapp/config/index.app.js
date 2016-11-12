
    'use strict';

    var africaSaveurs = angular.module("africaSaveurs", [ "ngRoute" ]);
    
    /*var socle_app = angular.module('socle_app', [
      'ngRoute',
      'ngTable',
      'm-loader',
      'ui.bootstrap',
      'ui.select',
      'myModal',
      'environment',
      'aDisabled',
      'ngFileUpload',
      'file-model',
      'daterangepicker',
      'simplePagination',
      'angular-repeat-n'
    ])
    
    .run(['ngTableDefaults', function(ngTableDefaults) {
    	ngTableDefaults.params.page = 1;
    	ngTableDefaults.params.count = 10;
    	ngTableDefaults.settings.counts = [];
    	ngTableDefaults.settings.paginationMaxBlocks = 2;
    	ngTableDefaults.settings.paginationMinBlocks = 2;
    }]);*/
    
    /**
     * Configuration de httpProvider
     */
    
    /*socle_app.config(function ($provide, $httpProvider) {
    	 // Add the interceptor to the $httpProvider.
    	$httpProvider.interceptors.push('socleHttpProvider');
    });
    
    socle_app.config(function(envServiceProvider) {
    	// set the domains and variables for each environment
		envServiceProvider.config(
            {
                domains: {
                    development: ['http://localhost:8080', 'localhost:8080', '127.0.0.1:8080'],
                    development_b: ['http://localhost:8081', 'localhost:8081', '127.0.0.1:8081'],
                    recette: ['http://tremas.rec-avancial.com:8080', 'tremas.rec-avancial.com:8080'],
                    recette_client: [],
                    recette_client_secu: [],
				    production: ['http://tremas.si-avancial.com:8080', 'tremas.si-avancial.com:8080'],
					production_secu: []
				    // anotherStage: []
                },
                
                vars: {
                    development: {
                        apiUrl: 'http://localhost:8080/tremas/',
                        appWebService : 'http://localhost:8080/tremas/webService/app',
                        socleWebService : 'http://localhost:8080/tremas/webService/socle',
                        loginUrl: 'http://localhost:8080/tremas/login'
                        // antoherCustomVar: ''
                    },
                    development_b: {
                        apiUrl: 'http://localhost:8081/tremas/',
                        appWebService : 'http://localhost:8081/tremas/webService/app',
                        socleWebService : 'http://localhost:8081/tremas/webService/socle',
                        loginUrl: 'http://localhost:8081/tremas/login'
                        // antoherCustomVar: ''
                    },
                    recette: {
                        apiUrl: 'http://tremas.rec-avancial.com:8080/tremas/',
                        appWebService : 'http://tremas.rec-avancial.com:8080/tremas/webService/app',
                        socleWebService : 'http://tremas.rec-avancial.com:8080/tremas/webService/socle',
                        loginUrl: 'http://tremas.rec-avancial.com:8080/tremas/login'
                        // antoherCustomVar: ''
                    },
                    recette_client: {
                        apiUrl: ''
                        // antoherCustomVar: ''
                    },
                    recette_client_secu: {
                        apiUrl: ''
                        // antoherCustomVar: ''
                    },
                    production: {
                        apiUrl: 'http://tremas.si-avancial.com:8080/tremas/',
                        appWebService : 'http://tremas.si-avancial.com:8080/tremas/webService/app',
                        socleWebService : 'http://tremas.si-avancial.com:8080/tremas/webService/socle',
                        loginUrl: 'http://tremas.si-avancial.com:8080/tremas/login'
                        // antoherCustomVar: ''
                    },
					production_secu: {
                        apiUrl: ''
                        // antoherCustomVar: ''
                    },
                }
            }
       );
		// run the environment check, so the comprobation is made
		// before controllers and services are built
		envServiceProvider.check(); 
    });*/
