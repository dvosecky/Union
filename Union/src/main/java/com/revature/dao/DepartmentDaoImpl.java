package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Department;
import com.revature.util.HibernateUtil;

public class DepartmentDaoImpl {
	public Department selectDepartmentById(Integer id) {
		Department dep = null;
		Session session= HibernateUtil.getSession();
		
		try {
		dep = (Department) session.get(Department.class, id);
		}catch( HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return dep;
	}
	
	
	@SuppressWarnings("unchecked")
	public void criteriaGetAll() {
		Session session = HibernateUtil.getSession();
		List<Department> deps = null;

		try {
			deps = session.createCriteria("FROM Department").list();

			
		}catch(Exception e) {//atch( HibernateException e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}

		for(Department a : deps) {
			System.out.println(a);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> selectAllDepartment(){
		List<Department> deps = null;
		Session session = HibernateUtil.getSession();
		
		try {
		deps = session.createQuery("FROM department").list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return deps;
		
	}
	
	public Integer insertDepartment(Department dep){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = session.beginTransaction();
			id = (Integer)session.save(dep);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		
		return id;
	}
}
