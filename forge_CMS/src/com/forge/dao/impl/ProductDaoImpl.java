package com.forge.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.forge.bean.News;
import com.forge.bean.Product;
import com.forge.bean.ProductCategory;
import com.forge.bean.User;
import com.forge.dao.NewsDao;
import com.forge.dao.ProductDao;
import com.forge.util.jdbcUtil;
import com.forge.util.resultSetUtil;

public class ProductDaoImpl  extends jdbcUtil implements ProductDao{

	@Override
	public int add(Product pro) {
		int num=0;
		String sql="INSERT INTO `forge_product`(`name`,`description`,`price`,`stock`,`categoryLevel1`,`categoryLevel2`,`categoryLevel3`,`fileName`,`score`) VALUES (?,?,?,?,?,?,?,?,?);";
		Object[] param={pro.getName(),pro.getDescription(),pro.getPrice(),pro.getStock(),pro.getCategorylevel1(),pro.getCategorylevel2(),pro.getCategorylevel3(),pro.getFileName(),pro.getScore()};
		try {
			num = myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int addDetail(ProductCategory pro) {
		int num=0;
		String sql="INSERT INTO `forge_product_category`(`name`,`parentId`,`type`,`iconClass`) VALUES (?,?,?,?);";
		Object[] param={pro.getName(),pro.getParentId(),pro.getType(),pro.getIconClass()};
		try {
			num = myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delete(Serializable id) {
		int num=0;
		String sql="delete from forge_product where id=?;";
		try {
			num=myexcuteUpdate(sql, id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public int deleteDetail(Serializable id) {
		int num=0;
		String sql="delete from forge_product_category where id=?;";
		try {
			num=myexcuteUpdate(sql, id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Product> findAll() {
		List<Product> pro=null;
		String sql="select * from forge_product";
		try {
			rs = myexcuteQuery(sql);
			pro = resultSetUtil.findAll(rs, Product.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	public List<ProductCategory> findAllDetail() {
		List<ProductCategory> pro=null;
		String sql="select * from forge_product_category";
		try {
			rs = myexcuteQuery(sql);
			pro = resultSetUtil.findAll(rs, ProductCategory.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

	@Override
	public Product findById(Serializable id) {
		Product pro=null;
		String sql="select * from forge_product where id=?";
		try {
			rs = myexcuteQuery(sql, id);
			pro = resultSetUtil.findById(rs, Product.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}


	@Override
	public int update(Serializable id, Product t) {
		int num=0;
		String sql="update forge_product set price=?,stock=?,description=?,score=? where id=?;";
		Object[] param={t.getPrice(),t.getStock(),t.getDescription(),t.getScore(),id};
		try {
			num=myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
