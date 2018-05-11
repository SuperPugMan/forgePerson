package com.xh.dao.lmpl;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.UserAddress;
import com.xh.dao.User_addressDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;




public class User_addressDaoImpl extends JdbcUtil implements User_addressDao {

	@Override
	public int add(UserAddress t) {
		String sql = "INSERT INTO easybuy_user_address (userId,address,createTime,isDefault,remark) VALUES(?,?,?,?,?)";
		Object[] params = { t.getUserId(), t.getAddress(), t.getCreateTime(), t.getIsDefault(), t.getRemark() };

		int rowNum = 0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;

	}

	@Override
	public int delete(Serializable id) {

		String sql = "DELETE FROM `easybuy_user_address` WHERE id =?";
		Object [] params= {id};
		int rowNum=0;
		rowNum=exceuteUpdate(sql, params);
		return rowNum;
	}

	@Override
	public int update(UserAddress t) {

		String sql ="UPDATE easybuy_user_address SET address=? where id=?";
		Object [] parms= {t.getAddress(),t.getId()};
		int rowNum = 0;

		rowNum=exceuteUpdate(sql);
		return rowNum;
	}

	@Override
	public List<UserAddress> selectAll() {
		String sql ="select * from easybuy_user_address";

		//创建集合来保存所有的用户
		List<UserAddress>user_address =new ArrayList<>();
		
		try {
			result=exceuteQuery(sql);
			
			user_address=ResultSet_Util.selectAllsa(result, UserAddress.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_address;
	}

	@Override
	public UserAddress select_Id(Serializable id) {

		String sql = "select * from easybuy_user_address where id=?";
		// 给参数赋值
		Object[] params = { id };
		UserAddress userAddress = null;
		try {
			result = exceuteQuery(sql, params);
			userAddress=ResultSet_Util.selectAlla(result, UserAddress.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAss(conn, pre, result);
		}
		return userAddress;
	}


}
