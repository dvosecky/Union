package com.revature.tests;

import java.util.List;

import com.revature.beans.Account;
//import com.revature.beans.Department;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
//import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;

public class InvitationTest {

	public static void main(String[] args) {
		List<Invitation> invs = null;
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		
		Account a = ad.selectAccountById(1);
		Event e = ed.getEventById(1);
		
		System.out.println("SELECT ALL");
		invs = id.getAllInvitations();
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT BY ACCOUNT ID");
		invs = id.getAllInvitesByAcc(a);
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT BY EVENT ID");
		invs = id.getAllInvitesByEv(e);
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		System.out.println("SELECT ACCEPTED");
		invs = id.getAllAcceptInvites();
		for (Invitation i : invs) {
			System.out.println(i);
		}
		
		/*System.out.println("ADD");
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		Department d = dd.selectDepartmentById(1);
		Account ac = new Account(3, "d", "d", "d", d, null, null);
		Invitation inv = new Invitation(3, ac, e, 0, 0);
		System.out.println("with event: " + inv.getEv() + ", acc: " + inv.getAcc());
		id.insertInvitation(inv);*/
		
		System.out.println("DELETE");
		id.deleteInvitationById(1);
		
		System.exit(0);
	}

}
