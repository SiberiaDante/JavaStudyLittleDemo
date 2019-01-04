package com.dante;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dante.service.InjectService;

public class TestMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		InjectService service = (InjectService) context.getBean("injectService");
		service.save("Dante");
	}

}
