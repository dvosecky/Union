package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;
import com.revature.dto.InvitationDTO;

public class InvitationServices {
	public static final Logger logger = Logger.getLogger(InvitationServices.class);
	
	//Get invitation DTO list of all invitations user identified by acc_id has
	public static List<InvitationDTO> getAllInvitations(int acc_id){
		logger.info("Services has been called to return a list of invitation DTOs by user.");
		
		//Initialization of resources
		List<InvitationDTO> invites_fixed = new ArrayList<InvitationDTO>();
		List<Invitation> invites = null;	
		AccountDaoImpl ad = new AccountDaoImpl();
		InvitationDaoImpl id = new InvitationDaoImpl();
		Account acc = ad.selectAccountById(acc_id);
		
		logger.trace("Checking if account associated with acc_id exists.");
		if (acc == null) {
			logger.warn("Account does not exist, returning empty list.");
			return invites_fixed;
		}
		
		//Accessing DAO layer to get all invites associated with Account acc
		invites = id.selectAllInvitesByAcc(acc);
		
		//Adding all invites as InvitationDTOs
		for (Invitation i : invites) {
			invites_fixed.add(new InvitationDTO(i));
		}
		
		return invites_fixed;
	}
	
	//invitation is accepted by account
	public static boolean acceptInvitation(Integer acc_id, Integer inv_id) {
		logger.info("In accept invitation");
		if (acc_id == null || inv_id == null) {
			return false;
		}

		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		logger.debug("An account is being returned by select account by id");
		Account a = ad.selectAccountById(acc_id);
		
		if (a == null) {
			return false;
		}
		//a list of invitation is being returned 
		logger.debug("A list of invitation is being returned for an account");
		List<Invitation> is = id.selectAllInvitesByAcc(a);
		
		//the invitation are accepted
		logger.debug("The list of invitations are accepted using accept invite");
		for (int i = 0; i < is.size(); i++) {
			if (is.get(i).getId() == inv_id) {
				id.acceptInvite(inv_id);
				return true;
			}
		}
		
		return false;
	}

	//Invitations are decline by account
	public static boolean declineInvitation(Integer acc_id, Integer inv_id) {
		logger.info("In Decline Invitation");
		if (acc_id == null || inv_id == null) {
			return false;
		}
		
		
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		//an account is return by id
		logger.debug("An account is return using select account by id method");
		Account a = ad.selectAccountById(acc_id);
		logger.debug("An list of invitation for account is return using select all invites by acc");
		List<Invitation> is = id.selectAllInvitesByAcc(a);
		
		//invitation are deleted
		logger.debug("List of invites are all delete using delete invitation by id");
		for (int i = 0; i < is.size(); i++) {
			if (is.get(i).getId() == inv_id) {
				id.deleteInvitationById(inv_id);
				return true;
			}
		}
		
		return false;
	}

	//An invitation is inserted into database
	public static boolean invite(Integer acc_id, Integer inv_ev_id, Integer inv_priv_flag) {
		logger.info("In Invite");
		if (acc_id == null || inv_ev_id == null || inv_priv_flag == null) {
			System.out.println("2");
			return false;
		}
		
		InvitationDaoImpl id = new InvitationDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		logger.debug("An account is being returned using select account by id");
		Account a = ad.selectAccountById(acc_id);
		logger.debug("A event is being returned using select event by id");
		Event e = ed.selectEventById(inv_ev_id);
		
		//It would be better to return a 401 error if this is the case, but
		//it seems like this logic should be here for better abstraction.
//		if (e.getLead().getId() != a.getId()) {
//			System.out.println("1");
//			return false;
//		}
	
		//invitation for a specific event is return
//		logger.debug("Invites for a specific event is return using select all invites");
//		List<Invitation> invites = id.selectAllInvitesByEv(e);
		
		
//		for (int i = 0; i < invites.size(); i++) {
//			if (invites.get(i).getAcc().getId() == a.getId()) {
//				System.out.println("3");
//			}
//		}
		
		
		Invitation inv = new Invitation(null, a, e, 0, inv_priv_flag);
		
		logger.debug("An invitation is inserted using insert invitation method");
		id.insertInvitation(inv);
		
		return true;
	}
}
