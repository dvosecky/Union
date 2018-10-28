package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.InvitationServices;

public class CreateInvitation extends HttpServlet{
	private static final Logger log = Logger.getLogger(CreateInvitation.class);
	private static final long serialVersionUID = -567945821593226875L;

	/*	RETURNS EITHER
	 * 200 success code in case of successful invite
	 * 401 error code in case of lacking account id
	 * 400 error code in case of lacking input
	 * 500 error code in all other cases
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request to send a single invite.");
		
		//Getting info from parameters and making integer conversions
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Sending back an error: account id of account sending invite missing from parameters.");
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_acc_id");
		if (proxyString == null) {
			log.warn("Sending back an error: account id of account receiving invite missing from parameters.");
			res.sendError(400);
			return;
		}
		Integer inv_acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_ev_id");
		if (proxyString == null) {
			log.warn("Sending back an error: event id missing from parameters.");
			res.sendError(400);
			return;
		}
		Integer inv_ev_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_priv_flag");
		if (proxyString == null) {
			log.warn("Sending back an error: privilege flag missing from parameters.");
			res.sendError(400);
			return;
		}
		Integer inv_priv_flag = Integer.getInteger(proxyString);
		
		//Accessing service layer to send invite
		boolean result = InvitationServices.invite(acc_id, inv_acc_id, inv_ev_id, inv_priv_flag);
		
		//Checking boolean result of invite creation and sending appropriate http code
		log.trace("Checking boolean result of invite operation.");
		if (result) {
			res.sendError(200);
			return;
		}
		
		log.warn("Sending back an error: invite was unsuccessful.");
		res.sendError(500);
	}
}
