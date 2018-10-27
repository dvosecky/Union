package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.InvitationServices;

public class DeclineInvitation extends HttpServlet {
	private static final long serialVersionUID = -6302587460789146865L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_id");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer inv_id = Integer.getInteger(proxyString);
		
		boolean result = InvitationServices.declineInvitation(acc_id, inv_id);
		
		if (result) {
			res.sendError(200);
			return;
		}
		
		res.sendError(500);
	}
}
