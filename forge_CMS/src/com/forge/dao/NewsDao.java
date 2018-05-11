package com.forge.dao;

import com.forge.bean.News;
import com.forge.bean.User;

public interface NewsDao extends BaseDao<News>{
	int add(News news);
}
