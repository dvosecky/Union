package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.DepartmentServices;

/*	RETURNS EITHER
 * 200 success code in case of success
 * 400 error code in case of nonexistent deletion or insufficient input
 * 401 error code in case of insufficient credentials
 */
public class RemoveDepartment extends HttpServlet {
	private static final Logger log = Logger.getLogger(RemoveDepartment.class);
	private static final long serialVersionUID = 7570299456066560173L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received a request to remove a department.");
		
		//Getting info from parameters and doing integer conversions
		String proxyString = req.getParameter("role");
		if (proxyString == null) {
			log.warn("Sending back an error: role not found in parameters.");
			res.sendError(400);
			return;
		}
		Integer role = Integer.getInteger(proxyString);
		proxyString = req.getParameter("dep_id");
		if (proxyString == null) {
			log.warn("Sending back an error: department id not found in parameters.");
			res.sendError(400);
			return;
		}
		Integer dep_id = Integer.getInteger(proxyString);
		
		//Checking role for permissions
		log.trace("Checking if role is enough to remove department: must be above department head (1).");
		if (role > 1) {
			//Accessing service layer to perform department deletion
			boolean result = DepartmentServices.deleteDepartmentByDepId(dep_id);
			log.trace("Checking boolean result to see if successful.");
			if (result) {
				res.sendError(200);
			}
			else {
				log.warn("Sending back an error: department deletion unsuccessful.");
				res.sendError(400);
			}
			return;
		}
		else {
			log.warn("Sending back an error: role not sufficient to perform department removal.");
			res.sendError(401);
			return;
		}
	}
}
