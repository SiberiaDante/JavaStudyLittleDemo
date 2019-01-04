package com.dante.struts2.bean;

import java.util.List;

public class User {
	private String username;
	private String password;
	private List<String> favourite;
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
	public List<String> getFavourite() {
		return favourite;
	}
	public void setFavourite(List<String> favourite) {
		this.favourite = favourite;
	}

}
