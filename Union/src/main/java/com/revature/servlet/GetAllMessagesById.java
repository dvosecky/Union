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
import com.revature.messages.Message;
import com.revature.messages.MessageHandler;

public class GetAllMessagesById extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetAllMessagesById.class);
	private static final long serialVersionUID = 8100283317777638915L;

	/*	RETURNS EITHER
	 * 400 error code if no event id found
	 * otherwise JSON object representing message list
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request for all messages for an event.");
		
		String proxyString = req.getParameter("ev_id");
		if (proxyString == null) {
			log.warn("Found no event id in request, rendering it invalid, returning an error.");
			res.sendError(400);
			return;
		}
		//Converting string from request parameters into integer
		Integer ev_id = Integer.getInteger(proxyString);
		
		MessageHandler mh = new MessageHandler('|');
		
		log.debug("Retreiving events with message handler.");
		List<Message> ms = mh.retreiveAll(ev_id);
		
		//Returning JSON object: setting up writer and feeding message list into an object mapper
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		ObjectMapper om = new ObjectMapper();
		log.debug("Converting and sending off list of messages with object mapper.");
		out.print(om.writeValueAsString(ms));
	}
}
