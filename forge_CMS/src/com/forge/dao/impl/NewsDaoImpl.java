package com.forge.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.forge.bean.News;
import com.forge.bean.User;
import com.forge.dao.NewsDao;
import com.forge.util.jdbcUtil;
import com.forge.util.resultSetUtil;

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

	@Override
	public int delete(Serializable id) {
		int num=0;
		String sql="delete from forge_news where id=?;";
		try {
			num=myexcuteUpdate(sql, id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<News> findAll() {
		List<News> news=null;
		String sql="select * from forge_news";
		try {
			rs = myexcuteQuery(sql);
			news = resultSetUtil.findAll(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public News findById(Serializable id) {
		News news=null;
		String sql="select * from forge_news where id=?";
		try {
			rs = myexcuteQuery(sql, id);
			news = resultSetUtil.findById(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}


	@Override
	public int update(Serializable id, News t) {
		int num=0;
		String sql="update forge_news set title=?,content=? where id=?";
		Object[] param={t.getTitle(),t.getContent(),id};
		try {
			num=myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
