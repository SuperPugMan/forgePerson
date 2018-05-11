package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.Product;
import com.xh.bean.ProductCategory;
import com.xh.dao.Product_CategoryDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;



public class Product_CategoryDaolmpl extends JdbcUtil implements Product_CategoryDao  {

	@Override
	public int add(ProductCategory t) {
		String sql = "INSERT INTO easybuy_product_category (name,parentId,type,iconClass) VALUES(?,?,?,?)";
		Object[] params = { t.getName(), t.getParentId(), t.getType(), t.getIconClass() };

		int rowNum = 0;

		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public int delete(Serializable id) {
		String sql = "delect from easybuy_product_category where id=?";
		Object[] params = { id };
		int rowNum = 0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public int update(ProductCategory t) {
		String sql = "update easybuy_product_category set name=?,parentId=?,type=?,iconClass=? where id =?";
		Object[] params = { t.getName(), t.getParentId(), t.getType(), t.getIconClass(), t.getId() };
		int rowNum = 0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public List<ProductCategory> selectAll() {
		String sql = "select * from easybuy_product_category ";

		// 创建集合保存所有信息
		List<ProductCategory> easybuy_list = null;
		try {
			result=exceuteQuery(sql);
			
			easybuy_list=ResultSet_Util.selectAllsa(result, ProductCategory.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close_();
		}
		

		return easybuy_list;
	}

	@Override
	public ProductCategory select_Id(Serializable id) {




		String sql = "select * from easybuy_product_category where id=?";
		Object[] params = { id };
		ProductCategory productCategory=null;

		try {
			result=exceuteQuery(sql, params);
			productCategory=ResultSet_Util.selectAlla(result, ProductCategory.class);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close_();
		}


		return productCategory;
	}

	@Override
	public List<ProductCategory> getProduct() {

		String sql = "select * from easybuy_product_category where type=1";

		// 创建集合保存所有信息
		//System.err.println("进入1级菜单====================");
		List<ProductCategory> easybuy_list =null;
		try {

			result=exceuteQuery(sql);
			//System.err.println(result);

			easybuy_list=ResultSet_Util.selectAllsa(result, ProductCategory.class);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close_();
		}

		/*	for (ProductCategory productCategory : easybuy_list) {

			System.err.println(productCategory+"=========23232323232===========");

		}*/

		return easybuy_list;
	}

	@Override
	public List<ProductCategory> getProduct(Integer integer,Serializable id) {
		// TODO Auto-generated method stub

		//String sql = "select * from easybuy_product_category where parentid=?";
		String sql = "select * from easybuy_product_category where type=? and parentId=?";


		//System.err.println(sql+"=====>"+id);

		Object[] paObject={integer,id};

		// 创建集合保存所有信息
		List<ProductCategory> easybuy_list = null;
		try {
			result=exceuteQuery(sql,integer,paObject);
			easybuy_list=ResultSet_Util.selectAllsa(result, ProductCategory.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close_();
		}

		return easybuy_list;
	}

	@Override
	public List<ProductCategory> getProduct2(Serializable id) {


		String sql = "select * from easybuy_product_category where type=?";

		// 创建集合保存所有信息
		List<ProductCategory> easybuy_list =null;
		try {
			result=exceuteQuery(sql,id);
			easybuy_list=ResultSet_Util.selectAllsa(result, ProductCategory.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			close_();
		}

		return easybuy_list;
	}

}
