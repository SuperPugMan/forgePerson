package com.forge.bean;

import java.io.Serializable;

import com.forge.dao.impl.OrderDaoImpl;

public class Order_Detail implements Serializable {
	//订单详情ID
	private int id;
	//订单ID
	private int orderId;
	//商品ID
	private int productId;
	public String getSerizalNumber() {
		OrderDaoImpl orderdao=new OrderDaoImpl();
		String serialNum = orderdao.orderById(getOrderId());
		return serialNum;
	}
	public String getName() {
		OrderDaoImpl orderdao=new OrderDaoImpl();
		String productname = orderdao.productById(getProductId());
		return productname;
	}
	//商品数量
	private int quanTity;
	//商品金额
	private double cost;
	
	public Order_Detail(int orderId, int productId, 
			int quanTity, double cost) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quanTity = quanTity;
		this.cost = cost;
	}
	public Order_Detail(int id) {
		super();
		this.id = id;
	}
	public Order_Detail() {
		super();
	}
	public Order_Detail(int id, int orderId, int productId, 
			int quanTity, double cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quanTity = quanTity;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuanTity() {
		return quanTity;
	}
	public void setQuanTity(int quanTity) {
		this.quanTity = quanTity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
