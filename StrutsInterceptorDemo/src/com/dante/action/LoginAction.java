package com.dante.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private Map<String, Object> session;

	public String login() {
		if (session.get("username") != null) {
			return SUCCESS;
		}
		if ("admin".equals(username) && "123".equals(password)) {
			session.put("username", username);
			return SUCCESS;
		} else {
			session.put("loginError", "un login");
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
