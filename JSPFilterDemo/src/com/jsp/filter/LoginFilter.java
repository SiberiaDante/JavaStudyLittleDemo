package com.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	/**
	 * 
	 * @param filterConfig
	 *            可以读取web.xml中的过滤参数
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter.super.init(filterConfig);
		String testParam = filterConfig.getInitParameter("test_param");
		System.out.println("----------init---------" + testParam);
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 *            可以将请求传递给下一个过滤器，或利用转发、重定向将请求转发到其他资源
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String remoteAddr = arg0.getRemoteAddr();

		System.out.println("----------doFilter---------");
	}

	/**
	 * 释放资源等
	 */
	@Override
	public void destroy() {
		// Filter.super.destroy();
		System.out.println("----------destroy---------");
	}

}
