package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;

import com.xh.bean.Product;
import com.xh.bean.ProductCategory;
import com.xh.dao.ProductDao;
import com.xh.dao.Product_CategoryDao;
import com.xh.dao.lmpl.ProductDaolmpl;
import com.xh.dao.lmpl.Product_CategoryDaolmpl;
import com.xh.service.ProductCategoryService;
import com.xh.util.Memcached;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	Logger logger = Logger.getLogger(ProductCategoryServiceImpl.class);
	Product_CategoryDao pro = new Product_CategoryDaolmpl();

	@Override
	public boolean add(ProductCategory t) {
		// TODO Auto-generated method stub

		int add = pro.add(t);

		if (add > 0) {
			logger.info("新增成功！");
			return true;

		} else {
			logger.info("新增失败！");
			return false;
		}

	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub

		int delete = pro.delete(id);
		if (delete > 0) {
			logger.info("删除成功！");
			return true;

		} else {
			logger.info("删除失败！");
			return false;
		}

	}

	@Override
	public boolean updata(ProductCategory t) {
		// TODO Auto-generated method stub

		int update = pro.update(t);
		if (update > 0) {
			System.err.println("更新成功！");
			return true;

		} else {
			System.err.println("更新失败！");
			return false;
		}

	}

	@Override
	public List<ProductCategory> select() {
		// TODO Auto-generated method stub
		List<ProductCategory> selectAll = pro.selectAll();

		return selectAll;

	}

	@Override
	public ProductCategory select_Id(Serializable id) {
		// TODO Auto-generated method stub

		ProductCategory select_Id = pro.select_Id(id);

		return select_Id;
	}

	@Override
	public List<ProductCategory> getProduct() {

		// 1级标题，包括2,2包括3
		// Map<Object, Map<Object,Object>> hashMap = new LinkedHashMap<>();
		List<ProductCategory> product = null;
		MemcachedClient in = Memcached.getIn();

		if (in.get("keyee") == null) {
			logger.info("<<<<<<<<<<<<<<<<进入数据库>>>>>>>>>>>>>>>>>>");
			product = pro.getProduct();

			in.set("keyee", 60 * 30, product);

		} else {

			logger.info("<<<<<<<<<<<<<<<<进入缓存>>>>>>>>>>>>>>>>>>");
			product = (List<ProductCategory>) in.get("keyee");

		}

		return product;

	}

	/**
	 * 
	 * @return 所有商品
	 */
	public Map<ProductCategory, Map<ProductCategory, List<Product>>> getProduct1() {

		Map<ProductCategory, Map<ProductCategory, List<Product>>> map = new LinkedHashMap<>();

		// List<List<Product>> listssEs=new ArrayList<>();
		// map.put(key, value);
		// Map<ProductCategory, Map<ProductCategory,List<Product>>> map=new
		// LinkedHashMap<>();

		List<ProductCategory> product = getProduct();// 1
		Map<ProductCategory, List<Product>> map1 = new LinkedHashMap();
		for (ProductCategory productCategory : product) {// 1级所有的对象

			// 通过1级的id查找父类的id这个是2级的东西

			List<ProductCategory> product2 = getProduct(
					productCategory.getType() + 1, productCategory.getId());// 单个1级对象对应的所有2二级对象

			// List<Product> list =new ArrayList<>();

			for (ProductCategory productCategory2 : product2) {// 单个2级

				Integer id = productCategory2.getId();

				List<Product> name = name(id); // 单个2级对象对应的三级数据集合

				map1.put(productCategory2, name);

			}

			map.put(productCategory, map1);// 全部数据

		}

		Set<ProductCategory> keySet = map.keySet();
		for (ProductCategory productCategory : keySet) {

			Map<ProductCategory, List<Product>> map2 = map.get(productCategory);// 2

			Set<ProductCategory> keySet2 = map2.keySet();

			for (ProductCategory productCategory2 : keySet2) {

				List<Product> list = map2.get(keySet2);// 3

				for (Product product2 : list) {

					logger.info(">>>>>>>>>>>>>>>" + product2);

				}
			}
		}

		return map;

	}

	/**
	 * 
	 * 2级所有集合集合
	 * 
	 */
	@Override
	public List<ProductCategory> getProduct(Integer integer, Serializable id) {
		// TODO Auto-generated method stub
		List<ProductCategory> product = null;

		MemcachedClient in = Memcached.getIn();
		if (in.get(id.toString() + integer) == null) {
			logger.info("<<<<<<<<<<<<<<<<进入数据库>>>>>>>>>>>>>>>>>>");
			product = pro.getProduct(integer, id);

			in.set(id.toString() + integer, 60 * 30, product);

		} else {

			logger.info("<<<<<<<<<<<<<<<<进入缓存>>>>>>>>>>>>>>>>>>");

			product = (List<ProductCategory>) in.get(id.toString());

		}

		return product;
	}

	@Override
	public List<Product> name(Serializable id) {

		// 商品实体类
		ProductDao productDao = new ProductDaolmpl();
		// 缓存

		// 查看3级菜单的物品

		List<Product> select = null;
		MemcachedClient in = Memcached.getIn();

		if (in.get(id.toString() + "3ye") == null) {
			logger.info("-------------------进入数据库--------------------");
			select = productDao.select(id);
			in.set(id.toString() + "3ye", 60 * 30, select);

		} else {
			logger.info("------------------进入缓存---------------------");
			select = (List<Product>) in.get(id.toString() + "3ye");

		}

		return select;

	}

	@Override
	public List<ProductCategory> getProduct2(Serializable id) {
		List<ProductCategory> product = null;

		MemcachedClient in = Memcached.getIn();
		if (in.get(id.toString()) == null) {
			logger.info("<------------------进入数据库------------------->");
			product = pro.getProduct2(id);

			in.set(id.toString(), 60 * 30, product);

		} else {

			logger.info("<------------------->进入缓存------------------->");

			product = (List<ProductCategory>) in.get(id.toString());

		}

		return product;
	}

}
