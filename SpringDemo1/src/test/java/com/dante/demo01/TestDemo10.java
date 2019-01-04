package com.dante.demo01;

import com.dante.demojdbc10.model.Customer;
import com.dante.demojdbc10.model.dao.CustomerDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo10 {
    ApplicationContext ctx;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        CustomerDAO customerDAO = ctx.getBean("customerDAO", CustomerDAO.class);
        Customer customer = new Customer();
        customer.setName("AAAA");
        customer.setAge(20);
        customerDAO.insert(customer);
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
    }

    @Test
    public void testDemoTemplate() {
        CustomerDAO customerDAO = ctx.getBean("customerTemplate", CustomerDAO.class);
        Customer customer = new Customer();
        customer.setName("AAAA");
        customer.setAge(20);
        customerDAO.insert(customer);
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
    }

    @Test
    public void testDemoSupportTemplate() {
        CustomerDAO customerDAO = ctx.getBean("customerSupportTemplate", CustomerDAO.class);
//        Customer customer = new Customer();
//        customer.setName("BBBBB");
//        customer.setAge(20);
//        customerDAO.insert(customer);
        Customer customer1 = customerDAO.findByCustomerId(9);
        System.out.println(customer1);
    }
}
