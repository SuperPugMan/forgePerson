package com.forge.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.forge.bean.News;
import com.forge.bean.Order;
import com.forge.bean.Order_Detail;
import com.forge.dao.OrderDao;
import com.forge.dao.impl.OrderDaoImpl;
import com.forge.filter.CharacterFilter;
import com.forge.service.OrderService;
import com.forge.util.MemcachedUtil;
import com.forge.util.jdbcUtil;

public class OrderServiceImpl extends jdbcUtil implements OrderService {
	Logger log=Logger.getLogger(CharacterFilter.class);
	OrderDao dao=new OrderDaoImpl();	
	
	@Override
	public int add(Order t) {
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		return dao.delete(id);
	}

	@Override
	public List<Order> findAll() {
		//如果缓存中没有对象时，就进入数据库查询
		if(MemcachedUtil.getInstance().get("myUser")==null){
			log.info("List<Order> findAll()进入数据库查询");
			List<Order> findByName = dao.findAll();
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return  findByName;
		}else{
			log.info("List<Order> findAll()进入缓存中查询");
			return dao.findAll();
		}
	}

	@Override
	public Order findById(Serializable id) {
		//如果缓存中没有对象时，就进入数据库查询
		if(MemcachedUtil.getInstance().get("myUser")==null){
			System.out.println("进入数据库查询");
			Order findByName =  dao.findById(id) ;
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return  findByName;
		}else{
			log.info("Order findById(Serializable id)进入缓存中查询");
			return  dao.findById(id) ;
		}
	}

	@Override
	public int update(Serializable id, Order t) {
		return dao.update(id, t);
	}
	public List<Order_Detail> findAllDetail(){
		OrderDaoImpl dao=new OrderDaoImpl();
		//如果缓存中没有对象时，就进入数据库查询
		if(MemcachedUtil.getInstance().get("myUser")==null){
			System.out.println("进入数据库查询");
			 List<Order_Detail> findByName =  dao.findAllDetail();
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return  findByName;
		}else{
			log.info("Order findById(Serializable id)进入缓存中查询");
			return  dao.findAllDetail();
		}
	}
	public int updateDetai(Serializable id,Order_Detail t){
		OrderDaoImpl dao=new OrderDaoImpl();
		return dao.updateDetail(id, t);
	}
}
