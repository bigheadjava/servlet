package com.cheer.download;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadFileServlet", urlPatterns = { "/downloadFile" }, initParams = {
		@WebInitParam(name = "fileName", value = "1.png") })
public class DownloadFileServlet extends HttpServlet {
	ServletConfig cfg;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cfg = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OutputStream out; // 输出响应正文的输出流
		InputStream in; // 读取本地文件的输入流
		String fileName = cfg.getInitParameter("fileName");

		// 获取读取本地文件的输入流
		in = getServletContext().getResourceAsStream("/files/" + fileName);
		int length = in.available();
		// 设置响应正文的MIME类型
		resp.setContentType("application/forcedownload");
		resp.setHeader("Content-Length", String.valueOf(length));
		resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\" ");
		// 把服务端文件发送给客户端
		out = resp.getOutputStream();
		int byteRead = 0;
		byte[] buffer = new byte[512];
		while ((byteRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, byteRead);
		}
		in.close();
		out.close();
	}
}
