package com.dante.demo1;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dante.util.HibernateUtil;

class TestDemo1 {

	private Session session;

	@BeforeEach
	void before() {
		session = HibernateUtil.openSession();
		session.beginTransaction();
	}

	@Test
	void testSaveData() {

		Customer c1 = new Customer();
		c1.setName("ZhangSan");

		Orders o1 = new Orders();
		o1.setAddress("BJ");
		o1.setMoney(222.22);

		Orders o2 = new Orders();
		o2.setAddress("TJ");
		o2.setMoney(333.22);

		c1.getOrders().add(o1);
		c1.getOrders().add(o2);

		o1.setCustomer(c1);
		o2.setCustomer(c1);

		session.save(c1);
		// session.save(o1);
		// session.save(o2);

		session.getTransaction().commit();
		session.close();
		// HibernateUtil.getSessionFactory().close();
	}

	@Test
	void testDeleteOrder() {
		Customer customer = session.get(Customer.class, 2);
		// Orders orders = session.get(Orders.class, 2);
		// customer.getOrders().remove(orders);
		session.delete(customer);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	void testUpdateCustomer() {
		Customer customer = session.get(Customer.class, 3);
		// Orders orders = session.get(Orders.class, 2);
		// customer.getOrders().remove(orders);
		customer.setName("ZhangSanFeng1");
		session.update(customer);

		session.getTransaction().commit();
		session.close();
	}

}