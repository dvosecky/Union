package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.DepartmentServices;

/*	RETURNS EITHER
 * 200 success code in case of success
 * 400 error code in case of nonexistent deletion or insufficient input
 * 401 error code in case of insufficient credentials
 * 500 error code in all other cases
 */
public class RemoveDepartment extends HttpServlet {
	private static final long serialVersionUID = 7570299456066560173L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String proxyString = req.getParameter("role");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer role = Integer.getInteger(proxyString);
		proxyString = req.getParameter("dep_id");
		if (proxyString == null) {
			res.sendError(400);
			return;
		}
		Integer dep_id = Integer.getInteger(proxyString);
		
		
		if (role > 1) {
			boolean result = DepartmentServices.deleteDepartmentByDepId(dep_id);
			if (result) {
				res.sendError(200);
			}
			else {
				res.sendError(400);
			}
		}
		else {
			res.sendError(401);
		}
		
		res.sendError(500);
	}
}
