package com.dante.demo01;

import com.dante.demo03.Address;
import com.dante.demo03.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo03 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring01.xml");
        Address tianJin = ctx.getBean("tianJin", Address.class);
        System.out.println(tianJin);
        Person tom = ctx.getBean("tom", Person.class);
        System.out.println(tom);
        Person jack = ctx.getBean("jack", Person.class);
        System.out.println(jack);
        Person jack1 = ctx.getBean("jack", Person.class);
        System.out.println("jack==jack1:"+(jack==jack1));

    }
}
