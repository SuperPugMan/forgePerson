package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.ShoppingCart;
import com.xh.dao.ShoppingCartDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class ShoppingCartDaoImpl extends JdbcUtil implements ShoppingCartDao {

	@Override
	public int add(ShoppingCart t) {
		String sql = "insert into shopping_cart(userId,productId,productNum) values(?,?,?)";
		int result = 0;
		Object[] objects = { t.getUserId(), t.getProductId(), t.getProductNum() };
		result = this.exceuteUpdate(sql, objects);
		return result;
	}

	@Override
	public int delete(Serializable id) {
		String sql = "delete from shopping_cart where productId=?";
		int result = 0;
		result = exceuteUpdate(sql, id);
		return result;
	}

	/**
	 * 有这个商品的是时候改
	 */

	@Override
	public int update(ShoppingCart t) {
		int result = 0;
		// String
		// sql="update shopping_cart set productId=?,productNum=? where userId=? and productId=?";
		String sql = "update shopping_cart set productId=?,productNum=? where userId=? and productId=?";
		Object[] objects = { t.getProductId(), t.getProductNum(),
				t.getUserId(), t.getProductId() };
		result = exceuteUpdate(sql, objects);
		return result;
	}

	@Override
	public List<ShoppingCart> selectAll() {
		List<ShoppingCart> list = null;
		String sql = "select * from shopping_cart";
		try {
			result = exceuteQuery(sql);
			list = ResultSet_Util.selectAllsa(result, ShoppingCart.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ShoppingCart select_Id(Serializable id) {
		String sql = "select * from shopping_cart where productId=?";
		ShoppingCart shoppingCart = null;
		try {
			result = exceuteQuery(sql, id);
			shoppingCart = ResultSet_Util
					.selectAlla(result, ShoppingCart.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_();
		}
		return shoppingCart;
	}

	public int update_Id(int proId, int num) throws SQLException {
		System.out.println("update_Id------------->" + proId + "  " + num);
		int num1 = 0;
		String sql = "UPDATE  shopping_cart  SET productnum=?   WHERE  productId=?;";
		Object[] params = { num, proId };
		num1 = exceuteUpdate(sql, params);
		System.out.println("Update____Id---------->num" + num1);
		return num1;
	}

	@Override
	public List<ShoppingCart> select(Serializable t) {

		String sql = "select * from shopping_cart where userId=?";

		List<ShoppingCart> list = null;
		try {
			result = exceuteQuery(sql, t);

			list = ResultSet_Util.selectAllsa(result, ShoppingCart.class);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close_();
		}
		return list;
	}

	/*
	 * @Override public int delete(ShoppingCart id) { // TODO Auto-generated
	 * method stub return 0; }
	 *//**
	 * 查看数据库内有没有数据
	 */
	/*
	 * @Override public int cha(ShoppingCart id) { // TODO Auto-generated method
	 * stub return 0; }
	 */

}
