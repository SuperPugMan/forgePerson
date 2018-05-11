package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.Order;
import com.xh.dao.OrderDao;
import com.xh.dao.lmpl.OrderDaolmpl;
import com.xh.service.OrderService;

public class OrderServiceImpl implements OrderService {

	Logger logger = Logger.getLogger(OrderServiceImpl.class);
	OrderDao dao = new OrderDaolmpl();

	@Override
	public boolean add(Order t) {
		// TODO Auto-generated method stub

		int add = dao.add(t);

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

		int delete = dao.delete(id);
		if (delete > 0) {
			logger.info("删除成功！");
			return true;

		} else {
			logger.info("删除失败！");
			return false;
		}

	}

	@Override
	public boolean updata(Order t) {
		// TODO Auto-generated method stub
		int update = dao.update(t);
		if (update > 0) {
			logger.info("更新成功！");
			return true;

		} else {
			logger.info("更新失败！");
			return false;
		}

	}

	@Override
	public List<Order> select() {
		// TODO Auto-generated method stub
		List<Order> selectAll = dao.selectAll();

		return selectAll;
	}

	@Override
	public Order select_Id(Serializable id) {
		// TODO Auto-generated method stub
		Order select_Id = dao.select_Id(id);

		return select_Id;
	}

}
