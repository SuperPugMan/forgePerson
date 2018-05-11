package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Product;

public interface ProductService extends BaseService<Product> {

	public List<Product> select(Serializable id);

	List<Product> selectLike(Serializable id);

	String selectBuId(Serializable id);
}
