package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Department;
import com.revature.util.HibernateUtil;

public class DepartmentDaoImpl {
	public static final Logger logger = Logger.getLogger(DepartmentDaoImpl.class);
	
	//Retrieves department by department id
	public Department selectDepartmentById(Integer id) {
		logger.info("In Select Department By Id");
		Department dep = null;
		Session session= HibernateUtil.getSession();
		
		try {
		//retrieve department using session get
		logger.debug("Retrieves Department using id with session get");
		dep = (Department) session.get(Department.class, id);
		}catch( HibernateException e) {
		logger.error("Exception found in transaction");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return dep;
	}
	
	//Returns department by department name
	public Department selectDepartmentByName(String name) {
		logger.info("In Select Department By Department Name");
		Department dep = null;
		Session session = HibernateUtil.getSession();
		
		try {
			//uses criteria returns deparment by name
			logger.debug("Returns department using department name");
			Criteria c = session.createCriteria(Department.class);
			c.add(Restrictions.like("dname", name));
			dep = (Department) c.uniqueResult();
		}
		catch (Exception e) {
			logger.error("Exception in transaction found");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return dep;
	}
	
	//Returns a list of departments
	@SuppressWarnings("unchecked")
	public List<Department> selectAllDepartment(){
		logger.info("In Select All Department");
		List<Department> deps = null;
		Session session = HibernateUtil.getSession();
		
		try {
		//returns a list of departments 
		logger.debug("A List of department is return using session query");
		deps = session.createQuery("FROM Department").list();
		}catch(Exception e) {
		logger.error("Exception found in transaction");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return deps;
		
	}
	
	//Deletes department using department id
	public void deleteDepartment(Integer id) {
		logger.info("In Delete Department");
		Session session = HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			//Deletes a department using session delete
			logger.debug("Deletes a department using session delete");
			tx=session.beginTransaction();
			session.delete(session.get(Department.class, id));
			tx.commit();
		}catch(HibernateException e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
		}finally {
			session.close();
		}		
		
	}
	
	//Insert a department into db and returns the department id if successful
	public Integer insertDepartment(Department dep){
		logger.info("In Insert Department");
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			//a department is inserted into db with session save
			logger.debug("Department is inserted into database with session save");
			tx = session.beginTransaction();
			id = (Integer)session.save(dep);
			tx.commit();
		} catch (HibernateException e) {
			logger.error("Exception is found in transaction");
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		
		return id;
	}
}
