package com.revature.services;

import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
import com.revature.dto.AccountDTO;

public class UserService {

	public static AccountDTO loginToUnion( String username, String password) {
		Account acc=null;
		AccountDTO accDTO=null;
		AccountDaoImpl account=new AccountDaoImpl();
		acc = account.selectAccountByUsername(username);
		
		
		if( acc != null) {
			if(acc.getPassword().equals(password)) {
				
				accDTO = new AccountDTO(acc.getId(),acc.getUsername(),acc.getPassword(),
						acc.getFirstname(),acc.getLastname(),acc.getDep().getDep_id(),acc.getRole());
				
				return accDTO;
			}
		}
		
		return null;
		
	}

	public static List<Account> retrieveAllAccount(){
		List<Account> accounts=null;
		AccountDaoImpl manager= new AccountDaoImpl();
		
		accounts=manager.selectAllAccount();
		
		return accounts;
	}

	public static boolean removeAccount( String username) {
		boolean deleted =false;
		AccountDaoImpl manager= new AccountDaoImpl();
		Account acc=null;
		acc=manager.selectAccountByUsername(username);
		
		if( acc != null) {
			manager.deleteAccountByUsername(username);
			deleted=true;
		}
		
		return deleted;
	}

	public static boolean addAccount(Account account) {
		boolean added=false;
		AccountDaoImpl manager= new AccountDaoImpl();
		int id=0;
		if( manager.selectAccountByUsername(account.getUsername()) == null) {
			id=manager.insertAccount(account);
			if( id>0) {
				added=true;
			}
		}

		
		return added;
	}
}
