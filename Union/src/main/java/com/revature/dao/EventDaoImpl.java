package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Event;
import com.revature.util.HibernateUtil;

public class EventDaoImpl {
	public static final Logger logger = Logger.getLogger(EventDaoImpl.class);
	
	//Returns a list of events 
	@SuppressWarnings("unchecked")
	public List<Event> selectAllEvents(){
		logger.info("In Select All Events");
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//returns events in desc order using criteria
			logger.debug("A list of event is return in desc order using criteria");
			Criteria c = s.createCriteria(Event.class);
			c.addOrder(Order.desc("time"));
			events = (List<Event>) c.list();
		}
		catch (Exception e){
			logger.error("Exception found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return events;
	}
	
	//A list of events is return using event name
	@SuppressWarnings("unchecked")
	public List<Event> selectEventsByName(String name){
		logger.info("In Select Events By Name");
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//A list of events is return
			logger.debug("A list of events is return using criteria");
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("name", name));
			c.addOrder(Order.desc("time"));
			events = (List<Event>) c.list();
		}
		catch (Exception e){
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return events;
	}
	
	//A event is return using the event id
	public Event selectEventById(int id) {
		logger.info("In Select Eveny By Id");
		Event e = null;
		Session s = HibernateUtil.getSession();
		
		try {
			//a list of event is return
			logger.debug("Using criteria, a list of events using event id is returned");
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("id", id));
			e = (Event) c.uniqueResult();
		}
		catch (Exception exc) {
			logger.error("Exception is found in transaction");
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
		logger.info("In Insert Event");	
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
			
		try {
			//Event is save in database
			logger.debug("Using session save and event is stored in database");
			tx = s.beginTransaction();
			id = (Integer)s.save(event);
			tx.commit();
		}
			catch (Exception e) {
				logger.error("Exception is found in transaction");
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return id;
	}
	
	//Delete statement, which returns number of entries deleted/removed
	public boolean deleteEventById(int id) {
		logger.info("Delete Eveny by ID");
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			//event is deleted
			logger.debug("Usesing session delete, a event is deleted from db");
			t = s.beginTransaction();
			Event e = (Event) s.load(Event.class, 1);
			s.delete(e);
			t.commit();
			result = true;
		}
		catch (Exception e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}

	//A department head approved of new event
	public boolean approveEvent(int id) {
		logger.info("In Approve Event");
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		boolean result = false;
		
		try {
			//Event is approved
			logger.debug("Using criteria, event is updating to approved");
			t = s.beginTransaction();
			Criteria c = s.createCriteria(Event.class);
			c.add(Restrictions.like("id", id));
			Event e = (Event) c.uniqueResult();
			e.setAcceptFlag(1);
			t.commit();
			result = true;
		}
		catch (Exception exc) {
			logger.error("Exception is found in transaction");
			exc.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		
		return result;
	}
}
