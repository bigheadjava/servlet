package com.cheer.filter.cascade;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("执行MyFilter2中的doFilter中...");
		chain.doFilter(request, response);
		System.out.println("执行MyFilter2中的doFilter完毕...");
	}

	public void destroy() {

	}

}
