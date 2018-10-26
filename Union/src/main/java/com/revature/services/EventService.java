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
}
