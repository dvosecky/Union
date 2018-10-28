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
	
	//retrieves all accounts under a department 
	@SuppressWarnings("unchecked")
	public List<Account> selectAccountsByDep(Department dep){
		logger.info("In Select Accounts By Dep: "+dep.getDep_id());
		List<Account> accounts = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//uses criteria to retrieve accounts
		logger.debug("Create Criteria for Accounts where Department=Dep");
			Criteria c = s.createCriteria(Account.class);
			c.add(Restrictions.like("dep", dep));
			//returns a list type 
			accounts = (List<Account>) c.list();
		}
		catch (Exception e) {
		logger.error("Exception was found! ");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return accounts;
		
	}
	
	//deletes account by an account id
	public void deleteAccountById(Integer id) {
		logger.info("In Delete Account By Id: "+id);
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			//delete account using session get
		logger.debug("Using transaction to delete account: " + id);
			tx=session.beginTransaction();
			session.delete(session.get(Account.class, id));
			tx.commit();
		}catch(HibernateException e) {
		logger.error("Error found in transaction");
			e.printStackTrace();
		}
		finally {
			session.close();
		}

	}
	
	//retrieve a single account by account id 
	public Account selectAccountById(Integer id) {
		logger.info("In Select Account By Id " + id);
		Account account = null;
		Session session= HibernateUtil.getSession();
		
		try {
		//retrieving accounts by id using session get
		logger.debug("Using Session get to retrieve accounts by id");
		account = (Account) session.get(Account.class, id);
		}catch( HibernateException e) {
		logger.error("Error found in transactin");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return account;
		
	}

	//Account is deleted using a username
	public void deleteAccountByUsername( String username) {
		logger.info("In Delete Account By Username");
		Session session = HibernateUtil.getSession();
		Criteria criteria;
		Account account=null;
		Transaction tx=null;
		
		try {
			//using criteria, account is deleted with session get
		logger.debug("Using criteria to retrieve account then using session delete");
			criteria=session.createCriteria(Account.class);
			account = (Account) criteria.add(Restrictions.eq("username",username)).uniqueResult();
	
			tx=session.beginTransaction();
			session.delete(username,account);
		
			tx.commit();
		}catch(Exception e) {
		logger.error("Error in transaction!");
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//A list of all accounts is returned 
	@SuppressWarnings("unchecked")
	public List<Account> selectAllAccount(){
		logger.info("In Select All Account Method");
		List<Account> accounts=null;
		Session session = HibernateUtil.getSession();

		try {
		//query is used to create a list of accounts
		logger.debug("Query Created To Retrieve Accounts");
		accounts = session.createQuery("FROM Account").list();

		}catch(Exception e) {
			e.printStackTrace();
		logger.error("Exception was found");
		}finally {
			session.close();
		}
		

		return accounts;
		
	}
	
	//An account is created, if successful, method returns account id
	public Integer insertAccount(Account acc){
		logger.info("In Insert Account");
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			//account is created and added to db using session save
		logger.debug("Using session save to add account to database");
			tx = session.beginTransaction();
			id = (Integer)session.save(acc);
			tx.commit();
		} catch (HibernateException e) {
		logger.error("Exception has been found in transaction");
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		
		return id;
	}
	
	//An account a deleted using an account id
	public void deleteAccount(Integer id) {
		logger.info("In Delete Account");
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			//deletes account using session delete
		logger.debug("Deleting account using session delete");
			tx=session.beginTransaction();
			session.delete(session.get(Account.class, id));
			tx.commit();
		}catch(HibernateException e) {
			logger.error("Exception has been found in transaction");
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	//An account is retrieve using username
	public Account selectAccountByUsername( String username) {
		logger.info("In Select Account By Username");
		Account account=null;
		Query query=null;
		Session session=HibernateUtil.getSession();
		String hql;
		
		try {
			//Using HQL retrieve account by username
		logger.debug("Account is return using username and hql");
			hql="From Account where uname=:username";
			query=session.createQuery(hql);
			query.setParameter("username", username);
			account= (Account)query.uniqueResult();
			
		}catch( HibernateException e) {
			e.printStackTrace();
		logger.error("Exception is found in transaction");
		}finally {
			session.close();
		}
		return account;
		
	}

	
	
	
	
}
