package com.revature.services;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Department;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.DepartmentDaoImpl;

public class DepartmentServices {

	public static List<Department> getAllDepartments(){
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		
		return dd.selectAllDepartment();
	}

	public static Department getDepartmentByAccId(Integer acc_id) {
		Department dep = null;
		
		if (acc_id == null) {
			return dep;
		}
		
		AccountDaoImpl ad = new AccountDaoImpl();
		Account a = ad.selectAccountById(acc_id);
		dep = a.getDep();
		
		return dep;
	}

	public static Department getDepartmentByDepId(Integer dep_id) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		
		return dd.selectDepartmentById(dep_id);
	}

	public static void deleteDepartmentByDepId(Integer dep_id) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		
		dd.deleteDepartment(dep_id);
	}
	
	public static void insertDepartmentWithLead(String dname, Integer lead_id) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		AccountDaoImpl ad = new AccountDaoImpl();
		
		Department d = new Department();
		d.setDname(dname);
		Account a = ad.selectAccountById(lead_id);
		
		if (a != null) {
			dd.insertDepartment(d);
			a.setRole(1);
			a.setDep(d);
		}
	}
}
