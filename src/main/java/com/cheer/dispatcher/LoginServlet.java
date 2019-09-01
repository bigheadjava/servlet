package com.cheer.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet3", urlPatterns = { "/login3" })
public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("userPassword");

		String target;
		if ("admin".equals(userName) && "password".equals(password)) {
			target = "LoginSuccess";
		} else {
			target = "LoginFailed";
		}

		ServletContext ctx = getServletContext();
		RequestDispatcher dispatcher = ctx.getNamedDispatcher(target);

		PrintWriter out = resp.getWriter();
		out.println("<h1>转发登陆结果之前...</h1><br/>");
		dispatcher.forward(req, resp); // 请求转发
		out.println("<h1>转发登陆结果之后...</h1><br/>");
	}
}
