package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.UserAddress;
import com.xh.dao.User_addressDao;
import com.xh.dao.lmpl.User_addressDaoImpl;
import com.xh.service.UserAddressService;


public class UserAddressServiceImpl implements UserAddressService {
	
	private static Logger logger=Logger.getLogger(UserAddressServiceImpl.class);
	User_addressDao user=new User_addressDaoImpl();

	@Override
	public boolean add(UserAddress t) {
		// TODO Auto-generated method stub
		
		int add = user.add(t);

		if (add>0) {
			logger.debug("新增成功！");
			return true;

		}else {
			logger.debug("新增失败！");
			return false;
		}
		
		
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		
		int delete = user.delete(id);
		if (delete>0) {
			logger.debug("删除成功！");
			return true;

		}else {
			logger.debug("删除失败！");
			return false;
		}
		
		
	}

	@Override
	public boolean updata(UserAddress t) {
		// TODO Auto-generated method stub
		
		int update = user.update(t);
		if (update>0) {
			logger.debug("更新成功！");
			return false;

		}else {
			logger.debug("更新失败！");
			return false;
		}
		
		
	}

	@Override
	public List<UserAddress> select() {
		// TODO Auto-generated method stub
		List<UserAddress> selectAll = user.selectAll();

		return selectAll;
	}

	@Override
	public UserAddress select_Id(Serializable id) {
		// TODO Auto-generated method stub
		UserAddress select_Id = user.select_Id(id);

		return select_Id;
	}

}
