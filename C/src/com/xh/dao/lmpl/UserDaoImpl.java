package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.bean.UserAddress;
import com.xh.dao.UserDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class UserDaoImpl extends JdbcUtil implements UserDao {

	@Override
	public List<UserAddress> findAddress(Serializable id) {
		List list = new ArrayList<>();
		System.out.println("dao------>" + id);
		String sql = "select region_id,region_name from region where parent_id = ?";
		try {
			result = exceuteQuery(sql, id);
			Map map = null;
			while (result.next()) {
				map = new HashMap();
				map.put("id", result.getInt(1));
				map.put("name", result.getString(2));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> likeSelect(Serializable name) {
		System.out.println("dao----------->" + name);
		List<Product> pro = null;
		String sql = "SELECT *  FROM easybuy_product;";
		try {
			result = exceuteQuery(sql);
			pro = ResultSet_Util.selectAllsa(result, Product.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

	/**
	 * 新增的方法
	 */
	@Override
	public int add(User user) {

		String sql = "insert into easybuy_user(loginName,password,email,mobile) values(?,?,?,?)";

		Object[] param = { user.getLoginName(), user.getPassword(),
				user.getEmail(), user.getMobile() };

		int num = exceuteUpdate(sql, param);

		return num;
	}

	@Override
	public int delete(Serializable id) {
		/* 删除用户 */
		String sql = "delete from easybuy_user where id=?";
		int update = exceuteUpdate(sql, id);
		return update;
	}

	@Override
	public int update(User t) {
		/*
		 * //修改数据 StringBuffer bf=new StringBuffer(); StringBuffer bf11=new
		 * StringBuffer(); StringBuffer bf1=new StringBuffer(); // String []
		 * nums
		 * ={"id","loginName","userName","password","sex","identityCode","email"
		 * ,"mobile","type"};
		 * 
		 * 
		 * List<Object> list=new ArrayList(); List<String> str=new ArrayList();
		 * if(t.getLoginName()!=null){bf.append(t.getLoginName()+",");str.add(
		 * "loginName=?");list.add(t.getLoginName());};
		 * if(t.getUserName()!=null)
		 * {bf.append(t.getUserName()+",");str.add("userName=? "
		 * );list.add(t.getUserName());};
		 * if(t.getPassword()!=null){bf.append(t.getPassword
		 * ()+",");str.add("password=? ");list.add(t.getPassword());};
		 * if(t.getSex
		 * ()!=null){bf.append(t.getSex()+",");str.add("sex=? ");list.
		 * add(t.getSex());};
		 * if(t.getIdentityCode()!=null){bf.append(t.getIdentityCode
		 * ()+",");str.add("identityCode=? ");list.add(t.getIdentityCode());};
		 * if
		 * (t.getEmail()!=null){bf.append(t.getEmail()+",");str.add("email=? ")
		 * ;list.add(t.getEmail());};
		 * if(t.getMobile()!=null){bf.append(t.getMobile
		 * ()+",");str.add("mobile=? ");list.add(t.getMobile());};
		 * if(t.getType()
		 * !=null){bf.append(t.getType()+",");str.add("type=? ");list
		 * .add(t.getType());};
		 * 
		 * 
		 * 
		 * 
		 * for (int i = 0; i < str.size(); i++) {
		 * 
		 * if (i==str.size()-1) { bf11.append(str.get(i)); }else {
		 * bf11.append(str.get(i)+","); }
		 * 
		 * 
		 * }
		 * 
		 * String
		 * sql="update cloudshopping_user set "+bf11.toString()+" where id=?";
		 * 
		 * 
		 * Object[] params=new Object[list.size()+1];
		 * 
		 * for (int i = 0; i < params.length-1; i++) { params[i]=list.get(i);
		 * 
		 * } params[list.size()]=t.getId(); int update =
		 * exceuteUpdate(sql,params );
		 */

		return 1;
	}

	/**
	 * 查看所有的方法
	 */
	@Override
	public List<User> selectAll() {

		List<User> list = new ArrayList();

		String sql = "select * from easybuy_user";

		try {

			result = exceuteQuery(sql);

			/*
			 * ResultSetMetaData metaData = result.getMetaData(); int
			 * columnCount = metaData.getColumnCount();
			 * 
			 * for(int i=1;i<=columnCount;i++){
			 * 
			 * System.err.print(metaData.getColumnName(i)+"\t");
			 * System.err.println("\t"+metaData.getTableName(i)); }
			 * System.err.println();
			 */

			// 通过反射属性为对象赋值
			// list = resultSetUtil.selectAlls(result, User.class);
			// 通过反射setter()方法为对象赋值(这个比较符合实际的)

			list = ResultSet_Util.selectAllsa(result, User.class);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAss(conn, pre, result);

		}
		return list;
	}

	/**
	 * 登录的方法
	 */
	@Override
	public User login(String userName, String passWord) {

		String sql = "Select * From easybuy_user where (loginName=? or email=? or mobile=?) and passWord=?";
		Object[] param = { userName, userName, userName, passWord };
		User user = null;

		try {
			/* 调用返回用户的所有信息 */
			result = exceuteQuery(sql, param);
			/* 获取到登录用户的所有方法 */
			// user=resultSetUtil.selectAll(result, User.class);
			/* 获取到登录用户的所有方法 */
			user = ResultSet_Util.selectAlla(result, User.class);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeAss(conn, pre, result);

		}

		/* 返回用户 */
		return user;
	}

	@Override
	public User select_Id(Serializable id) {

		String sql = "select * from easybuy_user where id=?";
		// 给参数赋值
		Object[] params = { id };
		User user = null;
		try {
			result = exceuteQuery(sql, params);
			user = ResultSet_Util.selectAlla(result, User.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAss(conn, pre, result);
		}
		return user;
	}

	@Override
	public User loginPwd(String userName) {
		String sql = "Select * From easybuy_user where loginName=? or email=? or mobile=?";
		Object[] param = { userName, userName, userName };
		User user = null;

		try {
			/* 调用返回用户的所有信息 */
			result = exceuteQuery(sql, param);
			/* 获取到登录用户的所有方法 */
			// user=resultSetUtil.selectAll(result, User.class);
			/* 获取到登录用户的所有方法 */
			user = ResultSet_Util.selectAlla(result, User.class);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close_();
			// 关闭资源
			// closeAss(conn, pre, result);

		}

		/* 返回用户 */
		return user;
	}

	@Override
	public List<String> findAllName() {
		List<String> names = new ArrayList<String>();
		String sql = "select name from easybuy_product ";
		try {
			result = exceuteQuery(sql);
			while (result.next()) {
				names.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}
}
