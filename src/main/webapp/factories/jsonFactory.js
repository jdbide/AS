'use strict';

/**
 * Appelle un WebService pour récupérer le JSON qu'il envoie
 */
africaSaveurs.factory('jsonFactory',['$http','constantes',function($http/*, Upload*/,constantes) {

	var jsonFactory = [];
	
    jsonFactory.getJson = function (nameWebservice) {
        return $http({
                method: "get",
                url: constantes.WSURL +nameWebservice,
                async: false,
                dataType: 'json',
                crossDomain: false,
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
                    'Accept':'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',            
                }
        });
        
    };
    
    jsonFactory.postJson = function (nameWebservice, data) {
        return $http({
                method: "post",
                url: constantes.WSURL +nameWebservice,
                async: false,
                dataType: 'json',
                crossDomain: false,
                contentType:"application/json; charset=utf-8",
                data: data             
        });
        
    };
    
    jsonFactory.putJson = function (nameWebservice, data) {
        return $http({
                method: "put",
                url: constantes.WSURL +nameWebservice,
                async: false,
                dataType: 'json',
                crossDomain: false,
                contentType:"application/json; charset=utf-8",
                data: data             
        });
        
    };
    
    jsonFactory.deleteJson = function (nameWebservice, data) {
        return $http({
                method: "delete",
                url: constantes.WSURL +nameWebservice,
                async: false,
                dataType: 'json',
                crossDomain: false,
                contentType:"application/json; charset=utf-8",
                data: data             
        });
        
    };
    
    /*jsonFactory.uploadFile = function (nameWebservice, file) {
        return Upload.upload({
              url: constantes.WSURL +nameWebservice,              
              headers: {
                'optional-header': 'header-value'
              },
              data: {file: file}
            });
    }*/

    
    return jsonFactory;
}]);