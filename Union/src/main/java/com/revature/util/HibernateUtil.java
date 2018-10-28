package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

//	private static SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	
	
	private static SessionFactory sessionfactory; 
	static {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionfactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	
	public static Session getSession() {

		return sessionfactory.openSession();
	}
	
	
}
