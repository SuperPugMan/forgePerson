package com.xh.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	/**
	 * 
	 * @param t
	 *            新增数据的方法
	 */
	public boolean add(T t);

	/**
	 * 
	 * @param t
	 *            删除数据的方法
	 */
	public boolean delete(Serializable id);

	/**
	 * 
	 * @param t
	 *            更新的数据的方法
	 */
	public boolean updata(T t);

	/**
	 * 
	 * @return 查询所有
	 */
	public List<T> select();

	/**
	 * 
	 * @param integer
	 * @return 根据id查询
	 */
	public T select_Id(Serializable id);

}
