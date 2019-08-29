package com.cheer.load;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("========== MyServlet3 加载完毕 =============");
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>MyServlet3.....</h1>");
		
	}
}
