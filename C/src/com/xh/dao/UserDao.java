package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.bean.UserAddress;

public interface UserDao extends BaseDao<User> {

	User login(String userName, String passWord);

	User loginPwd(String userName);

	List<Product> likeSelect(Serializable name);

	List<UserAddress> findAddress(Serializable id);

	List<String> findAllName();
}
