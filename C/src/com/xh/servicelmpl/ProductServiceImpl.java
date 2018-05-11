package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;

import com.xh.bean.Product;
import com.xh.dao.ProductDao;
import com.xh.dao.lmpl.ProductDaolmpl;
import com.xh.service.ProductService;
import com.xh.util.Memcached;

public class ProductServiceImpl implements ProductService {

	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	ProductDao productDao = new ProductDaolmpl();

	@Override
	public boolean add(Product t) {
		int add = productDao.add(t);

		if (add > 0) {
			logger.debug("新增成功！");
			return true;

		} else {
			logger.debug("新增失败！");
			return false;

		}

	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		int delete = productDao.delete(id);
		if (delete > 0) {
			logger.debug("删除成功！");
			return true;

		} else {
			logger.debug("删除失败！");
			return false;

		}

	}

	@Override
	public boolean updata(Product t) {
		// TODO Auto-generated method stub
		int update = productDao.update(t);
		if (update > 0) {
			logger.debug("更新成功！");
			return true;

		} else {
			logger.debug("更新失败！");
			return false;
		}

	}

	@Override
	public List<Product> select() {
		// TODO Auto-generated method stub
		MemcachedClient in = Memcached.getIn();

		List<Product> selectAll = null;
		if (in.get("shi10") == null) {

			logger.debug("---------------进入数据库selectAll-----------------");
			selectAll = productDao.selectAll();
			in.set("shi10", 60 * 30, selectAll);
		} else {
			selectAll = (List<Product>) in.get("shi10");
			logger.debug("---------------进入缓存selectAll-----------------");
		}

		return selectAll;

	}

	@Override
	public Product select_Id(Serializable id) {
		// TODO Auto-generated method stub
		Product select_Id = productDao.select_Id(id);

		return select_Id;
	}

	@Override
	public List<Product> select(Serializable id) {

		MemcachedClient in = Memcached.getIn();

		List<Product> select = null;

		if (in.get(id + "san") == null) {
			logger.debug("---------------进入数据库-----------------");
			select = productDao.select(id);
			in.set(id + "san", 60 * 30, select);

		} else {
			System.err.println("---------------进入缓存-----------------");
			select = (List<Product>) in.get(id + "san");

		}

		return select;
	}

	@Override
	public List<Product> selectLike(Serializable id) {

		// TODO Auto-generated method stub

		MemcachedClient in = Memcached.getIn();

		List<Product> selectLike = null;
		if (in.get(id + "selectLike") == null) {
			System.err.println("---------------进入数据库-----------------");
			selectLike = productDao.selectLike(id);
			in.set(id + "selectLike", 60 * 30, selectLike);

		} else {
			logger.debug("---------------进入缓存-----------------");
			selectLike = (List<Product>) in.get(id + "selectLike");

		}

		return selectLike;
	}

	@Override
	public String selectBuId(Serializable id) {
		return productDao.selectById(id);
	}
}
