package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.DepartmentServices;

/*	RETURNS EITHER
 * 200 success code in case of success
 * 400 error code in case of duplicate insertion or lacking input
 * 401 error code in case of role being invalid for operation (too low to perform action)
 * 500 error code in all other cases
 */
public class AddDepartment extends HttpServlet{
	private static final long serialVersionUID = 5106116686990741886L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String proxyString = req.getParameter("role");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		Integer role = Integer.getInteger(proxyString);
		proxyString = req.getParameter("dname");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		String dep_name = proxyString;
		
		if (role > 1) {
			boolean result = DepartmentServices.insertDepartmentWithLead(dep_name);
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
