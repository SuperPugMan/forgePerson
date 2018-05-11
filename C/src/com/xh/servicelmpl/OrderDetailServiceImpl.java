package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.OrderDetail;
import com.xh.dao.OrderDatailDao;
import com.xh.dao.lmpl.OrderDatailDaolmpl;
import com.xh.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

	Logger logger = Logger.getLogger(OrderDetailServiceImpl.class);
	OrderDatailDao OrderDetail = new OrderDatailDaolmpl();

	@Override
	public boolean add(OrderDetail t) {
		// TODO Auto-generated method stub

		int add = OrderDetail.add(t);

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
		int delete = OrderDetail.delete(id);
		if (delete > 0) {
			logger.info("删除成功！");
			return true;

		} else {
			logger.info("删除失败！");
			return false;
		}

	}

	@Override
	public boolean updata(OrderDetail t) {
		// TODO Auto-generated method stub

		int update = OrderDetail.update(t);
		if (update > 0) {
			System.err.println("删除成功！");
			return true;

		} else {
			System.err.println("删除失败！");
			return false;
		}

	}

	@Override
	public List<OrderDetail> select() {
		// TODO Auto-generated method stub
		List<OrderDetail> selectAll = OrderDetail.selectAll();

		return selectAll;
	}

	@Override
	public OrderDetail select_Id(Serializable id) {
		// TODO Auto-generated method stub
		OrderDetail select_Id = OrderDetail.select_Id(id);

		return select_Id;
	}

	/*
	 * @Override public boolean add(OrderDetail t) { // TODO Auto-generated
	 * method stub int add = OrderDetail.add(t);
	 * 
	 * if (add>0) { System.err.println("新增成功！");
	 * 
	 * }else { System.err.println("新增失败！"); }
	 * 
	 * }
	 * 
	 * @Override public void delete(Serializable id) { // TODO Auto-generated
	 * method stub int delete = OrderDetail.delete(id); if (delete>0) {
	 * System.err.println("删除成功！");
	 * 
	 * }else { System.err.println("删除失败！"); }
	 * 
	 * 
	 * }
	 * 
	 * @Override public void updata(OrderDetail t) { // TODO Auto-generated
	 * method stub
	 * 
	 * 
	 * }
	 * 
	 * @Override public List<OrderDetail> select() { // TODO Auto-generated
	 * method stub List<OrderDetail> selectAll = OrderDetail.selectAll();
	 * 
	 * 
	 * 
	 * return selectAll; }
	 * 
	 * @Override public OrderDetail select_Id(Serializable id) { // TODO
	 * Auto-generated method stub OrderDetail select_Id =
	 * OrderDetail.select_Id(id);
	 * 
	 * 
	 * return select_Id; }
	 */

}
