package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Event;
import com.revature.util.HibernateUtil;

public class EventDaoImpl {
	
	//Primary criteria. Automatically will order by date.
	
	public List<Event> getAllEvents(){
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.addOrder(Order.desc("etime"));
			events = (List<Event>) c.list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return events;
	}
	
	public List<Event> getEventsByName(String name){
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("ename", name));
			c.addOrder(Order.desc("etime"));
			events = (List<Event>) c.list();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return events;
	}
	
	//Inserts
	//Adds event if account present
	public Integer addEvent(Event event) {
		if (event == null || event.getAccount() == null) {
			return null;
		}
		
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = s.beginTransaction();
			id = (Integer)s.save(event);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return id;
	}
	
	//Delete statement, which returns number of entries deleted/removed
	
	public int deleteEventById(int id) {
		Session s = HibernateUtil.getSession();
		int changed = 0;
		try {
			Query q = s.createQuery("DELETE event WHERE ev_id = ?");
			q.setParameter(1, id);
			changed = q.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return changed;
	}
}
