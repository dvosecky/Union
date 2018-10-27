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
	public List<Event> selectAllEvents(){
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
	public List<Event> selectEventsByName(String name){
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
	
	public Event selectEventById(int id) {
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
	public Integer insertEvent(Event event) {
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
	
	//Delete statement, which returns number of entries deleted/removed
	
	public boolean deleteEventById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			t = s.beginTransaction();
			Event e = (Event) s.load(Event.class, 1);
			s.delete(e);
			t.commit();
			result = true;
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

	public boolean approveEvent(int id) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			t = s.beginTransaction();
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("id", id));
			Event e = (Event) c.uniqueResult();
			e.setAcceptFlag(1);
			t.commit();
			result = true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
}
