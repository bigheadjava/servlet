package com.cheer.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cheer.util.JdbcUtil;

public class AccessCountListener implements ServletContextListener {
	private static final String ATTR_ACCESS_COUNT = "access_count";

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Servlet容器开始启动...");
		int access_count = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select access_count from web_access_count";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				access_count = rs.getInt("access_count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(conn, pst, rs);
		}
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute(ATTR_ACCESS_COUNT, access_count);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Servlet容器开始终止运行...");
		ServletContext ctx = sce.getServletContext();
		int access_count = (Integer) ctx.getAttribute(ATTR_ACCESS_COUNT);

		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update web_access_count set access_count = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, access_count);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(conn, pst, null);
		}
	}

}
