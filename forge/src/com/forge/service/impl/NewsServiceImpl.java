package com.forge.service.impl;

import java.util.Date;

import com.forge.bean.News;
import com.forge.dao.NewsDao;
import com.forge.dao.impl.NewsDaoImpl;
import com.forge.service.NewsService;
import com.forge.util.jdbcUtil;

public class NewsServiceImpl extends jdbcUtil implements NewsService {
	private NewsDao newsDao=new NewsDaoImpl();
	@Override
	public boolean add(News news) {
		int add = newsDao.add(news);
		if(add!=0){
			return true;
		}
		return false;
	}
	
}
