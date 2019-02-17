'use strict';
 
angular.module('myApp').factory('AccountService', ['$http', '$q', function($http, $q){
	var ACCOUNT_SERVICE_URI = 'http://localhost:8080/AccountManagement/account/';
	var factory = {
			fetchAllAccounts: fetchAllAccounts,
	        createAccount: createAccount,
	        updateAccount:updateAccount,
	        deleteAccount:deleteAccount
	    };
	return factory;
	
	function fetchAllAccounts(){
		console.log(ACCOUNT_SERVICE_URI);
		var deferred = $q.defer();
		$http.get(ACCOUNT_SERVICE_URI)
        .then(
        function (response) {
            deferred.resolve(response.data);
        },
        function(errResponse){
            console.error('Error while fetching Accounts');
            deferred.reject(errResponse);
        });
		return deferred.promise;
	}
	
	function createAccount(account) {
        var deferred = $q.defer();
        $http.post(ACCOUNT_SERVICE_URI, account)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Account');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
	function updateAccount(account, id) {
        var deferred = $q.defer();
        $http.put(ACCOUNT_SERVICE_URI+id, account)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Account');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
	function deleteAccount(id) {
        var deferred = $q.defer();
        $http.delete(ACCOUNT_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Account');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
}]);