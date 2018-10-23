package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Department;
import com.revature.util.HibernateUtil;

public class DepartmentDaoImpl {

	public Integer insertDepartment( Department department) {
		Integer id=null;
		Session session = HibernateUtil.getSession();
		Transaction tx= null;
		
		try {
			tx=session.beginTransaction();
			id=(Integer)session.save(department);
			tx.commit();
		}catch( HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return id;
		
	}


	public void deleteDepartment(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.delete(session.get(Department.class, id));
			tx.commit();
		}catch(HibernateException e) {

			e.printStackTrace();
		}finally {
			session.close();
		}		
		
	}


	@SuppressWarnings("unchecked")
	public List<Department> selectAllDepartment(){
		List<Department> departments=null;
		Session session = HibernateUtil.getSession();
		
		try {
		departments = session.createQuery("FROM Department").list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return departments;
		
	}

}
