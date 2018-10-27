package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.messages.MessageHandler;

public class AddMessage extends HttpServlet {
	private static final Logger log = Logger.getLogger(AddMessage.class);
	private static final long serialVersionUID = 4696068545981231177L;

	/*	RETURNS EITHER
	 * 200 success code if message recorded
	 * 400 error code otherwise
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Receiving request to add message.");
		
		//Getting information from request parameters and doing conversions
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			log.warn("Did not find account id, returning error.");
			res.sendError(400);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("ev_id");
		if (proxyString == null) {
			log.warn("Did not find event id, returning error.");
			res.sendError(400);
			return;
		}
		Integer ev_id = Integer.getInteger(proxyString);
		String content = req.getParameter("content");
		if (content == null) {
			log.warn("Did not find message content, returning error.");
			res.sendError(400);
			return;
		}
		
		//Actually performing requested action
		MessageHandler mh = new MessageHandler('|');
		
		log.debug("Accessing message handler to record message.");
		mh.record(ev_id, acc_id, content);
		
		res.sendError(200);
	}
	
}
