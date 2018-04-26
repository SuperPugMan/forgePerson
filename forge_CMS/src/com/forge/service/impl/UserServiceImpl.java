package com.forge.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.forge.bean.User;
import com.forge.dao.UserDao;
import com.forge.dao.impl.UserDaoImpl;
import com.forge.service.UserService;
import com.forge.util.MemcachedUtil;



public class UserServiceImpl implements UserService{
	UserDao dao=new UserDaoImpl();

	@Override
	public User login(String email, String password) {
		User user=dao.login(email, password);
		if (user==null) {
			return null;
		}else{
			return user;
		}
	}
	@Override
	public boolean add(User t) {
		int num=dao.add(t);
		if (num>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean delete(Serializable id) {
		int num=dao.delete(id);
		if (num>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean update(Serializable id, User user) {
		int num=dao.update(id,user);
		if (num>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}
	@Override
	public User findById(Serializable id) {
			return dao.findById(id);
		
	}
	public static void main(String[] args) {
		UserService service=new UserServiceImpl();
		System.out.println(service.findById(1));
	}
	@Override
	public User mycount(String name) {
		return dao.findByName(name);
	}
}
