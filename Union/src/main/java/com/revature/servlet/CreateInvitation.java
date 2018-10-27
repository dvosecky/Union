package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.InvitationServices;

public class CreateInvitation extends HttpServlet{
	private static final long serialVersionUID = -567945821593226875L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String proxyString = req.getParameter("acc_id");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		Integer acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_acc_id");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer inv_acc_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_ev_id");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer inv_ev_id = Integer.getInteger(proxyString);
		proxyString = req.getParameter("inv_priv_flag");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer inv_priv_flag = Integer.getInteger(proxyString);
		
		boolean result = InvitationServices.invite(acc_id, inv_acc_id, inv_ev_id, inv_priv_flag);
		
		if (result) {
			res.sendError(200);
			return;
		}
		
		res.sendError(500);
	}
}
