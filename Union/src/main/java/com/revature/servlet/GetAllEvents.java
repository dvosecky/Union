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

public class GetAllEvents extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetAllEvents.class);
	private static final long serialVersionUID = 1L;
 
	/*	Returns JSON representation of list of all events
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received request for all events.");
		//Initialization
		List<EventDTO> events=null;
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		
		//Accessing service layer to retreive all events
		events = EventService.retrieveAllEvents();
		log.debug("Accessing object mapper to turn list of events into JSON representation for return.");
		out.print(om.writeValueAsString(events));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
