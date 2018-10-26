package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Department;
import com.revature.services.DepartmentServices;

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
		proxyString = req.getParameter("lead_id");
		if (proxyString == null) {
			res.sendError(401);
			return;
		}
		Integer lead_id = Integer.getInteger(proxyString);
		
		/*if (role > 1) {
			Department d = DepartmentServices.selectDepartmentByName(dep_name); //TODO
			if (d == null) {
				DepartmentServices.insertDepartmentWithLead(dep_name, lead_id);
				res.sendError(200);
			}
			else {
				res.sendError(400);
			}
		}*/
		
		res.sendError(500);
	}
}
