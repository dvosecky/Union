package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.EventDTO;
import com.revature.services.EventService;


public class GetEventByAccount extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetEventByAccount.class);
	private static final long serialVersionUID = 1L;
 
	/*	RETURNS EITHER
	 * A JSON string representation of a list of all events:
	 * specifically, a list of EventDTOs (List<EventDTO>)
	 * 
	 * 400 error code in case of unsuccessful retrieval
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to get all events that an event has invitations to.");
		
		//Getting parameter, doing integer conversion, and initializing objects
		int accountID = Integer.parseInt(request.getParameter("accountID"));
		List<EventDTO> events=null;
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		
		//Accessing service layer to retrieve events
		events = EventService.retrieveEventsByAccount(accountID);
		
		//Checking if unsuccessful
		if(events != null) {
			log.debug("Accessing object mapper to convert event list into JSON string representation.");
			out.print(om.writeValueAsString(events));
		}else {
			log.warn("Sending back an error: Event retreival unsuccessful.");
			response.sendError(400);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to get all events that an event has invitations to.");
		doGet(request, response);
	}

}
