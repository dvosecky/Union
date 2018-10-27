package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.EventService;

/*	RETURNS EITHER
 * 200 success code if successfully approves event
 * 400 error code if lacking input
 * 401 error code if lacking credentials
 * 500 error code for all other cases
 */
public class DeclineEvent extends HttpServlet{
	private static final Logger log = Logger.getLogger(DeclineEvent.class);
	private static final long serialVersionUID = 974941227212480366L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Receiving a request for an event to be declined.");
		
		//Getting all parameters from request and converting them
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Did not find account id in request, rendering invalid: returning error.");
			res.sendError(401);
			return;
		}
		//Converting parameter in request to integer
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("ev_id");
		if (proxyString == null) {
			log.warn("Did not find event id in request, rendering invalid: returning error.");
			res.sendError(400);
			return;
		}
		//Converting parameter in request to integer
		Integer ev_id = Integer.getInteger(proxyString);
		
		//Accessing service layer
		boolean result = EventService.declineEvent(acc_id, ev_id);
		
		log.trace("Checking if event declinement was successful.");
		if (result) {
			res.sendError(200);
		}
		
		log.warn("Event declinement was not successful, returning error.");
		res.sendError(500);
	}
}
