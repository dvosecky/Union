package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;


import com.revature.beans.Account;
import com.revature.beans.Department;
import com.revature.util.HibernateUtil;

public class AccountDaoImpl {

	public void deleteAccount(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.delete(session.get(Account.class, id));
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
	}
	
	public void deleteAccountByUsername( String username) {
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		Account account=null;
		Transaction tx=null;
		
		try {
			criteria=session.createCriteria(Account.class);
			account = (Account) criteria.add(Restrictions.eq("username",username)).uniqueResult();
	
			tx=session.beginTransaction();
			session.delete(username,account);
		
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	
	}
	
	public Account selectAccountByDepartment( Department department ) {
		Account account=null;
		
		return account;
	}
	
	public Integer insertAccount(Account account) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		Integer id=null;
	
		try {

			tx = session.beginTransaction();
			id=(Integer)session.save(account);
			tx.commit();
		}catch(HibernateException e) {

			e.printStackTrace();
		}finally {
			session.close();
			
		}
		return id;
		
	}
	
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


	public Account getAccountByUsername( String username) {
		Account account=null;
		Query query=null;
		Session session=HibernateUtil.getSession();
		String hql;
		
		try {
			hql="From Account where uname=:username";
			query=session.createQuery(hql);
			query.setParameter("username", username);
			account= (Account)query.uniqueResult();
			
		}catch( HibernateException e) {
			e.printStackTrace();
			System.out.println("______________________");
		}finally {
			session.close();
		}
		return account;
		
	}
}
