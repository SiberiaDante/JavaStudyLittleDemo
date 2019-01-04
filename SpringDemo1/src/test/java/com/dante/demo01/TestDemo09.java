package com.dante.demo01;

import com.dante.demoaop09.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo09 {

    @Test
    public void testDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springaop09.xml");
        HelloWorld hello1 = ctx.getBean("hello09", HelloWorld.class);
        hello1.printHello();
        hello1.doPrint();
        hello1.getResult();
    }
}
