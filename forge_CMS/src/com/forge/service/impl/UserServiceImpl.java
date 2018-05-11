package com.forge.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import com.forge.bean.Product;
import com.forge.bean.User;
import com.forge.dao.UserDao;
import com.forge.dao.impl.UserDaoImpl;
import com.forge.filter.CharacterFilter;
import com.forge.service.UserService;
import com.forge.util.MemcachedUtil;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	Logger log=Logger.getLogger(CharacterFilter.class);
	@Override
	public User login(String email, String password) {
		User user = dao.login(email, password);
		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	@Override
	public boolean add(User t) {
		int num = dao.add(t);
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(Serializable id) {
		int num = dao.delete(id);
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(Serializable id, User user) {
		int num = dao.update(id, user);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> findAll() {
		// 如果缓存中没有对象时，就进入数据库查询
		if (MemcachedUtil.getInstance().get("myUser") == null) {
			log.info("List<User> findAll()进入数据库查询");
			List<User> findByName = dao.findAll();
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return findByName;
		} else {
			log.info("List<User> findAll()进入缓存中查询");
			return dao.findAll();
		}
	}

	@Override
	public User findById(Serializable id) {
		// 如果缓存中没有对象时，就进入数据库查询
		if (MemcachedUtil.getInstance().get("myUser") == null) {
			log.info("User findById(Serializable id)进入数据库查询");
			User findByName = dao.findById(id);
			MemcachedUtil.getInstance().set("myUser", 1000, findByName);
			return findByName;
		} else {
			log.info("User findById(Serializable id)进入缓存中查询");
			return dao.findById(id);
		}

	}
	
	@Override
	public User mycount(String name) {
		return dao.findByName(name);
	}
}
