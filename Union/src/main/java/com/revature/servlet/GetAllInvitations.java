package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GetAllInvitations extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetAllInvitations.class);
	private static final long serialVersionUID = -5751351096717959963L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received request to get all invitations sent to a user. (Not including deny)");
		
		//Getting info from parameters
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Sending error back: did not find account id in parameters of request.");
			res.sendError(401);
			return;
		}
		int acc_id = Integer.getInteger(proxyString);
		
		//TODO
		//List<InvitationDTO> = InvitationServices.getAllInvitations(acc_id);
	}
}
