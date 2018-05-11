package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Product;

public interface ProductDao extends BaseDao<Product> {

	List<Product> select(Serializable id);

	List<Product> selectLike(Serializable id);

	// List<Product> select(Serializable id);

	String selectById(Serializable id);

}
