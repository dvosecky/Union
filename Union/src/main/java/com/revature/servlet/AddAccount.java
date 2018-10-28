package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Department;
import com.revature.services.DepartmentServices;
import com.revature.services.UserService;

/**
 * Servlet implementation class AddAccount
 */
public class AddAccount extends HttpServlet {
	private static final Logger log = Logger.getLogger(AddAccount.class);
	private static final long serialVersionUID = 1L;
   
	/*	RETURNS EITHER
	 * 200 success code if account successfully added
	 * 400 in all other cases
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to add an account.");
		
		//Getting all info from parameters of request
		String email,password, firstname,lastname;
		Integer role,department;
		email = request.getParameter("email");
		password = request.getParameter("password");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		department = Integer.parseInt(request.getParameter("department"));
		role =Integer.parseInt(request.getParameter("role"));
		
		//Getting department to confirm proper registration (department must exist)
		Department dep = DepartmentServices.getDepartmentByDepId(department);
		log.trace("Checking if requested department for account to be a part of exists.");
		if( dep != null) {
			Account acc = new Account(null,email,password,firstname,lastname, dep, role);
			
			//Accessing service layer to add account and checking boolean result
			if(UserService.addAccount(acc)) {
				response.sendError(200);
			}else {
				log.warn("Sending back an error: department existed but adding account was unsuccessful.");
				response.sendError(400);
			}
			
		}else {
			log.warn("Sending back an error: department does not exist.");
			response.sendError(400);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
