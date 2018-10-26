package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Department;
import com.revature.services.DepartmentServices;

public class GetAllDepartments extends HttpServlet{
	private static final long serialVersionUID = 3784785168102819424L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			res.sendError(401);
			return;
		}

		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		ObjectMapper om = new ObjectMapper();
		List<Department> departments = DepartmentServices.getAllDepartments();
		
		out.print(om.writeValueAsString(departments));
	}
}
