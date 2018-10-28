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
import com.revature.dao.AccountDaoImpl;
import com.revature.dto.EventDTO;
import com.revature.services.EventService;


public class GetEventByLead extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetEventByLead.class);
	private static final long serialVersionUID = 1L;

	/*	RETURNS EITHER
	 * A JSON string representation of EventDTO list
	 * 
	 * 400 error code in case of unsuccessful retrieval
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to get all events an account is the lead of.");
		
		//Getting info from parameters and doing integer conversion + initialization of objects
		int eventLead = Integer.parseInt(request.getParameter("accountID"));
		AccountDaoImpl manager = new AccountDaoImpl();
		
		//Accessing service layer to get account
		log.trace("Checking if lead account even exists.");
		if( manager.selectAccountById(eventLead) != null) {
			//More objects initialized for use, such as the list and object mapper
			List<EventDTO> events =null;
			ObjectMapper om = new ObjectMapper();
			PrintWriter out = response.getWriter();
			
			//Accessing service layer to get events
			events = EventService.retrieveEventsByLead(eventLead);
			
			log.trace("Checking if events are null: retrieval unsuccessful.");
			if( events != null) {
				//Using object mapper to return a JSON string representation of EventDTO list
				out.print(om.writeValueAsString(events));
				return;
			}
		}
		
		log.warn("Sending back an error: events were not retrieved.");
		response.sendError(400);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to get all events an account is the lead of.");
		doGet(request, response);
	}

}
