package com.forge.dao;

import com.forge.bean.User;

public interface UserDao extends BaseDao<User>{
	User login(String email, String password);
	User findByName(String name);
}
