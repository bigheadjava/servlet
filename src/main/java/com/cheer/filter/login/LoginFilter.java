package com.cheer.filter.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {
	String[] blockAccountArray;

	public void init(FilterConfig filterConfig) throws ServletException {
		String blockAccounts = filterConfig.getInitParameter("blockAccounts");
		if(blockAccounts != null && !blockAccounts.equals("")) {
			blockAccountArray = blockAccounts.split(";");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean flag = false;
		if(blockAccountArray != null) {
			String userName = request.getParameter("userName");
			if(blockAccountArray != null && userName != null) {
				for(int i = 0; i < blockAccountArray.length; i++) {
					if(blockAccountArray[i].equals(userName)) {
						flag = true;
						break;
					}
				}
			}
		}
		if(flag) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h1><font color=\"red\">对不起，您的账号已经被禁用，请联系客服人员解禁!</font></h1>");
		}else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		System.out.println("销毁过滤器LoginFilter...");
	}

}
