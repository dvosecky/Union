package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.AccountDaoImpl;
import com.revature.dto.EventDTO;
import com.revature.services.EventService;


public class GetEventByLead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eventLead = Integer.parseInt(request.getParameter("accountID"));
		AccountDaoImpl manager = new AccountDaoImpl();
		
		if( manager.selectAccountById(eventLead) != null) {
			List<EventDTO> events =null;
			ObjectMapper om = new ObjectMapper();
			PrintWriter out = response.getWriter();
			events = EventService.retrieveEventsByLead(eventLead);
			if( events != null) {
				out.print(om.writeValueAsString(events));
				return;
			}
		}
		
		response.sendError(400);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
