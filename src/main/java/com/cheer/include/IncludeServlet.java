package com.cheer.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="IncludeServlet",urlPatterns= {"/IncludeServlet"})
public class IncludeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ServletContext ctx = getServletContext();
		RequestDispatcher dispatcher_1 = ctx.getRequestDispatcher("/html/include/header.html");
		RequestDispatcher dispatcher_2 = ctx.getRequestDispatcher("/ContentServlet");
		RequestDispatcher dispatcher_3 = ctx.getRequestDispatcher("/html/include/footer.html");
		dispatcher_1.include(req, resp);
		out.println("<hr>");
		dispatcher_2.include(req, resp);
		out.println("<hr>");
		dispatcher_3.include(req, resp);
		out.close();
	}
}
