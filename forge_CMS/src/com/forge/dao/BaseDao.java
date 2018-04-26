package com.forge.dao;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.User;

public interface BaseDao<T> {
	int add(T t);
	int delete(Serializable id);
	List<T> findAll();
	T findById(Serializable id);
	int update(Serializable id, User user);
}
