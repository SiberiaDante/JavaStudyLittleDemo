package com.dante.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private String name;

	@Override
	public String execute() throws Exception {
		System.out.println("-----------执行action-----------");
		// return super.execute();
		if (name.equals(SUCCESS)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String getName() {
		return name;
	}

	public void SUCCESS(String name) {
		this.name = name;
	}

	public String add() {
		return SUCCESS;
	}

}
