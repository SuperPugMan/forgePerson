package com.forge.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.forge.bean.Order_Detail;
import com.forge.bean.Product;
import com.forge.dao.ProductDao;
import com.forge.dao.impl.ProductDaoImpl;
import com.forge.filter.CharacterFilter;
import com.forge.service.ProductService;
import com.forge.util.MemcachedUtil;

public class ProductServeicImpl implements ProductService {
	ProductDao prodao = new ProductDaoImpl();
	Logger log=Logger.getLogger(CharacterFilter.class);
	@Override
	public boolean add(Product t) {
		int add = prodao.add(t);
		if (add > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		int delete = prodao.delete(id);
		if (delete > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Product> findAll() {
		// 如果缓存中没有对象时，就进入数据库查询
		if (MemcachedUtil.getInstance().get("myUser") == null) {
			log.info(" List<Product> findAll()进入数据库查询");
			List<Product> findByName = prodao.findAll();
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return findByName;
		} else {
			log.info("List<Product> findAll()进入缓存中查询");
			return prodao.findAll();
		}
	}

	@Override
	public Product findById(Serializable id) {
		// 如果缓存中没有对象时，就进入数据库查询
		if (MemcachedUtil.getInstance().get("myUser") == null) {
			log.info("Product findById(Serializable id)进入数据库查询");
			Product findByName =prodao.findById(id);
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return findByName;
		} else {
			log.info("Product findById(Serializable id)进入缓存中查询");
			return prodao.findById(id);
		}
	}

	@Override
	public boolean update(Serializable id, Product t) {
		int update = prodao.update(id, t);
		if (update > 0) {
			return true;
		}
		return false;
	}

}
