package com.revature.tests;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;

public class InvitationTest {

	public static void main(String[] args) {
		List<Invitation> invs = null;
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		
		Account a = ad.selectAccountById(1);
		Event e = ed.selectEventById(1);
		
		System.out.println("SELECT ALL");
		invs = id.selectAllInvitations();
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT BY ACCOUNT ID");
		invs = id.selectAllInvitesByAcc(a);
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT BY EVENT ID");
		invs = id.selectAllInvitesByEv(e);
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT ACCEPTED");
		invs = id.selectAllAcceptInvites();
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("ADD");
		e = ed.selectEventById(2);
		Invitation inv = new Invitation(3, a, e, 0, 0);
		System.out.println("with event: " + inv.getEv() + ", acc: " + inv.getAcc());
		id.insertInvitation(inv);
		
		System.out.println("DELETE");
		id.deleteInvitationById(1);
		
		System.exit(0);
	}

}
