package com.dante.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dante.service.InjectService;

public class Demo1Test {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		InjectService service = (InjectService) context.getBean("injectService");
		service.save("Dante");
	}

}
