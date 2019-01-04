package com.dante.demoaop09;

public class HelloWorldImpl implements HelloWorld {
    public void printHello() {
        System.out.println("printHello----------HelloWorldImpl------------");
    }

    public void doPrint() {
        System.out.println("doPrint--------HelloWorldImpl--------------");
    }

    @Override
    public String getResult() {
        return "ABC";
    }
}
