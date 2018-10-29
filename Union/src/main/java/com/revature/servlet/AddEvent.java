package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.services.EventService;


public class AddEvent extends HttpServlet {
	private static final Logger log = Logger.getLogger(AddEvent.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to add an event.");
		
		//retrieves parameters 
		String eventname, description, location, date, time;
		eventname = request.getParameter("eventName");
		description = request.getParameter("description");
		location = request.getParameter("location");
		date = request.getParameter("date");
		time = request.getParameter("time");
		
		//converts date and time to a timestamp datatype
		log.debug("Converting date and time into SQL timestamp.");
		String temp =date+" "+time+":00";
		System.out.println(temp);
		Timestamp timestamp = Timestamp.valueOf(temp);
		
		//converts accountID to in int data type
		int accountID =Integer.parseInt(request.getParameter("accountID") );

		//retrieve account 
		AccountDaoImpl manager=new AccountDaoImpl();
		Account account = manager.selectAccountById(accountID);
		
		log.trace("Checking if account that asked for request exists or was even provided.");
		if( account != null) {
			Event event = null;
			
			/*Checking role for approval level:
			 * 0 and below is a regular employee and thus needs approval from higher ups
			 * 1 and above is department head and above, and don't need approval for events
			 */
			if( account.getRole() > 0 ) {
				log.trace("Found that role was sufficient to not need approval.");
				event = new Event( null,timestamp,eventname,description,location, account,1); 
				
			}else {
				log.trace("Found that role is insufficient to approve, and thus needs department head or above to approve.");
				event = new Event( null,timestamp,eventname,description,location, account,0); 
				
			}
		
			//Accessing service layer to add event.
			Integer eventId = EventService.insertEvent(event);
			if(eventId != null) {
				ObjectMapper om = new ObjectMapper();
				PrintWriter out = response.getWriter();
				System.out.println(eventId);
				out.print(om.writeValueAsString(eventId));
				return;
			}
		}

		log.warn("Sending back an error: Event not added.");
		//AddEvent does not differentiate different problems with request, any lack of success results in 400 error code
		response.sendError(400);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to add event.");
		doGet(request, response);
	}

}
