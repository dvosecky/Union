package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
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
	public final static Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<Account> selectAccountsByDep(Department dep){
		List<Account> accounts = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Account.class);
			c.add(Restrictions.like("dep", dep));
			accounts = (List<Account>) c.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return accounts;
		
	}
	
	public void deleteAccountById(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.delete(session.get(Account.class, id));
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}

	}
	
	public Account selectAccountById(Integer id) {
		Account account = null;
		Session session= HibernateUtil.getSession();
		
		try {
		account = (Account) session.get(Account.class, id);
		}catch( HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return account;
		
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
	
	@SuppressWarnings("unchecked")
	public List<Account> selectAllAccount(){
		List<Account> accounts=null;
		Session session = HibernateUtil.getSession();
		//logger.info("Session has begin created");
		try {
		accounts = session.createQuery("FROM Account").list();
	//	logger.info("Accounts have been retrieved");
		}catch(Exception e) {
			e.printStackTrace();
	//	logger.error("Exception was found");
		}finally {
			session.close();
		}
		
		//logger.info("Accounts have returned");
		return accounts;
		
	}
	
	public Integer insertAccount(Account acc){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = session.beginTransaction();
			id = (Integer)session.save(acc);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		
		return id;
	}
	
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

	public Account selectAccountByUsername( String username) {
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
