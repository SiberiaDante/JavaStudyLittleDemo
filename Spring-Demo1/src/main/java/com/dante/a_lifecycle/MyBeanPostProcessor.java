package com.dante.a_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.err.println("------------5.初始化  postProcessBeforeInitialization ----------------:"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.err.println("------------8.postProcessAfterInitialization ----------------:" + beanName);
		// if ("lifecycle".equals(beanName)) {
		if (beanName.equals("lifecycle")) {
//			Object proxyOjb = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),new InvocationHandler() {
//						@Override
//						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//							System.err.println("start------------------:" + System.currentTimeMillis());
//							Object invoke = method.invoke(proxy, args);
//							System.err.println("end--------------------:" + System.currentTimeMillis());
//							return invoke;
//						}
//					});
//			return proxyOjb;
		}
		return bean;
	}
}
