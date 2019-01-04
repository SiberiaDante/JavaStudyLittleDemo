package com.dante.demo01;

import com.dante.demoaop07.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo07 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springaop.xml");
        HelloWorld hello1 = ctx.getBean("hello1", HelloWorld.class);
        hello1.printHello();
        hello1.doPrint();
    }
}
