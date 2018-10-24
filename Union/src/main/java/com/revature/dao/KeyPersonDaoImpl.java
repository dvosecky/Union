package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Account;
import com.revature.beans.Keyperson;
import com.revature.util.HibernateUtil;

public class KeyPersonDaoImpl {
	
	public List<Keyperson> getAllKeypersons(){
		List<Keyperson> result = null;
		Session s = HibernateUtil.getSession();
		
		try {
			result = (List<Keyperson>) s.createCriteria(Keyperson.class).list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	public List<Keyperson> getAllKeypersonsByAcc(Account acc){
		List<Keyperson> result = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Keyperson.class);
			c.add(Restrictions.like("acc", acc));
			result = (List<Keyperson>) c.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return result;
	}
}
