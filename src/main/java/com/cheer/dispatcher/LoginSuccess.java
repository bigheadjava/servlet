package com.cheer.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginSuccess", urlPatterns = { "/LoginSuccess3" })
public class LoginSuccess extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1><font color=\"pink\">请求到达登陆成功组件...</font></h1><br/>");
		String userName = req.getParameter("userName");
		out.println("<h1><font color=\"green\">登陆成功，欢迎您" + userName + "</font></h1>");
	}
}
