package com.cheer.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginFailed", urlPatterns = { "/LoginFailed3" })
public class LoginFailed extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1><font color=\"pink\">请求到达登陆失败组件...</font></h1><br/>");
		out.println("<h1><font color=\"red\">登陆失败! 请重新输入用户名和密码!</font></h1>");
	}
}
