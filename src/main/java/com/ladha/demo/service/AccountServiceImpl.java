package com.ladha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ladha.demo.dao.AccountDao;
import com.ladha.demo.model.Account;

@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	/*
	 * private static List<Account> accounts; private static final AtomicLong
	 * counter = new AtomicLong(); static { accounts = populateDummyAccounts(); }
	 */

	public List<Account> findAllAccounts() {
		return this.accountDao.findAllAccounts();
	}

	public Account findById(long id) {
		return this.accountDao.findById(id);
	}

	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveAccount(Account account) {
		this.accountDao.saveAccount(account);
	}

	public void updateAccount(Account account) {
		this.accountDao.updateAccount(account);
	}

	public void deleteAccountById(long id) {
		this.accountDao.deleteAccountById(id);

	}

	public void deleteAllAccounts() {
		// TODO Auto-generated method stub

	}

	public boolean isAccountExist(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * private static List<Account> populateDummyAccounts() { List<Account> accounts
	 * = new ArrayList<Account>(); accounts.add( new
	 * Account(counter.incrementAndGet(), "Sam", "NY", "sam@abc.com", "23274723",
	 * "ICICI BAnk", "HUF")); accounts.add(new Account(counter.incrementAndGet(),
	 * "Tomy", "ALBAMA", "tomy@abc.com", "23274723", "ICICI BAnk", "HUF"));
	 * accounts.add(new Account(counter.incrementAndGet(), "Kelly", "NEBRASKA",
	 * "kelly@abc.com", "23274723", "ICICI BAnk", "HUF")); return accounts; }
	 */

}
