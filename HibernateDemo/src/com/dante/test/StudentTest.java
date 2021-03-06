package com.dante.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dante.bean.Student;

class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@BeforeEach
	public void init() {
		Configuration config = new Configuration().configure();
		// ServiceRegistry serviceRegistry = new
		// StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// sessionFactory = config.buildSessionFactory(serviceRegistry);
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@AfterEach
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testSaveStudents() {
		Student student = new Student("Dante", new Date());
		Student student1 = new Student(20, "Dante", new Date());
		if (session != null) {
			session.save(student);
			session.save(student1);
		}
	}

}
