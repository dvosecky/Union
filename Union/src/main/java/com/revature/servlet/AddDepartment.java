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
 * 400 error code in case of duplicate insertion or lacking input
 * 401 error code in case of role being invalid for operation (too low to perform action)
 */
public class AddDepartment extends HttpServlet{
	private static final Logger log = Logger.getLogger(AddDepartment.class);
	private static final long serialVersionUID = 5106116686990741886L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		log.info("Received request to add a department.");
		
		//Getting info from parameters of request and doing necessary conversions
		String proxyString = req.getParameter("role");
		if (proxyString == null) {
			log.warn("Sending back an error: role not found in parameters of request.");
			res.sendError(401);
			return;
		}
		Integer role = Integer.getInteger(proxyString);
		proxyString = req.getParameter("dname");
		if (proxyString == null) {
			log.warn("Sending back an error: department name not found in parameters of request.");
			res.sendError(401);
			return;
		}
		String dep_name = proxyString;
		
		log.trace("Checking if role is above department lead level. If not, invalid request.");
		if (role > 1) {
			//Accessing service layer to insert department, TODO: change department service method name
			boolean result = DepartmentServices.insertDepartmentWithLead(dep_name);
			//Checking result of service layer operation and sending appropriate http code in response.
			if (result) {
				res.sendError(200);
				return;
			}
			else {
				log.warn("Sending back an error: insertion was unsuccessful.");
				res.sendError(400);
				return;
			}
		}
		else {
			log.warn("Sending back an error: role was not privileged enough to perform insertion.");
			res.sendError(401);
			return;
		}
	}
}
