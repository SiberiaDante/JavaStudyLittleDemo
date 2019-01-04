package com.dante.demo01;

import com.dante.demo06.DBUtils;
import com.dante.demo06.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo06 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring06.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("zd");
        System.out.println(userDAO.dbUtils());
    }
}
