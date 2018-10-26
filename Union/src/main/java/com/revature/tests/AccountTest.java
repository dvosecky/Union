package com.revature.tests;

import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.DepartmentDaoImpl;

public class AccountTest {
	public static void main(String []args) {
		Account a = null;
		List<Account> as = null;
		AccountDaoImpl ad = new AccountDaoImpl();
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		
		System.out.println("SELECT ALL");
		as = ad.selectAllAccount();
		outputList(as);
		
		System.out.println("SELECT BY ID");
		a = ad.selectAccountById(1);
		System.out.println(a);
		
		System.out.println("SELECT BY DEP");
		as = ad.selectAccountsByDep(dd.selectDepartmentById(1));
		outputList(as);
		
		System.out.println("INSERT");
		a = new Account(5, "c", "c", "c", "c", dd.selectDepartmentById(1), 0);
		ad.insertAccount(a);
		System.out.println("inserted " + a);
		
		System.out.println("DELETE");
		ad.deleteAccount(1);
		
		System.exit(0);
	}
	
	public static void outputList(List<Account> as) {
		for (Account a : as) {
			System.out.println(a);
		}
	}
}
