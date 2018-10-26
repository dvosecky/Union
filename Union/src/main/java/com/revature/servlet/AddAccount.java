package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Account;
import com.revature.beans.Department;
import com.revature.services.DepartmentServices;
import com.revature.services.UserService;

/**
 * Servlet implementation class AddAccount
 */
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email,password, firstname,lastname;
		Integer role,department;
		email = request.getParameter("email");
		password = request.getParameter("password");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		department = Integer.parseInt(request.getParameter("department"));
		role =Integer.parseInt(request.getParameter("role"));
		
		Department dep = DepartmentServices.getDepartmentByDepId(department);
		if( dep != null) {
			Account acc = new Account(null,email,password,firstname,lastname, dep, role);
			if(UserService.addAccount(acc)) {
				response.sendError(200);
			}else {
				response.sendError(400);
			}
			
		}else {
			response.sendError(400);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
