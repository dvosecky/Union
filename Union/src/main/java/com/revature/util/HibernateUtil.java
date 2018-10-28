package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sessionfactory.openSession();
	}
	
	
}
