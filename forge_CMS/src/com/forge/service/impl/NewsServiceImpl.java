package com.forge.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;





import org.apache.log4j.Logger;

import com.forge.bean.News;
import com.forge.dao.NewsDao;
import com.forge.dao.impl.NewsDaoImpl;
import com.forge.filter.CharacterFilter;
import com.forge.service.NewsService;
import com.forge.util.MemcachedDBSington;
import com.forge.util.MemcachedUtil;
import com.forge.util.jdbcUtil;

public class NewsServiceImpl extends jdbcUtil implements NewsService {
	Logger log=Logger.getLogger(CharacterFilter.class);
	private NewsDao newsDao=new NewsDaoImpl();
	@Override
	public boolean addOne(News news) {
		int add = newsDao.add(news);
		if(add!=0){
			return true;
		}
		return false;
	}
	@Override
	public int delete(Serializable id) {
		return newsDao.delete(id);
	}
	@Override
	public List<News> findAll() {
		//如果缓存中没有对象时，就进入数据库查询
		if(MemcachedUtil.getInstance().get("myUser")==null){
			log.info("List<News> findAll()进入数据库查询");
			List<News> findByName = newsDao.findAll();
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return  findByName;
		}else{
			log.info("List<News> findAll()进入缓存中查询");
			return newsDao.findAll();
		}
	}
	@Override
	public News findById(Serializable id) {
		//如果缓存中没有对象时，就进入数据库查询
		if(MemcachedUtil.getInstance().get("myUser")==null){
			log.info("News findById(Serializable id)进入数据库查询");
			News findByName = newsDao.findById(id);
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return  findByName;
		}else{
			log.info("News findById(Serializable id)进入缓存中查询");
			return newsDao.findById(id);
		}
	}
	@Override
	public int update(Serializable id, News t) {
		return newsDao.update(id, t);
	}
	@Override
	public int add(News t) {
		int add = newsDao.add(t);
		if(add!=0){
			return 1;
		}
		return 0;
	}
	
}
