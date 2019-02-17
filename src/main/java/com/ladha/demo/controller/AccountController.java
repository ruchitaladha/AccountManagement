package com.ladha.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ladha.demo.model.Account;
import com.ladha.demo.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	//-------------------Retrieve All Accounts--------------------------------------------------------
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listAllAccounts() {
    	System.out.println("Listing all the  accounts");
        List<Account> accounts = accountService.findAllAccounts();
        if(accounts.isEmpty()){
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
    
    	accountService.saveAccount(account);
    	System.out.println("Creating new accounts");
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/account/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	
    }
    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account) {
    	 
        Account currentAccount = accountService.findById(id);
        currentAccount.setFirstName(account.getFirstName());
        currentAccount.setLastName(account.getLastName());
        currentAccount.setEmail(account.getEmail());
        currentAccount.setInstitutionName(account.getInstitutionName());
        currentAccount.setAccountNo(account.getAccountNo());
        currentAccount.setType(account.getType());
    	accountService.updateAccount(currentAccount);
    	System.out.println("Updating account with id "+id);
        return new ResponseEntity<Account>(currentAccount, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id){  
    	Account account  =  accountService.findById(id);
    	 if (account == null) {
    		 System.out.println("Unable to delete. Account with id " + id + " not found");
    		 return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    	 }
    	 accountService.deleteAccountById(id);
    	 System.out.println("Deleting account with id "+id);
    	return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }
    
 
 
    
}
