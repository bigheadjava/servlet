package com.cheer.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestApi extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contentLength = req.getContentLength();
		String conentType = req.getContentType();
		String localName = req.getLocalName();
		String localAddress = req.getLocalAddr();
		int localPort = req.getLocalPort();
		String protocol = req.getProtocol();
		String remoteHost = req.getRemoteHost();
		String remoteAddress = req.getRemoteAddr();
		int remotePort = req.getRemotePort();
		String attribute1_0 = (String) req.getAttribute("attribute1");
		req.setAttribute("attribute1", "属性1的值");
		String attribute1_1 = (String) req.getAttribute("attribute1");
		req.removeAttribute("attribute1");
		String attribute1_2 = (String) req.getAttribute("attribute1");
		
		String contextPath = req.getContextPath();
		Enumeration header = req.getHeaderNames();
		String requestMethod = req.getMethod();
		String requestURI = req.getRequestURI();
		String queryString = req.getQueryString();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>HttpServletRequest API测试</h1>");
		out.println("<hr>");
		out.println("getContentLength(): " + contentLength + "<br/>");
		out.println("getContentType(): " + conentType + "<br/>");
		
		out.println("getLocalName(): " + localName + "<br/>");
		out.println("getLocalAddr(): " + localAddress + "<br/>");
		out.println("getLocalPort(): " + localPort + "<br/>");
		out.println("getProtocol(): " + protocol + "<br/>");
		out.println("getRemoteHost(): " + remoteHost + "<br/>");
		out.println("getRemoteAddr(): " + remoteAddress + "<br/>");
		out.println("getRemotePort(): " + remotePort + "<br/>");
		out.println("getAttribute(set Attribute attribute1 之前获取attribute1的值) : " + attribute1_0 + "<br/>");
		out.println("getAttribute(set Attribute attribute1 之后获取attribute1的值) : " + attribute1_1 + "<br/>");
		out.println("removeAttribute(remove Attribute attribute1 之后获取attribute1的值) : " + attribute1_2 + "<br/>");
		
		out.println("getContextPath(): " + contextPath + "<br/>");
		while(header.hasMoreElements()) {
			out.println("getHeaderNames(): " + header.nextElement().toString() + "<br/>");
		}
		out.println("getMethod(): " + requestMethod + "<br/>");
		out.println("getRequestURI(): " + requestURI + "<br/>");
		out.println("getQueryString(): " + queryString + "<br/>");
		
	}
}
