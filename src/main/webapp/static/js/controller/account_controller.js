'use strict';
angular
		.module('myApp')
		.controller(
				'AccountController',
				[
						'$scope',
						'AccountService',
						function($scope, AccountService) {
							var self = this;
							self.account = {
								id : null,
								firstName : '',
								lastName : '',
								email : '',
								accountNo : '',
								institutionName : '',
								type : ''
							};
							self.accounts = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							fetchAllAccounts();
							function fetchAllAccounts() {
								AccountService
										.fetchAllAccounts()
										.then(
												function(d) {
													self.accounts = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching accounts');
												});
							}

							function createAccount(account) {
								AccountService
										.createAccount(account)
										.then(
												fetchAllAccounts,
												function(errResponse) {
													console
															.error('Error while creating account');
												});
							}
							
							 function updateAccount(account, id){
								 AccountService.updateAccount(account, id)
							            .then(
							            		fetchAllAccounts,
							            function(errResponse){
							                console.error('Error while updating account');
							            }
							        );
							    }
							function deleteAccount(id) {
								AccountService
										.deleteAccount(id)
										.then(
												fetchAllAccounts,
												function(errResponse) {
													console
															.error('Error while creating account');
												});
							}

							function submit() {
								if (self.account.id === null) {
									console.log('Saving New Account',
											self.account);
									createAccount(self.account);
								}else{
									updateAccount(self.account, self.account.id);
								}
							}

							function edit(id) {
								console.log('id to be edited', id);
								for (var i = 0; i < self.accounts.length; i++) {
									if (self.accounts[i].id === id) {
										self.account = angular
												.copy(self.accounts[i]);
										break;
									}
								}
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.account.id === id) {// clean form if
																// the user to
																// be deleted is
																// shown there.
									reset();
								}
								deleteAccount(id);
							}

							function reset() {
								self.account = {
									id : null,
									firstName : '',
									lastName : '',
									email : '',
									accountNo : '',
									institutionName : '',
									type : ''
								};

								$scope.myForm.$setPristine(); // reset Form
							}
						} ]);