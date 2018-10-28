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
public class ApproveEvent extends HttpServlet{
	private static final Logger log = Logger.getLogger(ApproveEvent.class);
	private static final long serialVersionUID = 974941227212480366L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request to approve an event.");
		
		//Getting info from parameters and making conversions to integers
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Sending error back: did not find account id in parameters of request.");
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("ev_id");
		if (proxyString == null) {
			log.warn("Sending error back: did not find event id in parameters of request.");
			res.sendError(400);
			return;
		}
		Integer ev_id = Integer.getInteger(proxyString);
		
		//Accessing service layer to approve event.
		boolean result = EventService.approveEvent(acc_id, ev_id);
		
		//Checking results and sending back appropriate http code in response.
		log.trace("Checking boolean result of event approval.");
		if (result) {
			res.sendError(200);
		}
		
		log.warn("Sending error back: approval of event unsuccessful.");
		res.sendError(500);
	}
}
