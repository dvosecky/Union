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

	public static boolean deleteDepartmentByDepId(Integer dep_id) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		boolean result = false;
		
		if (dd.selectDepartmentById(dep_id) != null) {
			dd.deleteDepartment(dep_id);
			result = true;
		}
		return result;
	}
	
	public static boolean insertDepartmentWithLead(String dname) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		Department d = dd.selectDepartmentByName(dname);
		if (d != null) {
			return false;
		}
		
		d = new Department();
		d.setDname(dname);
		dd.insertDepartment(d);
		return true;
	}
}
