package com.cheer.cross;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AccessOtherWebServlet", urlPatterns = { "/AccessOtherWebServlet" })
public class AccessOtherWebServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		ServletContext otherCtx = ctx.getContext("/jsp-web");
		RequestDispatcher dispatcher = otherCtx.getRequestDispatcher("/firstServlet");
		dispatcher.forward(req, resp);
	}
}
