package com.ladha.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ladha.demo.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Account findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Account) session.get(Account.class, id);
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(account);
		
	}

	@Override
	public void updateAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(account);
		
	}

	@Override
	public void deleteAccountById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, id);
		if(account != null) {
			session.delete(account);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAllAccounts() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Account").list();
	}

	@Override
	public void deleteAllAccounts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAccountExist(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

}
