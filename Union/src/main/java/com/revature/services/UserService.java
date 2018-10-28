package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
import com.revature.dto.AccountDTO;

public class UserService {
	public static final Logger logger = Logger.getLogger( UserService.class);
	
	//login in service
	public static AccountDTO loginToUnion( String username, String password) {
		logger.info("In Login To Union");
		Account acc=null;
		AccountDTO accDTO=null;
		AccountDaoImpl account=new AccountDaoImpl();
		logger.debug("An account is returned using select account by username method");
		acc = account.selectAccountByUsername(username);
		
		//if an account exist check if password mater
		if( acc != null) {
			//if passwords match, return accountDTOs
			if(acc.getPassword().equals(password)) {
				
				accDTO = new AccountDTO(acc.getId(),acc.getUsername(),acc.getPassword(),
						acc.getFirstname(),acc.getLastname(),acc.getDep().getDep_id(),acc.getRole());
				
				return accDTO;
			}
		}
		
		return null;
		
	}

	//A list of all accounts is retunr
	public static List<AccountDTO> retrieveAllAccount(){
		logger.info("In Retrieve all account ");
		List<AccountDTO> accounts=null;
		List<Account> tempaccounts=null;
		AccountDaoImpl manager= new AccountDaoImpl();
		
		logger.debug("A list of alll accounts is return using select all account method");
		tempaccounts=manager.selectAllAccount();
		
		//if a list of account is return, transform to dtos
		if( tempaccounts != null) {
			AccountDTO temp =null;
			accounts = new ArrayList<AccountDTO>();
			//transform to dto and add to list
			for( Account a: tempaccounts) {
				temp = new AccountDTO(a);
				accounts.add(temp);
			}
			
		}
		
		return accounts;
	}

	//return true or false if account has been removed
	public static boolean removeAccount( String username) {
		logger.info("In Remove Account");
		boolean deleted =false;
		AccountDaoImpl manager= new AccountDaoImpl();
		Account acc=null;
		logger.debug("Program is looking for an account using select account by username");
		acc=manager.selectAccountByUsername(username);
		
		//if account exist delete
		if( acc != null) {
			logger.debug("Account is being deleted using delete account by username");
			manager.deleteAccountByUsername(username);
			deleted=true;
		}
		
		return deleted;
	}

	//returns true or false if account is added to database
	public static boolean addAccount(Account account) {
		logger.info("In Add account");
		boolean added=false;
		AccountDaoImpl manager= new AccountDaoImpl();
		int id=0;
		//checks if account with username exist, 
		logger.debug("Searching for account using select account by username");
		if( manager.selectAccountByUsername(account.getUsername()) == null) {
			//if username not taken , create account
			logger.debug("Account is inserted into database using insert account");
			id=manager.insertAccount(account);
			if( id>0) {
				added=true;
			}
		}

		
		return added;
	}
}
