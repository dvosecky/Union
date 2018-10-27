package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	public Department selectDepartmentByName(String name) {
		Department dep = null;
		Session session = HibernateUtil.getSession();
		
		try {
			Criteria c = session.createCriteria(Department.class);
			c.add(Restrictions.like("dname", name));
			dep = (Department) c.uniqueResult();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return dep;
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
