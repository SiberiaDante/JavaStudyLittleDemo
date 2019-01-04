package com.dante.demo01;

import com.dante.demo02.ZDPerson;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo02 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring01.xml");
        ZDPerson zdPerson = ctx.getBean(ZDPerson.class);
        System.out.print(zdPerson.toString());
    }
}
