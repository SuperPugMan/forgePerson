package com.forge.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.forge.bean.User;
import com.forge.dao.UserDao;
import com.forge.util.jdbcUtil;
import com.forge.util.resultSetUtil;




public class UserDaoImpl extends jdbcUtil implements UserDao {

	@Override
	public int add(User t) {
		int num=0;
		String sql="INSERT INTO `forge_users`(`loginName`,`password`,`email`,`phone`,`address`) VALUES (?,?,?,?,?);";
		Object[] param={t.getLoginName(),t.getPassword(),t.getEmail(),t.getPhone(),t.getAddress()};
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
		String sql="DELETE FROM `forge_users` WHERE userid=?;";
		int num=0;
		try {
			num = myexcuteUpdate(sql,id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(Serializable id,User user) {
		int num=0;
		String sql="UPDATE `forge_users` SET  loginName=?,phone=?,email=?,address=?where userid=?;";
		Object []param={user.getLoginName(),user.getPhone(),user.getEmail(),user.getAddress(),id};
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
	public List<User> findAll() {
		List<User> list=null;
		String sql="SELECT * FROM `forge_users`;";
		try {
			rs = myexcuteQuery(sql);
			list = resultSetUtil.findAll(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User findById(Serializable id) {
		User user=null;
		String sql="SELECT * FROM `forge_users` WHERE `userId`=?;";
		try {
			rs = myexcuteQuery(sql,id);
			user=resultSetUtil.findById(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User login(String email,String password) {
		String sql="SELECT * FROM forge_users WHERE loginName=? AND password=?;";
		Object[] param={email,password};
		User user= null;
		try {
			rs=myexcuteQuery(sql, param);
			user=resultSetUtil.findById(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findByName(String name) {
		String sql="select phone ,email,address from forge_users where loginName=?";
		User user=null;
		try {
			ResultSet rs = myexcuteQuery(sql, name);
			user = resultSetUtil.findById(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
