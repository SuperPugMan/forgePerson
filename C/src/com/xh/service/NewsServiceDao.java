package com.xh.service;



import com.xh.bean.News;
import com.xh.util.PageInfo;

/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-4-28上午9:24:02  
 *
 */
public interface NewsServiceDao extends BaseService<News> {
	
	
	/*在NewDao做装换*/
	PageInfo<News> findAlls(int pageNum, int pageSize);

	/*计算总记录数*/
	int getTotalCount();
	
	
}
