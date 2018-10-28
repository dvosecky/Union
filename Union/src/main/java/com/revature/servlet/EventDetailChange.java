package com.revature.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.services.EventService;

public class EventDetailChange extends HttpServlet {
	private static final Logger log = Logger.getLogger(EventDetailChange.class);
	private static final long serialVersionUID = -7226532955061041842L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request to change event details.");
		
		//Getting parameters from request
		String eventname, description, location, date, time;
		eventname = req.getParameter("eventName");
		description = req.getParameter("description");
		location = req.getParameter("location");
		date = req.getParameter("date");
		time = req.getParameter("time");
		
		//converts date and time to a timestamp datatype
		log.debug("Converting date and time into SQL timestamp.");
		String temp =date+" "+time+":00";
		System.out.println(temp);
		Timestamp timestamp = Timestamp.valueOf(temp);
		
		//converts accountID to in int data type
		int accountID =Integer.parseInt(req.getParameter("accountID") );

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
			if(EventService.editEvent(event)) {
				res.sendError(200);
				return;
			}
		}

		log.warn("Sending back an error: Event not edited.");
		//EditEvent does not differentiate different problems with request, any lack of success results in 400 error code
		res.sendError(400);
	}
}
