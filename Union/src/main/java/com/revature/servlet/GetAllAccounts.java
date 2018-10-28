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
import com.revature.dto.AccountDTO;
import com.revature.services.UserService;

/**
 * Servlet implementation class GetAllAccounts
 */
public class GetAllAccounts extends HttpServlet {
	private static final Logger log = Logger.getLogger(GetAllAccounts.class);
	private static final long serialVersionUID = 1L;
       
	/*	Always returns a JSON representation of a list of all accounts
	 * Specifically, a list of AccountDTOs: (List<AccountDTO>)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a request to get all accounts.");
		
		//Initialization
		List<AccountDTO> accounts = null;
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		
		//Accessing service layer to retreive all accounts
		accounts = UserService.retrieveAllAccount();
		
		//Using object mapper to return a JSON representation of account list
		out.print(om.writeValueAsString(accounts));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Received a POST request to get all accounts.");
		doGet(request, response);
	}

}
