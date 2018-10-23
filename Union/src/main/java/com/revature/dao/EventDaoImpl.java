package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Event;
import com.revature.util.HibernateUtil;

public class EventDaoImpl {
	
	public List<Event> getAllEvents(){
		List<Event> events = null;
		Session s = HibernateUtil.getSession();
		
		try {
			Criteria c = s.createCriteria(Event.class);
			c.addOrder(Order.desc("edate"));
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
			c.addOrder(Order.desc("edate"));
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
}
