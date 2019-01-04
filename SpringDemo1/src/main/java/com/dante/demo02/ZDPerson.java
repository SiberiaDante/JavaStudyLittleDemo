package com.dante.demo02;

public class ZDPerson extends Person {

    private int age;

    public ZDPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ZDPerson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
