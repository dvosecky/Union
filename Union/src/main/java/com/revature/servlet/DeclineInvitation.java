package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.InvitationServices;

public class DeclineInvitation extends HttpServlet {
	private static final Logger log = Logger.getLogger(DeclineInvitation.class);
	private static final long serialVersionUID = -6302587460789146865L;
	
	/*	RETURNS EITHER
	 * 200 success code in the case of successful invitation decline
	 * 401 error code in the case of missing account id
	 * 400 error code in the case of missing input
	 * 500 error code in all other cases
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request to decline an invitation.");
		
		//Getting info from parameters and doing integer conversions
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Sending back an error: missing account id in parameters.");
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_id");
		if (proxyString == null) {
			log.warn("Sending back an error: missing invitation id in parameters.");
			res.sendError(400);
			return;
		}
		Integer inv_id = Integer.getInteger(proxyString);
		
		//Accessing service layer to decline invitation
		boolean result = InvitationServices.declineInvitation(acc_id, inv_id);
		
		//Checking boolean result and sending appropriate http code back
		log.trace("Checking boolean result to see if decline was successful.");
		if (result) {
			res.sendError(200);
			return;
		}
		
		log.warn("Sending back an error: invitation decline unsuccessful.");
		res.sendError(500);
	}
}
