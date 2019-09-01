package com.cheer.annotation.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cheer.util.DateUtil;
import com.cheer.util.JdbcUtil;

@WebListener
public class WebServerTimeLogListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into web_server_time_log(start_date) values(?);";
			pst = conn.prepareStatement(sql);
			pst.setTimestamp(1, getCurrentTimestamp());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(conn, pst, null);
		}
	}

	private Timestamp getCurrentTimestamp() throws ParseException {
		Date utilDate = DateUtil.getCurrentDate(DateUtil.DATE_TIME_PATTERN);
		Timestamp ts = new Timestamp(utilDate.getTime());
		return ts;
	}

	public void contextDestroyed(ServletContextEvent sce) {

		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update web_server_time_log set shutdown_date = ? order by start_date desc limit 1";
			pst = conn.prepareStatement(sql);
			pst.setTimestamp(1, getCurrentTimestamp());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResource(conn, pst, null);
		}
	}

}
