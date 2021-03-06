package com.dante.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dante.entity.Student;
import com.dante.util.HibUtils;

class TestHQL {

	private Session session;
	private Transaction transaction;

	@BeforeEach
	void before() {
		session = HibUtils.openSession();
		transaction = session.beginTransaction();
	}

	@Test
	void saveStudent() {
		Student s1 = new Student("ZhangSan2", "BeiJing", new Date(), 18);
		Student s2 = new Student("LiSi12", "BeiJing", new Date(), 28);
		session.save(s1);
		session.save(s2);
	}

	@Test
	void queryStudent() {
		String hql = "FROM Student";
		String hql1 = "SELECT s.name From Student AS s";
		String hql2 = "FROM Student s WHERE s.age >= 20";
		String hql3 = "FROM Student s WHERE s.age>=20 ORDER BY s.age DESC";
		String hql4 = "FROM Student s WHERE s.age>=20 ORDER BY s.age DESC,s.name DESC";
		String hql5 = "SELECT SUM(s.age),s.name FROM Student AS s GROUP BY s.name";
		String hql6 = "FROM Student s WHERE s.id = :inputId";

		String hql7 = "UPDATE Student AS s SET s.age = :inputAge WHERE s.id=:inputId";
		String hql8 = "DELETE FROM Student WHERE ID=:inputId";

		String hql9 = "INSERT INTO Student (name,address,birthday,age) values (?,?,?,?)";
		String hql10 = "INSERT INTO Student (name,address,birthday,age) SELECT name,address,birthday,age FROM Student";
		Query query = session.createQuery(hql);
		// query.setParameter("inputId", 1);
		// query.setParameter(0, "WangWu");
		// query.setParameter(1, "ShangHai");
		// query.setParameter(2, "2018-08-09");
		// query.setParameter(3, 90);
		// int result = query.executeUpdate();
		// System.out.println(result);
		List<?> students = query.list();
		for (Object stu : students) {
			System.out.println(stu.toString());
		}
	}

	@Test
	void queryByPage() {
		String hql = "FROM Student";
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(2);
		List<?> students = query.list();
		for (Object stu : students) {
			System.out.println(stu.toString());
		}
	}

	@AfterEach
	void afterAll() {
		transaction.commit();
		System.out.println("----");
		session.close();
	}
}
