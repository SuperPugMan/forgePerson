package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.OrderDetail;
import com.xh.dao.OrderDatailDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;



public class OrderDatailDaolmpl extends JdbcUtil implements OrderDatailDao {

	@Override
	public int add(OrderDetail t) {
		
		String sql="INSERT INTO easybuy_order_detail (orderId,productId,quantity,cost) VALUES (?,?,?,?)";
		Object [] params= {t.getOrderId(),t.getProductId(),t.getQuantity(),t.getCost()};
		int rowNum = 0;
		rowNum=exceuteUpdate(sql, params);
		
		return rowNum;
	}

	
	@Override
	public int delete(Serializable id) {
		String sql ="DELETE FROM easybuy_order_detail WHERE id =?";
		Object [] params={id};
		int rowNum=0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public int update(OrderDetail t) {
		// TODO Auto-generated method stub
		String sql ="UPDATE easybuy_order_detail SET quantity =?,cost=? WHERE id = ?";
		Object [] params = {t.getQuantity(),t.getCost(),t.getId()};
		int rowNum=0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public List<OrderDetail> selectAll() {
		String sql = "select * from easybuy_order_detail";

		//创建List集合保存
		List<OrderDetail> easybuy_order_detail =new ArrayList<>();

		try {
			result = exceuteQuery(sql);

			easybuy_order_detail=ResultSet_Util.selectAlls(result, OrderDetail.class);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAss(conn, pre, result);
			
		}
		
		return easybuy_order_detail;
	}


	@Override
	public OrderDetail select_Id(Serializable id) {
		String sql = "select * from easybuy_order_detail where id=?";
		// 给参数赋值
		Object[] params = { id };
		OrderDetail user = null;
		try {
			result = exceuteQuery(sql, params);
			user = ResultSet_Util.selectAlla(result, OrderDetail.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close_();

		}

		return user;
	}

}
