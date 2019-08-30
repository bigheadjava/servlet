package com.cheer.annotation.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AnnoServlet", loadOnStartup = 1, urlPatterns = { "/AnnoServlet1", "/AnnoServlet2" }, initParams = {
		@WebInitParam(name = "param1", value = "param1 value"),
		@WebInitParam(name = "param2", value = "param2 value") })
public class AnnoServlet extends HttpServlet {
	ServletConfig cfg;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cfg = config;
		System.out.println("AnnoServlet初始化...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String p1 = cfg.getInitParameter("param1");
		String p2 = cfg.getInitParameter("param2");
		String servletName = cfg.getServletName();
		PrintWriter out = resp.getWriter();
		out.println("<h1>Annotation方式配置Servlet测试</h1>" + "<br/>");
		out.println("<hr>");
		out.println(servletName + "的param1: " + p1 + "<br/>");
		out.println(servletName + "的param2: " + p2 + "<br/>");
	}
}
