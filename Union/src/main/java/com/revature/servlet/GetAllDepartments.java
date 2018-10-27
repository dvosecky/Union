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
import com.revature.beans.Department;
import com.revature.services.DepartmentServices;

/*	RETURNS EITHER
 * List<Department> JSON object in case of success
 * 401 error code in case of lacking user credentials
 */
public class GetAllDepartments extends HttpServlet{
	private static final Logger log = Logger.getLogger(GetAllDepartments.class);
	private static final long serialVersionUID = 3784785168102819424L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//<<<<<<< HEAD
		System.out.println("hello?");
//		if (req.getParameter("role") == null) {
//			res.sendError(401);
//			return;
//		}
//=======
		//Checking if role is in request parameters.
//		if (req.getParameter("role") == null) {
//			log.warn("Sending error because role could not be found in request.");
//			res.sendError(401);
//			return;
//		}
//>>>>>>> 1f22ee67f0e8d27efc4a830c09680d88c9176698

		//Initialization
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		ObjectMapper om = new ObjectMapper();
		//Accessing service layer
		List<Department> departments = DepartmentServices.getAllDepartments();
		
		log.debug("Accessing object mapper to return department list JSON representation.");
		out.print(om.writeValueAsString(departments));
	}
}
