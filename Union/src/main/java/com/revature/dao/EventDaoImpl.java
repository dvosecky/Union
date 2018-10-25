package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Event;
import com.revature.util.HibernateUtil;

public class EventDaoImpl {
	
	//Primary criteria. Automatically will order by date.
	
	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents(){
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.addOrder(Order.desc("time"));
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
	
	@SuppressWarnings("unchecked")
	public List<Event> getEventsByName(String name){
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("name", name));
			c.addOrder(Order.desc("time"));
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
	
	public Event getEventById(int id) {
		Event e = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("id", id));
			e = (Event) c.uniqueResult();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return e;
	}
	
	//Inserts
	//Adds event if account present
	public Integer addEvent(Event event) {
		if (event == null || event.getLead() == null) {
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
	
	//Add statement
	
	public Integer insertEvent(Event event) {
		Integer result = null;
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			result = (Integer)s.save(event);
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
	
	//Delete statement, which returns number of entries deleted/removed
	
	public void deleteEventById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Event e = (Event) s.load(Event.class, 1);
			s.delete(e);
			t.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
	}
}
