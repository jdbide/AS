/*
 * Service s
 */
'use strict';

africaSaveurs.service('dtoService', ['$http','jsonFactory', '$q', function($http,jsonFactory ,$q) {
	
	var reponse= 
	{
		status : null,
		message : null,
		data : null
	};
	
	self = this;	

	self.initReponse = function () {
    	reponse.status=null;
    	reponse.message=null;
    	reponse.data=null;
    }
	
	self.getUserDto = function (){
		var deffered  = $q.defer();
		var promissJsonFactory = jsonFactory.getJson("dto/getUserDto");
        promissJsonFactory
            .success(function (data, status, headers, config) {
            	//loadingService.hide();
            	//reponse = datas;
            	reponse.status = data.status;
            	reponse.message = data.message;
            	reponse.data = data.data;
                deffered.resolve();
            })
            .error(function (datas, status, headers, config) {
            	//loadingService.hide();
                deffered.reject();
        });
        
        return deffered.promise;    
	}
	
	self.getStoreDto = function (){
		var deffered  = $q.defer();
		var promissJsonFactory = jsonFactory.getJson("dto/getStoreDto");
        promissJsonFactory
            .success(function (data, status, headers, config) {
            	//loadingService.hide();
            	//reponse = datas;
            	reponse.status = data.status;
            	reponse.message = data.message;
            	reponse.data = data.data;
                deffered.resolve();
            })
            .error(function (datas, status, headers, config) {
            	//loadingService.hide();
                deffered.reject();
        });
        
        return deffered.promise;    
	}

	
	self.getReponse = function () {
    	return reponse;
    }
	
	return self;
}]);