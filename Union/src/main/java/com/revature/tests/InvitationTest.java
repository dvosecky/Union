package com.revature.tests;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;
public class InvitationTest {
	public static final Logger log = Logger.getLogger(InvitationTest.class);
	
	public static void main(String[] args) {
		log.trace("INVITATION TEST BEGIN");
		List<Invitation> invs = null;
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		
		log.trace("GETTING ACCOUNT AND EVENT FOR LATER");
		Account a = ad.selectAccountById(1);
		Event e = ed.selectEventById(1);
		
		log.trace("SELECT ALL");
		invs = id.selectAllInvitations();
		log.trace("Returned list of ... ");
		for (Invitation i : invs) {
			log.trace("" + i + " ");
		}
		
		log.trace("SELECT BY ACCOUNT ID");
		invs = id.selectAllInvitesByAcc(a);
		log.trace("Returned list of ... ");
		for (Invitation i : invs) {
			log.trace("" + i + " ");
		}
		
		log.trace("SELECT BY EVENT ID");
		invs = id.selectAllInvitesByEv(e);
		log.trace("Returned list of ... ");
		for (Invitation i : invs) {
			log.trace("" + i + " ");
		}
		
		log.trace("SELECT ACCEPTED");
		invs = id.selectAllAcceptInvites();
		log.trace("Returned list of ... ");
		for (Invitation i : invs) {
			log.trace("" + i + " ");
		}
		
		log.trace("ADD");
		e = ed.selectEventById(2);
		Invitation inv = new Invitation(3, a, e, 0, 0);
		log.trace("with event: " + inv.getEv() + ", acc: " + inv.getAcc());
		id.insertInvitation(inv);
		
		log.trace("DELETE");
		id.deleteInvitationById(1);
		
		log.trace("INVITATION TEST END");
		System.exit(0);
	}
}