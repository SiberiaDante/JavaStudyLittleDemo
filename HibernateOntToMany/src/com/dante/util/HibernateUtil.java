package com.dante.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure();
		return config.buildSessionFactory();
	}
}
