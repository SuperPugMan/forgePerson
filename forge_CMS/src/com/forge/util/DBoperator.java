package com.forge.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBoperator {
	protected static Connection conn = null;
	protected static PreparedStatement pstmt = null;
	protected static ResultSet rs = null;

	/*
	 * 关闭资源
	 */
	protected static void closeConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 获取连接
	 */
	@SuppressWarnings("unused")
	protected static boolean getConnection() throws ClassNotFoundException,
			SQLException {
/*		try {
			ConfigSingTon instance = ConfigSingTon.getInstance();
			Class.forName(ConfigSingTon.getInstance().getValue("driver"));
			conn = DriverManager.getConnection(instance.getValue("url"),
					instance.getValue("userName"),
					instance.getValue("passWord"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
*/	
		try {
			//初始化上下文获取Tomcat容器
			Context con=new InitialContext();
			//通过数据源配置中的name属性获取指定的数据源
			DataSource  ds = (DataSource) con.lookup("java:comp/env/jdbc/forge");
			//从连接池中获取链接
			conn = ds.getConnection();
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/*
	 * 增删改操作
	 */
	public static int excuteUpdate(String sql, Object... param)
			throws ClassNotFoundException, SQLException {
		int rowNum = 0;
		if (getConnection()) {
			pstmt = conn.prepareStatement(sql);
			if (param.length == 0) {
				pstmt.setObject(1, param[0]);
			} else {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}

		}
		String sqlSet = "SET FOREIGN_KEY_CHECKS=0";
		pstmt.execute(sqlSet);
		rowNum = pstmt.executeUpdate();
		closeConnection();
		return rowNum;
	}

	/*
	 * 查询操作
	 */
	public static ResultSet excuteQuery(String sql, Object... param)
			throws ClassNotFoundException, SQLException {
		if (getConnection()) {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
		}
		rs = pstmt.executeQuery();
		return rs;
	}

}
