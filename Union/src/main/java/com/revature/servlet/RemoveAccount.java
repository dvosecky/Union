package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.services.UserService;

/**
 * Servlet implementation class RemoveAccount
 */
public class RemoveAccount extends HttpServlet {
	private static final Logger log = Logger.getLogger(RemoveAccount.class);
	private static final long serialVersionUID = 1L;
       
	/*	RETURNS EITHER
	 * 200 success code upon successful deletion
	 * 400 error code in all other cases
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to remove an account.");
		
		//Getting info from parameters
		String deleteUser = request.getParameter("username");
		
		//Accessing service layer
		if( UserService.removeAccount(deleteUser)) {
			response.sendError(200);
		}else {
			log.warn("Sending back an error: account removal unsuccessful.");
			response.sendError(400);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to remove an account.");
		doGet(request, response);
	}

}
