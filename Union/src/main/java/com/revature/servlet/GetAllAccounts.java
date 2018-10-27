package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.AccountDTO;
import com.revature.services.UserService;

/**
 * Servlet implementation class GetAllAccounts
 */
public class GetAllAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<AccountDTO> accounts = null;
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		accounts = UserService.retrieveAllAccount();
		out.print(om.writeValueAsString(accounts));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
