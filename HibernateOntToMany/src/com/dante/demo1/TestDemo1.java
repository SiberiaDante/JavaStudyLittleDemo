package com.dante.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dante.util.HibernateUtil;

class TestDemo1 {

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	@BeforeEach
	void before() {
		System.out.println("----------before---------");
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}

	@Test
	void testSaveData() {

		Customer c1 = new Customer();
		c1.setName("ZhangSan-" + System.currentTimeMillis());

		Orders o1 = new Orders();
		o1.setAddress("BJ-" + System.currentTimeMillis());
		o1.setMoney(222.22);

		Orders o2 = new Orders();
		o2.setAddress("TJ-" + System.currentTimeMillis());
		o2.setMoney(333.22);

		c1.getOrders().add(o1);
		c1.getOrders().add(o2);

		o1.setCustomer(c1);
		o2.setCustomer(c1);

//		session.save(c1);
		 session.save(o1);
		 session.save(o2);

		transaction.commit();
		session.close();
		// HibernateUtil.getSessionFactory().close();
	}

	@Test
	void testDeleteOrder() {
		Customer customer = session.get(Customer.class, 6);
		/**
		 * delete customer 同时删除对应的 orders，需要在set 中配置 cascade="delete"
		 */
//		session.delete(customer);

		/**
		 * 删除订单中的一个订单3的同时，从客户6的表中移除改订单
		 */
		Orders orders = session.get(Orders.class, 3);
		customer.getOrders().remove(orders);
		
		transaction.commit();
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

	@AfterEach
	void testAfter() {
		factory.close();
	}
}
