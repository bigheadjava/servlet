package com.cheer.pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应正文MIME类型和字符编码
		resp.setContentType("text/html;charset=utf-8");
		//获取Printwriter对象, Servlet用它来输出字符串形式的正文数据
		PrintWriter out = resp.getWriter();
		//向响应正文输出信息
		out.println("<h1><font color=\"red\">Hello，这是我的第一个Servlet程序...</font></h1>");
	}
}
