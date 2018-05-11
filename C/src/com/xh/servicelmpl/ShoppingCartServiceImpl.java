package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.ShoppingCart;
import com.xh.dao.ShoppingCartDao;
import com.xh.dao.lmpl.ShoppingCartDaoImpl;
import com.xh.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	Logger logger = Logger.getLogger(ShoppingCartServiceImpl.class);
	ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();

	@Override
	public boolean add(ShoppingCart t) {

		int add = shoppingCartDao.add(t);
		if (add > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(Serializable id) {
		int delete = shoppingCartDao.delete(id);
		if (delete > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updata(ShoppingCart t) {

		int update = shoppingCartDao.update(t);
		if (update > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ShoppingCart> select() {

		return shoppingCartDao.selectAll();

	}

	@Override
	public ShoppingCart select_Id(Serializable id) {
		return shoppingCartDao.select_Id(id);
	}

	@Override
	public List<ShoppingCart> select(Serializable id) {

		return shoppingCartDao.select(id);
	}

}
