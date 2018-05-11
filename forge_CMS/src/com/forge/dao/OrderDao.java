package com.forge.dao;

import java.io.Serializable;

import com.forge.bean.Order;

public interface OrderDao extends BaseDao<Order> {
	//根据订单ID查询流水号
	String orderById(Serializable id);
	//根据商品ID查询商品名字
	String  productById(Serializable id);
	//查询所有订单详情
	
}
