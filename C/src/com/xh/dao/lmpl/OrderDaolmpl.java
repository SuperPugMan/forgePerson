package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.Order;
import com.xh.dao.OrderDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;


public class OrderDaolmpl extends JdbcUtil implements OrderDao {

	@Override
	public int add(Order t) {
		String sql = "INSERT INTO easybuy_order (userId,loginName,userAddress,createTime,cost,serialNumber)VALUES(?,?,?,?,?,?)";

		Object[] params = { t.getUserId(), t.getLoginName(), t.getUserAddress(), t.getCreateTime(), t.getCost(),
				t.getSerialNumber() };

		int rowNum = 0;
		rowNum=exceuteUpdate(sql, params);		
		return rowNum;
	}


	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub



		String sql = "DELETE FROM easybuy_order WHERE id =?";
		Object[] params = { id };
		
		

		int rowNum = 0;

		rowNum=exceuteUpdate(sql, params);		
		return rowNum;
	}

	@Override
	public int update(Order t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE easybuy_order SET loginName=?,userAddress=?,createTime?,cost=?,serialNumber=? WHERE id=?";

		Object [] params= {t.getLoginName(),t.getUserAddress(),t.getCreateTime(),t.getCost(),t.getSerialNumber()};

		int rowNum=0;
		rowNum=exceuteUpdate(sql, params);		
		return rowNum;


	}

	@Override
	public List<Order> selectAll() {
		// TODO Auto-generated method stub

		String sql ="select * from easybuy_order";
		//创建个List集合保存所有
		List<Order> easybuy_order =new ArrayList<>();


		try {
			result=exceuteQuery(sql);
			easybuy_order=ResultSet_Util.selectAlls(result, Order.class);


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return easybuy_order;
	}

	@Override
	public Order select_Id(Serializable id) {

		String sql = "select * from easybuy_order where id=?";
		// 给参数赋值
		Object[] params = { id };
		Order user = null;
		try {
			result = exceuteQuery(sql, params);
			//利用反射机制把数据库的数据转换为对应的实体反回去
			user = ResultSet_Util.selectAlla(result, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close_();

		}

		return user;
	}

}
