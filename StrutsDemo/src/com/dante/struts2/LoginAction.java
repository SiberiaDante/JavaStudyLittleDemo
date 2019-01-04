package com.dante.struts2;

import com.dante.struts2.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private User user;

	@Override
	public String execute() throws Exception {
		System.out.println("---username---" + user.getUsername() + "---password---" + user.getPassword());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void validate() {
		if (user.getUsername() == null || "".equals(user.getUsername())) {
			this.addFieldError("username", "username cann't be null");
		}
		
//		if (user.getPassword() == null || "".equals(user.getPassword())) {
//			this.addFieldError("passwrod", "passwrod cann't be null");
//		}
	}

}
