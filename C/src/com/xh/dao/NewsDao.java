package com.xh.dao;



import java.util.List;

import com.xh.bean.News;
import com.xh.util.PageInfo;


public interface NewsDao extends BaseDao<News> {
	
	/*在做装换*/
	List<News> findAlls(int pageNum, int pageSize);

	/*计算总记录数*/
	int getTotalCount();
	
	
	
	
	
}
