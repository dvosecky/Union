package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.AccountDTO;
import com.revature.services.UserService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final Logger log = Logger.getLogger(Login.class);
	private static final long serialVersionUID = 1L;

	/*	RETURNS EITHER
	 * JSON string representation of AccountDTO of account user will now be logged into
	 * 401 error code if unsuccessful
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to log into an account.");
		
		//Getting parameters from request
		String username, password;
		username=request.getParameter("email");
		password=request.getParameter("password");
		
		//Accessing service layer
		AccountDTO acc=  UserService.loginToUnion(username, password);
		
		//Checking if login was successful.
		log.trace("Checking if account is existant.");
		if(acc!= null) {
			//Initializing object mapper to convert and writer to write to response
			ObjectMapper om = new ObjectMapper();
			PrintWriter out = response.getWriter();
			
			//Sending back AccountDTO as JSON string
			out.print(om.writeValueAsString(acc));
		}else {
			log.warn("Sending back an error: account does not exist.");
			response.sendError(401);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to log into an account.");
		doGet(request, response);
	}

}
