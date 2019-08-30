package com.cheer.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadFileServlet", urlPatterns = "/uploadFile")
@MultipartConfig // 标识该Servlet支持文件上传
public class UploadFileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 将文件设置为纯文本的形式，浏览器在获取到这种文件时并不会对其进行处理
		resp.setContentType("text/plain;charset=utf-8");
		// 获取文件保存路径
		String path = req.getServletContext().getRealPath("/files");

		PrintWriter out = resp.getWriter();

		// 获取正文表单数据，存放在Part集合中
		Collection<Part> parts = req.getParts();

		// 处理正文表单数据的每个子部分
		for (Part part : parts) { // 循环处理上传的文件
			/**
			 * Content-disposition 是 MIME 协议的扩展。
			 */
			String header = part.getHeader("content-disposition");

			// 测试part中的一些API
			out.println("测试Part接口的API:" + "\r\n");
			out.println("getContentType(): " + part.getContentType() + "\r\n");
			out.println("getSize(): " + part.getSize() + "\r\n");
			out.println("getName(): " + part.getName() + "\r\n");
			out.println("getHeader(content-disposition): " + header + "\r\n");

			// 如果子部分是文本域，就显示文本域的名字和值
			if (part.getContentType() == null) {
				String name = part.getName();
				String value = req.getParameter(name);
				out.println(name + ": " + value + "\r\n");
			} else if (part.getName().indexOf("file") != -1) { // 如果子部分是文件域，就开始上传文件
				String fileName = getFileName(header);
				// 把文件写到指定保存路径
				part.write(path + File.separator + fileName);
				out.println("文件在服务器保存路径: " + path + File.separator + fileName + "\r\n");
				out.println(fileName + "的大小为 " + part.getSize() + "byte \r\n");
			}
			out.println("---------------------------------------------------");
		}
	}

	/**
	 * 从一个Part对象的请求头部获取文件名
	 * 
	 * @param header
	 * @return
	 */
	private String getFileName(String header) {
		// 头部内容一般类似格式: form-data; name="file1"; filename="xxx.png"
		String fileName = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		return fileName;
	}
}
