package com.xh.service;


import java.io.Serializable;
import java.util.List;

import com.xh.bean.ShoppingCart;



public interface ShoppingCartService extends BaseService<ShoppingCart>{
	
	List<ShoppingCart> select(Serializable id);
	
}
