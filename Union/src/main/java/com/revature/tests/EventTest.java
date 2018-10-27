package com.revature.tests;
import java.sql.Timestamp;
import java.util.List;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
public class EventTest {
	public static void main (String []args) {
		EventDaoImpl ed = new EventDaoImpl();
		
		System.out.println("SELECT ALL");
		List<Event> evs = ed.selectAllEvents();
		for (Event e : evs) {
			System.out.println(e);
		}
		
		System.out.println("SELECT BY NAME");
		evs = ed.selectEventsByName("meeting");
		for (Event e : evs) {
			System.out.println(e);
		}
		
		System.out.println("SELECT BY ID");
		Event ev = ed.selectEventById(1);
		System.out.println(ev);
		
		System.out.println("ADD");
		AccountDaoImpl ad = new AccountDaoImpl();
		ev = new Event(3, Timestamp.valueOf("1994-11-07 12:00:00"), "Stuff","dont go to event","landons house", ad.selectAccountById(1));
		System.out.println("Added event with id of " + ed.insertEvent(ev) + ".");
		System.out.println("inserted " + ev);
		
		System.out.println("DELETE");
		ed.deleteEventById(1);
		
		System.exit(0);
	}
}