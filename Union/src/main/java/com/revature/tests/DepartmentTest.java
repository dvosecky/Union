package com.revature.tests;

import java.util.List;

import com.revature.beans.Department;
import com.revature.dao.DepartmentDaoImpl;

public class DepartmentTest {

	public static void main(String[] args) {
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		Department dep = dd.selectDepartmentById(1);
		List<Department> deps = null;
		
		System.out.println("SELECT ALL");
		deps = dd.selectAllDepartment();
		for (Department d : deps) {
			System.out.println(d);
		}
		
		//System.out.println("DELETE");
		//dd.deleteDepartment(1);
		
		System.exit(0);
	}

}
