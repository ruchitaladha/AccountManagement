package com.ladha.demo.service;

import java.util.List;

import com.ladha.demo.model.Account;

public interface AccountService {

	Account findById(long id);

	Account findByName(String name);

	void saveAccount(Account account);

	void updateAccount(Account account);

	void deleteAccountById(long id);

	List<Account> findAllAccounts();

	void deleteAllAccounts();

	public boolean isAccountExist(Account account);
}
