package com.forge.dao.impl;

import java.sql.SQLException;

import com.forge.bean.News;
import com.forge.dao.NewsDao;
import com.forge.util.jdbcUtil;

public class NewsDaoImpl  extends jdbcUtil implements NewsDao{

	@Override
	public int add(News news) {
		int num=0;
		String sql="INSERT INTO `forge_news`(`title`,`content`,`createtime`,`img`) VALUES (?,?,?,?);";
		Object[] param={news.getTitle(),news.getContent(),news.getCreateTime(),news.getImg()};
		try {
			num = myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
