package com.cheer.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckUserNameServlet", urlPatterns = { "/CheckUserNameServlet" })
public class CheckUserNameServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		PrintWriter out = resp.getWriter();
		out.println("<h1>准备重定向...</h1><br/>");
		if ("admin".equals(userName)) {
			resp.sendRedirect("/servlet/PassValidationServlet");
		} else {
			resp.sendRedirect("/servlet/NotPassValidationServlet");
		}
		out.println("<h1>重定向完毕...</h1><br/>");
		
		out.close();
	}
}
