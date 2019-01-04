package com.dante.demoaop09;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TimerHandler {
    @Before("execution(* com.dante.demoaop09.HelloWorld.doPrint())")
    public void before() {
        System.out.println("before--------TimerHandler--------");
    }

    @After("execution(* com.dante.demoaop09.HelloWorld.doPrint())")
    public void after() {
        System.out.println("after--------TimerHandler--------");
    }

    @Around("execution(* com.dante.demoaop09.HelloWorld.doPrint())")
    public void around(ProceedingJoinPoint joinYiibai) {
        System.out.println("around--------------TimerHandler----------------" + joinYiibai.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.dante.demoaop09.HelloWorld.getResult())", returning = "result")
    public void afterReturning(JoinPoint joinYiibai, Object result) {
        System.out.println("afterReturning----------TimerHandler-------------result:" + result + "---" + joinYiibai.getSignature().getName());
    }
}
