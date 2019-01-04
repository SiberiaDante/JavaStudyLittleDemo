package com.dante.a_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class UserServiceImpl
		implements IUserService, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	public UserServiceImpl() {
		System.err.println("------------1.实例化----------------");
	}

	public void setName(String name) {
		System.err.println("------------2.设置属性----------------");
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		System.err.println("------------3.设置 Bean 的 Name ----------------");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.err.println("------------4.执行 ApplicationContext ----------------");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("------------6.执行 InitializingBean afterPropertiesSet ----------------");
	}

	public void myInit() {
		System.err.println("------------7.执行 初始化 ----------------");
	}

	@Override
	public void get() {
		System.err.println("------------9.业务逻辑 ----------------");
	}

	@Override
	public void destroy() throws Exception {
		System.err.println("------------10.DisposableBean destroy ----------------");
	}

	public void myDestroy() {
		System.err.println("------------11.执行 销毁 ----------------");
	}

}
