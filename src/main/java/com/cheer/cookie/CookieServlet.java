package com.cheer.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="CookieServlet",urlPatterns= {"/CookieServlet"})
public class CookieServlet extends HttpServlet {
	int requestCount = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>添加和遍历Cookie测试</h1><br />");
		out.println("<hr>");
		// 获取请求中所有的cookie
		Cookie[] cookies = req.getCookies();
		// 遍历每个cookie
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				out.println("Cookie Name: " + cookies[i].getName() + "<br/>");
				out.println("Cookie Value: " + cookies[i].getValue() + "<br/>");
				out.println("Cookie Max Age: " + cookies[i].getMaxAge() + "<br/>");
				out.println("<hr>");
			}
		} else {
			out.println("当前客户端没有Cookie...");
		}
		
		// 向客户端写入一个Cookie
		resp.addCookie(new Cookie("CookieName" + requestCount, "CookieValue" + requestCount));
		requestCount ++;
	}
}
