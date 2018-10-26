package com.revature.services;

import java.util.List;

import com.revature.beans.Event;
import com.revature.dao.EventDaoImpl;

public class EventService {

	public static List<Event> retrieveAllEvents(){
		List<Event> events=null;
		EventDaoImpl manager= new EventDaoImpl();
		events = manager.selectAllEvents();
		
		return events;
	}

	public static boolean insertEvent(Event event) {
		boolean inserted = false;
		EventDaoImpl manager = new EventDaoImpl();

		int id = manager.insertEvent(event);
		if( id >0) {
			inserted = true;
		}
		
		
		return inserted;
	}
}
