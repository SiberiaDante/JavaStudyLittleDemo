package com.dante.demo03;

public class Student extends Person {
    private int age;

    public Student(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
