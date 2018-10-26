package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Department;
import com.revature.services.DepartmentServices;

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
			Department d = DepartmentServices.getDepartmentByDepId(dep_id);
			if (d != null) {
				DepartmentServices.deleteDepartmentByDepId(dep_id);
				res.sendError(200);
			}
			else {
				res.sendError(400);
			}
		}
		
		res.sendError(500);
	}
}
