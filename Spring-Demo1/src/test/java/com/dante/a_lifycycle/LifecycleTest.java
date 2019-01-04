package com.dante.a_lifycycle;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dante.a_lifecycle.UserServiceImpl;

public class LifecycleTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		UserServiceImpl service=context.getBean(UserServiceImpl.class);
		service.get();
//		service.setName("SiberiaDante");
		context.close();
	}

}
