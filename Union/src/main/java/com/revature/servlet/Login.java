package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.AccountDTO;
import com.revature.services.UserService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username, password;
		username=request.getParameter("email");
		password=request.getParameter("password");
		AccountDTO acc=  UserService.loginToUnion(username, password);
		
		if(acc!= null) {
			ObjectMapper om = new ObjectMapper();
			PrintWriter out = response.getWriter();
			out.print(om.writeValueAsString(acc));
			
		}else {
		
			response.sendError(401);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
