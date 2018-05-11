package com.forge.service;

import java.io.Serializable;
import java.util.List;

import com.forge.bean.User;

public interface BaseService<T> {
	boolean add(T t);
	boolean delete(Serializable id);
	List<T> findAll();
	T findById(Serializable id);
	boolean update(Serializable id, T t);
}
