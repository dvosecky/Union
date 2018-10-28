package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.EventService;


public class RemoveEvent extends HttpServlet {
	private static final Logger log = Logger.getLogger(RemoveEvent.class);
	private static final long serialVersionUID = 1L;
    
	/*	RETURNS EITHER
	 * 200 success code in case of successful removal
	 * 400 error code in case of failure to remove
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to remove an event.");
		
		//Getting info from parameters and doing integer conversion
		int eventID = Integer.parseInt( request.getParameter("eventid") );
		
		//Accessing service layer to remove event
		if( EventService.removeEvent(eventID)) {
			response.sendError(200);
		}
		
		log.warn("Sending back an error: event removal unsuccessful.");
		response.sendError(400);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to remove an event.");
		doGet(request, response);
	}

}
