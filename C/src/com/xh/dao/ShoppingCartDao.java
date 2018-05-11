package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.ShoppingCart;




public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	List<ShoppingCart> select(Serializable t);
	/*int delete(ShoppingCart id);
	int cha(ShoppingCart id);*/
	
}
