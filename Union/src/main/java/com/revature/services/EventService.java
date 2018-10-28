package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;
import com.revature.dto.EventDTO;

public class EventService {
	public static final Logger logger = Logger.getLogger(EventService.class);

	//A list of events is returned using event lead id
	public static List<EventDTO> retrieveEventsByLead( int eventlead ){
		logger.info("In Retrieve Events By Lead");
		List<EventDTO> events =null;
		List<Event> tempevents =null;
		EventDaoImpl manager = new EventDaoImpl();
		EventDTO tempDTO=null;
		
		//All events are returned 
		logger.debug("Get all Events using select all event method");
		tempevents = manager.selectAllEvents();
		if( tempevents !=null) {
			events = new ArrayList<EventDTO>();
			
			
			for( Event e: tempevents) {
				//if eventlead is equal to event's lead return
				if( e.getLead().getId() == eventlead ) {
					tempDTO = new EventDTO( e, e.getLead().getId());
					events.add(tempDTO);
				}
			}
		}
		
		return events;
	}
	
	//A list of all events is returned
	public static List<EventDTO> retrieveAllEvents(){
		logger.info("In Retrieve all Events");
		List<Event> events=null;
		List<EventDTO> eventDTOS=new ArrayList<EventDTO>();
		int accountID=0;
		EventDTO eventDTO=null;
		EventDaoImpl manager= new EventDaoImpl();
		logger.debug("A list of all events is returned using select all events");
		events = manager.selectAllEvents();
		//convert events into their dtos and return
		for( Event e: events) {
			accountID= e.getLead().getId();
			eventDTO = new EventDTO( e, accountID);
			eventDTOS.add(eventDTO);
		}
		
		return eventDTOS;
	}

	//Inserted a event into a db and returns a boolean value 
	public static boolean insertEvent(Event event) {
		logger.info("In Insert Event");
		boolean inserted = false;
		EventDaoImpl manager = new EventDaoImpl();

		logger.debug("Event is being inserted into database using insert Event method");
		int id = manager.insertEvent(event);
		//if id is greater than zero, event was inserted and
		//return event id
		if( id >0) {
			inserted = true;
		}
		
		
		return inserted;
	}

	//An event is removed and returns a boolean value
	public static boolean removeEvent( int eventID ) {
		logger.info("In Remove Event");
		boolean deleted = false;
		EventDaoImpl manager = new EventDaoImpl();
		//An Event is return by event id
		logger.debug("An event is being return by eventid using select event by id");
		Event event = manager.selectEventById(eventID);
		
		//if the event exists, delete event
		if( event != null) {
			logger.debug("The event is deleted using deleted event by eventid");
			manager.deleteEventById(event.getId());
			deleted = true;
		}
		
		return deleted;
		
	}

	//A list of events is returned for a specific account
	public static List<EventDTO> retrieveEventsByAccount( int accountID) {
		logger.info("In Retrieve Events By Account");
		AccountDaoImpl amanager = new AccountDaoImpl();
		List<Event> events=null;
		//account is retrieved using accoutn id
		logger.debug("An account is returned using select account by id");
		Account account = amanager.selectAccountById(accountID);
		List<EventDTO> eventDTOS = new ArrayList<EventDTO>();
		int accID =0;
		EventDTO eventDTO=null;
		
		//Using a invitation, events associated with account is returned
		if( account != null) {
			logger.debug("All events for an account is returned using select all events by acc");
			InvitationDaoImpl manager = new InvitationDaoImpl();
			events=manager.selectAllEventsByAcc(account);
			
			//transform all objects to dtos
			for( Event e: events) {
				accID = e.getLead().getId();
				eventDTO = new EventDTO( e, accID);
				eventDTOS.add(eventDTO);
			}
		}
		
		return eventDTOS;
	}

	//AN event is approved by accound lead
	public static boolean approveEvent(int acc_id, int ev_id) {
		logger.info("In Approve Event");
		boolean result = false;
		AccountDaoImpl ad = new AccountDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		//an account is returned
		logger.debug("A account is returned using acc id");
		Account a = ad.selectAccountById(acc_id);
		
		//if account exists approve event
		if (a != null) {
			logger.debug("An event is being returned by select eveny by id");
			Event e = ed.selectEventById(ev_id);
			if (e != null) {
				logger.debug("Event is being approved by approve event method");
				result = ed.approveEvent(ev_id);
			}
		}
		
		return result;
	}
	
	//An event is decline by account lead
	public static boolean declineEvent(int acc_id, int ev_id) {
		logger.info("In Decline Events");
		boolean result = false;
		AccountDaoImpl ad = new AccountDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		
		//an account is return
		logger.debug("An account is return using select account by id method");
		Account a = ad.selectAccountById(acc_id);
		
		if (a != null) {
			logger.debug("An event is being return using select event by id");
			Event e = ed.selectEventById(ev_id);
			if (e != null) {
				logger.debug("An event is being deleted using delete event by id");
				result = ed.deleteEventById(ev_id);
			}
		}
		
		return result;
	}
}
