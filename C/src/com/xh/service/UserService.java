package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.User;
import com.xh.bean.UserAddress;


public interface UserService extends BaseService<User> {
	
	
	User login(String userName,String passWord);
	User loginPwd(String userName);
	String likeSelect(Serializable name);
	List<UserAddress> findAddress(Serializable id);
	
	

}
