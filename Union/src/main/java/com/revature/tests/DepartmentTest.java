package com.revature.tests;

import com.revature.beans.Department;
import com.revature.dao.DepartmentDaoImpl;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		Department dep = dd.selectDepartmentById(1);
		
		
		
		System.out.println("DELETE");
		dd.deleteDepartment(1);
		
		System.exit(0);
	}

}
