package com.jsp.dao;

import com.jsp.bean.LoginUserBean;

public class UserBeanDao {

	public boolean loginSuccess(LoginUserBean userbean) {
		return "admin".equals(userbean.getUsername()) && "123456".equals(userbean.getPassword());
	}
}
