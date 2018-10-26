package com.revature.services;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Invitation;
import com.revature.dao.AccountDaoImpl;
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
				id.acceptInviteById(inv_id);
				return true;
			}
		}
		
		return false;
	}

}
