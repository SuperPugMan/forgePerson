package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Product;
import com.xh.bean.ProductCategory;


public interface ProductCategoryService extends BaseService<ProductCategory> {
	
	List<ProductCategory>  getProduct(); 
	List<ProductCategory>  getProduct(Integer integer,Serializable id); 
	List<ProductCategory>  getProduct2(Serializable id); 
	  List<Product> name(Serializable id);
	
	
}
