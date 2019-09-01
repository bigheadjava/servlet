package com.cheer.sync;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="PrintUserNameServlet", urlPatterns= {"/PrintUserNameServlet"})
public class PrintUserNameServlet extends HttpServlet {
	
	String userName;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		userName = req.getParameter("userName");
		try {
			Thread.sleep(5000); //休眠5秒，模拟并发访问
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		out.println("<h1>User Name is: " + userName + " </h1>");
		out.close();
	}
}
