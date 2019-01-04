package com.dante.demoaop08;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * Cglib实现动态代理
 */
public class DynamicProxyCglib implements MethodInterceptor {

    // 被代理对象
    Object targetObject;

    public Object getProxyObject(Object object) {
        this.targetObject = object;
        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setCallback(this);
        //设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //被织入的内容，开始时间
        long start = System.currentTimeMillis();
        lazy();
        //使用反射在目标对象上调用方法并传入参数
        Object result = method.invoke(targetObject, objects);
        //被织入的内容，结束时间
        long time = System.currentTimeMillis() - start;
        System.out.println("共用时:" + time);
        return result;
    }

    //模拟延时
    public void lazy() {
        try {
            int n = (int) new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
