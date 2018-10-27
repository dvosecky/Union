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
		//retrieves parameters 
		String eventname, description, location, date, time;
		eventname = request.getParameter("eventName");
		description = request.getParameter("description");
		location = request.getParameter("location");
		date = request.getParameter("date");
		time = request.getParameter("time");
		
		//converts date and time to a timestamp datatype
		String temp =date+" "+time+" "+":00";
		Timestamp timestamp = Timestamp.valueOf(temp);
		
		//converts accountID to in int data type
		int accountID =Integer.parseInt(request.getParameter("accountID") );

		//retrieve account 
		AccountDaoImpl manager=new AccountDaoImpl();
		Account account = manager.selectAccountById(accountID);
		
		if( account != null) {
			Event event = null;
			if( account.getRole() > 0 ) {
				event = new Event( null,timestamp,eventname,description,location, account,1); 
				
			}else {
				event = new Event( null,timestamp,eventname,description,location, account,0); 
				
			}
		
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
