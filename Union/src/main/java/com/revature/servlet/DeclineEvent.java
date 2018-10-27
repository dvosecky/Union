package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.EventService;

/*	RETURNS EITHER
 * 200 success code if successfully approves event
 * 400 error code if lacking input
 * 401 error code if lacking credentials
 * 500 error code for all other cases
 */
public class DeclineEvent extends HttpServlet{
	private static final long serialVersionUID = 974941227212480366L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("ev_id");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer ev_id = Integer.getInteger(proxyString);
		
		boolean result = EventService.declineEvent(acc_id, ev_id);
		
		if (result) {
			res.sendError(200);
		}
		
		res.sendError(500);
	}
}
