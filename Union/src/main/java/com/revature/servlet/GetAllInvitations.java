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
import com.revature.dto.InvitationDTO;
import com.revature.services.InvitationServices;

public class GetAllInvitations extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetAllInvitations.class);
	private static final long serialVersionUID = -5751351096717959963L;

	/*	RETURNS EITHER
	 * JSON string representation of InvitationDTO list
	 * 
	 * 401 error code when account id not found in parameters
	 */
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
		
		//Accessing service layer to get invitation DTO lists
		List<InvitationDTO> result = InvitationServices.getAllInvitations(acc_id);
		
		//Initialization of object mapper and writer for responses now that results are back
		ObjectMapper om = new ObjectMapper();
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		
		//Returning result
		log.debug("Using object mapper to write invitation dto list as a JSON string, then writing it in response.");
		out.print(om.writeValueAsString(result));
	}
}
