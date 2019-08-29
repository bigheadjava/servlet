package com.cheer.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextApi extends HttpServlet {
	ServletContext ctx;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ctx = config.getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String att1_0 = (String) ctx.getAttribute("Attribute1");
		ctx.setAttribute("Attribute1", "Attribute1 Vlaue");
		String att1_1 = (String) ctx.getAttribute("Attribute1");
		ctx.removeAttribute("Attribute1");
		String att1_2 = (String) ctx.getAttribute("Attribute1");

		String contextPath = ctx.getContextPath();
		String parameter1 = ctx.getInitParameter("context_param_1");
		String displayName = ctx.getServletContextName();

		String serverInfo = ctx.getServerInfo();
		int majorVersion = ctx.getMajorVersion();
		int minorVersion = ctx.getMinorVersion();
		ctx.log("这是ServletContextApi写入的测试log...");

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>ServletContext API测试</h1>");
		out.println("<hr>");

		out.println("调用setAttribute(\"Attribute1\", \"Attribute1 Vlaue\")之前: " + att1_0 + "<br/>");
		out.println("调用setAttribute(\"Attribute1\", \"Attribute1 Vlaue\")之后: " + att1_1 + "<br/>");
		out.println("调用removeAttribute(\"Attribute1\")之后: " + att1_2 + "<br/>");

		out.println("getContextPath(): " + contextPath + "<br/>");
		out.println("getInitParameter(): " + parameter1 + "<br/>");
		out.println("getServletContextName(): " + displayName + "<br/>");
		out.println("getServerInfo(): " + serverInfo + "<br/>");
		out.println("getMajorVersion(): " + majorVersion + "<br/>");
		out.println("getMinorVersion: " + minorVersion + "<br/>");

	}

}
