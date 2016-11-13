/*
 * Service s
 */
'use strict';

africaSaveurs.service('registerService', ['$http', '$q','constantes', function($http,$q,constantes) {
	
	var reponse= 
	{
		status : null,
		message : null,
		data : null
	};
	
	self = this;	

	/*initReponse = function () {
    	reponse.status=null;
    	reponse.message=null;
    	reponse.data=null;
    }*/
	
	self.register = function (nom,prenom,email){
		//loadingService.show();
		//initReponse();
		//var deffered  = $q.defer();
		
        // use $.param jQuery function to serialize data from JSON 
        var data = $.param({
            fName: nom,
            lName: prenom,
            mail: email
        });
    
        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
alert(constantes.WSURL+"user/register");
		$http.post(constantes.WSURL+"user/register", data, config)
        .success(function (datas, status, headers, config) {
        	//loadingService.hide();
        	reponse = datas;
        	//deffered.resolve();
        	return reponse;
        })
        .error(function (data, status, header, config) {
        	//loadingService.hide();
            //deffered.reject();
        	return null;
        });
    
        //return deffered.promise;
      
	}

	
	self.getReponse = function () {
    	return reponse;
    }
	
	return self;
}]);