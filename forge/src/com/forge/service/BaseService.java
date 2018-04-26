package com.forge.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	boolean add(T t);
	void delete(Serializable id);
	List<T> findAll();
	T findById(Serializable id);
	void update(Serializable id, Serializable a, Serializable b);
}
