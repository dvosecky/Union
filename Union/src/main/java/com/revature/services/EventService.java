package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;
import com.revature.dto.EventDTO;

public class EventService {


	public static List<EventDTO> retrieveEventsByLead( int eventlead ){
		List<EventDTO> events =null;
		List<Event> tempevents =null;
		EventDaoImpl manager = new EventDaoImpl();
		EventDTO tempDTO=null;
		
		tempevents = manager.selectAllEvents();
		if( tempevents !=null) {
			events = new ArrayList<EventDTO>();
			
			for( Event e: tempevents) {
				
				if( e.getLead().getId() == eventlead ) {
					tempDTO = new EventDTO( e, e.getLead().getId());
					events.add(tempDTO);
				}
			}
		}
		
		return events;
	}
	
	public static List<EventDTO> retrieveAllEvents(){
		List<Event> events=null;
		List<EventDTO> eventDTOS=new ArrayList<EventDTO>();
		int accountID=0;
		EventDTO eventDTO=null;
		EventDaoImpl manager= new EventDaoImpl();
		events = manager.selectAllEvents();
		for( Event e: events) {
			accountID= e.getLead().getId();
			eventDTO = new EventDTO( e, accountID);
			eventDTOS.add(eventDTO);
		}
		
		return eventDTOS;
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

	public static boolean removeEvent( int eventID ) {
		boolean deleted = false;
		EventDaoImpl manager = new EventDaoImpl();
		Event event = manager.selectEventById(eventID);
		
		if( event != null) {
			manager.deleteEventById(event.getId());
			deleted = true;
		}
		
		return deleted;
		
	}

	public static List<EventDTO> retrieveEventsByAccount( int accountID) {
		AccountDaoImpl amanager = new AccountDaoImpl();
		List<Event> events=null;
		Account account = amanager.selectAccountById(accountID);
		List<EventDTO> eventDTOS = new ArrayList<EventDTO>();
		int accID =0;
		EventDTO eventDTO=null;
		
		if( account != null) {
			InvitationDaoImpl manager = new InvitationDaoImpl();
			events=manager.selectAllEventsByAcc(account);
			
			for( Event e: events) {
				accID = e.getLead().getId();
				eventDTO = new EventDTO( e, accID);
				eventDTOS.add(eventDTO);
			}
		}
		
		return eventDTOS;
	}

	
}
