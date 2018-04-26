package com.forge.service;

import com.forge.bean.User;

/**
 * 用户的业务逻辑类
 */
public interface UserService extends BaseService<User>{
	User login(String str1, String str2);
	User mycount(String name);
}
