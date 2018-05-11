package com.xh.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	

	/**
	 * 
	 * @param t
	 * @return 添加用户的方法
	 */
	int add(T t);
	/**
	 * 
	 * @param id
	 * @return 删除某些内容方法
	 */
	int delete(Serializable id);
	/**
	 * 
	 * @param t
	 * @return 修改方法
	 */
	int update(T t);
	/**
	 * 
	 * @return  查询所有的方法
	 */
	List<T> selectAll();	
	/**
	 * 
	 * @param id
	 * @return  通过Id查找对象
	 */
	T select_Id(Serializable id);
	
	
	

}
