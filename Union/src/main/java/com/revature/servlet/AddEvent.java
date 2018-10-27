package com.revature.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.dao.AccountDaoImpl;
import com.revature.services.EventService;


public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String timestamp, eventname;
		timestamp = request.getParameter("timestamp");
		Timestamp date = Timestamp.valueOf(timestamp);
		int accountID =Integer.parseInt(request.getParameter("accountID") );
		eventname = request.getParameter("eventName");
		
		//retrieve account 
		AccountDaoImpl manager=new AccountDaoImpl();
		Account account = manager.selectAccountById(accountID);
		
		if( account != null) {
			Event event = new Event( null,date,eventname, account); 
			
			if(EventService.insertEvent(event)) {
				response.sendError(200);
			}
		}

		response.sendError(400);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
