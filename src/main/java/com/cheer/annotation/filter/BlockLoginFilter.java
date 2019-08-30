package com.cheer.annotation.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "BlockLoginFilter", urlPatterns = {
		"/LoginServlet1" }, dispatcherTypes = DispatcherType.REQUEST, initParams = {
				@WebInitParam(name = "block_1", value = "zhangsan"), @WebInitParam(name = "block_2", value = "lisi"),
				@WebInitParam(name = "block_3", value = "wangwu") })
public class BlockLoginFilter implements Filter {
	String b1;
	String b2;
	String b3;

	public void init(FilterConfig filterConfig) throws ServletException {
		b1 = filterConfig.getInitParameter("block_1");
		b2 = filterConfig.getInitParameter("block_2");
		b3 = filterConfig.getInitParameter("block_3");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean flag = false;
		String userName = request.getParameter("userName");
		if (b1.equals(userName) || b2.equals(userName) || b3.equals(userName)) {
			flag = true;
		}

		if (flag) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h1><font color=\"red\">对不起，您的账号已经被禁用，请联系客服人员解禁!</font></h1>");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		System.out.println("销毁过滤器BlockLoginFilter...");
	}

}
