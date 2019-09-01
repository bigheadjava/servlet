package com.cheer.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateCookieServlet", urlPatterns = { "/UpdateCookieServlet" })
public class UpdateCookieServlet extends HttpServlet {
	Cookie cookie = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>修改和删除Cookie测试</h1><br />");
		out.println("<hr>");
		// 获取请求中所有的cookie
		Cookie[] cookies = req.getCookies();
		// 遍历每个cookie
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName1")) {
					cookie = cookies[i];
					out.println("Cookie Name: " + cookies[i].getName() + "<br/>");
					out.println("Cookie Value: " + cookies[i].getValue() + "<br/>");
					out.println("Cookie Max Age: " + cookies[i].getMaxAge() + "<br/>");
				}
			}
		} else {
			out.println("当前客户端没有Cookie...");
		}
		if (cookie == null) {
			// 向客户端写入一个Cookie
			cookie = new Cookie("userName1", "zhangsan");
			cookie.setMaxAge(60 * 60);
			resp.addCookie(cookie);
		} else if ("zhangsan".equals(cookie.getValue())) {
			// 修改Cookie
			cookie.setValue("lisi");
			resp.addCookie(cookie);
		} else if ("lisi".equals(cookie.getValue())) {
			// 删除Cookie
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
	}
}
