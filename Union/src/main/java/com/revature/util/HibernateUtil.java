package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory sessionfactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionfactory.openSession();
	}
	
	
}
