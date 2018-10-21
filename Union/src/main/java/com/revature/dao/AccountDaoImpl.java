package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.beans.Account;
import com.revature.util.HibernateUtil;

public class AccountDaoImpl {

	public Account selectAccountById( Integer id) {
		Account account = null;
		Session session= HibernateUtil.getSession();
		
		try {
		account = (Account) session.get(Account.class, id);
		}catch( HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return account;
	}
	
	
	@SuppressWarnings("unchecked")
	public void criteriaGetAll() {
		Session session = HibernateUtil.getSession();
		List<Account> accounts=null;

		try {
			accounts= session.createCriteria(Account.class).list();

			
		}catch(Exception e) {//atch( HibernateException e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}

		for(Account a : accounts) {
			System.out.println(a);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> selectAllAccount(){
		List<Account> accounts=null;
		Session session = HibernateUtil.getSession();
		
		try {
		accounts = session.createQuery("FROM Account").list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return accounts;
		
	}
}
