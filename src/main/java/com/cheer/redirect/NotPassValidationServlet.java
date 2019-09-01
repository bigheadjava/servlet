package com.cheer.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NotPassValidationServlet", urlPatterns = { "/NotPassValidationServlet" })
public class NotPassValidationServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		PrintWriter out = resp.getWriter();
		out.println("<h1>对不起，" + userName + "不是admin账户，不能登陆...</h1><br/>");
		out.close();
	}
}
