package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xh.bean.Forge_Users_Tracks;
import com.xh.dao.Forge_Users_TracksDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class Forge_Users_TracksDaoImpl extends JdbcUtil implements
		Forge_Users_TracksDao {

	@Override
	public int add(Forge_Users_Tracks t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Forge_Users_Tracks t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTrack(int userId, String id) {
		String sql = "insert into forge_user_tracks value (?,?,?)";
		// 获取用户的浏览时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		Object[] param = { userId, id, date };
		exceuteUpdate(sql, param);
	}

	// 根据指定的userID和productID查询指定的数据
	public Forge_Users_Tracks selectById(int userID, String id) {
		System.out.println("userId-->" + userID + "proID--->" + id);
		Forge_Users_Tracks traks = null;
		String sql = "select userID,productID,viewTime from forge_user_tracks where userID=? and productID=? ";
		Object[] params = { userID, id };
		try {
			result = exceuteQuery(sql, params);
			traks = ResultSet_Util.selectAll(result, Forge_Users_Tracks.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(traks);
		return traks;
	}

	@Override
	// 查找用户浏览的所有商品
	public List<Forge_Users_Tracks> findAll(Serializable userId) {
		List<Forge_Users_Tracks> tracks = null;
		String sql = "SELECT * FROM `forge_user_tracks` WHERE userId = ?";
		Object[] param = { userId };
		try {
			result = exceuteQuery(sql, param);
			// 获取用户所有的
			tracks = ResultSet_Util
					.selectAlls(result, Forge_Users_Tracks.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tracks;
	}

	@Override
	public void update(Serializable userId, String productId) {
		// 获取用户的浏览时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间
		String sql = "UPDATE forge_user_tracks SET viewTime=? WHERE userId=? AND productId=?";
		Object[] param = { date, userId, productId };
		exceuteUpdate(sql, param);
	}

	@Override
	public List<Forge_Users_Tracks> selectAll() {
		return null;
	}

	@Override
	public Forge_Users_Tracks select_Id(Serializable id) {
		return null;
	}

}
