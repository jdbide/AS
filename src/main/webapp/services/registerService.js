/*
 * Service s
 */
'use strict';

africaSaveurs.service('registerService', ['$http', '$q','jsonFactory', function($http,$q,jsonFactory) {
	
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
	
	self.register = function (user){
		//initReponse();
		var deffered  = $q.defer();
		var promissJsonFactory = jsonFactory.postJson("user/register/",user);
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
            	alert("ok");
                deffered.reject();
        });
        
        return deffered.promise;
      
	}
	
	self.getUserDto = function (){
		var deffered  = $q.defer();
		var promissJsonFactory = jsonFactory.getJson("user/getUserDto/");
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