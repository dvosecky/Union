package com.revature.services;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Event;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.EventDaoImpl;
import com.revature.dao.InvitationDaoImpl;

public class InvitationServices {

	public static boolean acceptInvitation(Integer acc_id, Integer inv_id) {
		if (acc_id == null || inv_id == null) {
			return false;
		}
		
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		Account a = ad.selectAccountById(acc_id);
		
		if (a == null) {
			return false;
		}
		
		List<Invitation> is = id.selectAllInvitesByAcc(a);
		
		for (int i = 0; i < is.size(); i++) {
			if (is.get(i).getId() == inv_id) {
				id.acceptInvite(inv_id);
				return true;
			}
		}
		
		return false;
	}

	public static boolean declineInvitation(Integer acc_id, Integer inv_id) {
		if (acc_id == null || inv_id == null) {
			return false;
		}
		
		InvitationDaoImpl id = new InvitationDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		Account a = ad.selectAccountById(acc_id);
		
		List<Invitation> is = id.selectAllInvitesByAcc(a);
		
		for (int i = 0; i < is.size(); i++) {
			if (is.get(i).getId() == inv_id) {
				id.deleteInvitationById(inv_id);
				return true;
			}
		}
		
		return false;
	}

	public static boolean invite(Integer acc_id, Integer inv_acc_id, Integer inv_ev_id, Integer inv_priv_flag) {
		if (acc_id == null || inv_acc_id == null || inv_ev_id == null || inv_priv_flag == null) {
			return false;
		}
		
		InvitationDaoImpl id = new InvitationDaoImpl();
		EventDaoImpl ed = new EventDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		Account a = ad.selectAccountById(acc_id);
		Event e = ed.selectEventById(inv_ev_id);
		
		//It would be better to return a 401 error if this is the case, but
		//it seems like this logic should be here for better abstraction.
		if (e.getLead().getId() != a.getId()) {
			return false;
		}
	
		List<Invitation> invites = id.selectAllInvitesByEv(e);
		
		for (int i = 0; i < invites.size(); i++) {
			if (invites.get(i).getAcc().getId() == a.getId()) {
				return false;
			}
		}
		
		Invitation inv = new Invitation(null, a, e, 0, inv_priv_flag);
		
		id.insertInvitation(inv);
		
		return true;
	}
}
