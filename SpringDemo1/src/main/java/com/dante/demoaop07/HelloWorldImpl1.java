package com.dante.demoaop07;

public class HelloWorldImpl1 implements HelloWorld {
    public void printHello() {
        System.out.println("printHello----------HelloWorldImpl1------------");
    }

    public void doPrint() {
        System.out.println("doPrint--------HelloWorldImpl1--------------");
    }
}
