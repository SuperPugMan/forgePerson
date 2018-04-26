package com.forge.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
	protected static Connection conn=null;
	protected static PreparedStatement stmt=null;
	protected static ResultSet rs = null;
	//获取连接
	public static boolean connection() throws ClassNotFoundException,SQLException {
		try {
			Class.forName(ConfigManager.getInstance().getValue("driver"));
			conn=DriverManager.getConnection(ConfigManager.getInstance().getValue("url"),ConfigManager.getInstance().getValue("userName"),ConfigManager.getInstance().getValue("passWord"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//释放资源
	public static void closeresource() {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * 增删改
	 */
	public static int myexcuteUpdate(String sql,Object ...param) throws ClassNotFoundException, SQLException{
		int row=0;
		if (connection()) {
			stmt=conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				stmt.setObject(i+1, param[i]);
			}
			row=stmt.executeUpdate();
		}
		closeresource();
		return row;
	}
	/**
	 * 查询
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static ResultSet myexcuteQuery(String sql,Object ...param) throws ClassNotFoundException, SQLException{
		if (connection()) {
			stmt=conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				stmt.setObject(i+1, param[i]);
			}
			rs=stmt.executeQuery();
		}
		return rs;
	}
}
