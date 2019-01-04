package com.dante.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> sessions = context.getSession();
		if (sessions.get("username") != null) {
			System.out.println("------------:"+sessions.get("username"));
			return invocation.invoke();
		} else {
			return (String) sessions.get("loginError");
		}
	}
}
