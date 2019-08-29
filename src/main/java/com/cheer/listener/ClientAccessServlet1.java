package com.cheer.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientAccessServlet1 extends HttpServlet {
	ServletContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ctx = config.getServletContext();
		System.out.println("ClientAccessServlet1初始化...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = (Integer) ctx.getAttribute("access_count");
		ctx.setAttribute("access_count", ++count);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("欢迎您，您是本站第 <font color=\"red\">" + count + "</font> 位访问者!");
	}
	
	@Override
	public void destroy() {
		System.out.println("ClientAccessServlet1销毁...");
		super.destroy();
	}
}
