package com.cheer.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletLife extends GenericServlet {

	private int initCount = 0; // 初始化次数

	private int serviceCount = 0; // serice方法调用次数

	private int destroyCount = 0; // 销毁次数

	private String servletName; // Servlet名字

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		servletName = config.getServletName();
		initCount++;
		System.out.println("Servlet: " + servletName + "被初始化了 " + initCount + " 次...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		serviceCount++;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>Servlet 生命周期演示</h1>");
		out.println("<hr>");
		out.println("Servlet: " + servletName + "被初始化了 " + initCount + " 次..." + "<br />");
		out.println("Servlet: " + servletName + "被请求了 " + serviceCount + " 次..." + "<br />");
		out.println("Servlet: " + servletName + "被销毁了 " + destroyCount + " 次..." + "<br />");
	}

	@Override
	public void destroy() {
		destroyCount++;
		System.out.println("Servlet: " + servletName + "被销毁了了 " + destroyCount + " 次..." + "<br />");
	}

}
