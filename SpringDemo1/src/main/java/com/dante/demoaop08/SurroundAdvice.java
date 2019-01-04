package com.dante.demoaop08;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SurroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //前置横切逻辑
        System.out.println("方法" + methodInvocation.getMethod() + " 被调用在对象" + methodInvocation.getThis() + "上，参数 " + methodInvocation.getArguments());
        //方法调用
        Object ret = methodInvocation.proceed();
        //后置横切逻辑
        System.out.println("返回值：" + ret);
        return ret;
    }
}
