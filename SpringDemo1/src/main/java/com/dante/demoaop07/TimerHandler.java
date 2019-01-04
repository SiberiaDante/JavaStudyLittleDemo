package com.dante.demoaop07;

public class TimerHandler {
    public void before() {
        System.out.println("before--------TimerHandler--------");
    }

    public void after() {
        System.out.println("after--------TimerHandler--------");
    }
}
