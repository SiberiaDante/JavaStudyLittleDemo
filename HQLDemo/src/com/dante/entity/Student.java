package com.dante.entity;

import java.util.Date;

public class Student {
	private Integer id;
	private String name;
	private String address;
	private Date birthday;
	private Integer age;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", birthday=" + birthday + ", age="
				+ age + "]";
	}

	public Student(String name, String address, Date birthday, Integer age) {
		super();
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.age = age;
	}

	public Student() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
