package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.InvitationServices;

public class AcceptInvitation extends HttpServlet{
	private static final Logger log = Logger.getLogger(AcceptInvitation.class);
	private static final long serialVersionUID = -4844568652719682269L;
	
	/*	RETURNS EITHER
	 * 200 success code if acceptance of invite was successful
	 * 401 error code if acc_id not found in parameters
	 * 400 error code if inv_id not found in parameters
	 * 500 error code in all other cases
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//Getting info from parameters and doing conversions from string into integers.
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Did not find account id in parameters of request, sending error.");
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_id");
		if (proxyString == null) {
			log.warn("Did not find invite id in parameters of request, sending error.");
			res.sendError(400);
			return;
		}
		Integer inv_id = Integer.getInteger(proxyString);
		
		//Accessing service layer to accept invite.
		boolean result = InvitationServices.acceptInvitation(acc_id, inv_id);
		
		//Checking result and sending http code depending on result.
		log.trace("Checking if acceptance was successful.");
		if (result) {
			res.sendError(200);
			return;
		}
		
		log.warn("Something went wrong, as acceptance failed. Sending error.");
		res.sendError(500);
	}
}
