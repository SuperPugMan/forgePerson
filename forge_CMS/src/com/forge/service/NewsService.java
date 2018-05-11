package com.forge.service;

import com.forge.bean.News;
import com.forge.dao.BaseDao;

public interface NewsService extends BaseDao<News>{
	boolean addOne(News news);
}
