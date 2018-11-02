package com.dante.bean;

import java.util.Date;

public class Student {
	private int sid;
	private String name;
	private Date birthday;

	public Student() {
	}

	public Student(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public Student(int sid, String name, Date birthday) {
		super();
		this.sid = sid;
		this.name = name;
		this.birthday = birthday;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
