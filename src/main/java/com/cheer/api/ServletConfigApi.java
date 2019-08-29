package com.cheer.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigApi extends HttpServlet {
	String parameter_1;
	String servletName;

	@Override
	public void init(ServletConfig config) throws ServletException {
		parameter_1 = config.getInitParameter("Parameter_1");
		servletName = config.getServletName();
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>ServletConfig API测试</h1>");
		out.println("<hr>");
		out.println("getInitParameter(parameter_1): " + parameter_1 + "<br/>");
		out.println("getServletName(): " + servletName + "<br/>");
	}
}
