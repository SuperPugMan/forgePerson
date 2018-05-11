package com.forge.bean;

import java.io.Serializable;
import java.util.Date;


public class Order implements Serializable {
	private int id;
	private String loginName;
	private Date createTime;
	private String userAddress;
	private double cost;
	private int status;

	private String serialNumber;
	
	public Order(int id) {
		super();
		this.id = id;
	}
	public Order(String loginName, Date createTime, double cost, int status,
			String serialNumber) {
		super();
		this.loginName = loginName;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.serialNumber = serialNumber;
	}
	public Order() {
		super();
	}
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", loginName=" + loginName + ", createTime="
				+ createTime + ", userAddress=" + userAddress + ", cost="
				+ cost + ", status=" + status + ", serialNumber="
				+ serialNumber + "]";
	}
	public Order(int id, String loginName, Date createTime, double cost,
			int status, String serialNumber) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.serialNumber = serialNumber;
	}
	
	public Order(int id, String loginName, Date createTime, String address,
			double cost, int status, String serialNumber) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.createTime = createTime;
		this.userAddress = address;
		this.cost = cost;
		this.status = status;
		this.serialNumber = serialNumber;
	}


	public Order(int id, String loginName, Date createTime, String userAddress,
			double cost, String serialNumber) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.createTime = createTime;
		this.userAddress = userAddress;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}
