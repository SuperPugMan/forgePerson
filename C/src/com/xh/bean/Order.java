package com.xh.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * EasybuyOrder entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;// 用户主键
	private String loginName;// 登录名字
	private String userAddress;// 用户住址
	private Date createTime;// 创建时间
	private Float cost;// 总消费
	private String serialNumber;// 订单号

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Integer userId, String loginName, String userAddress,
			Timestamp createTime, Float cost, String serialNumber) {
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {

		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", loginName="
				+ loginName + ", userAddress=" + userAddress + ", createTime="
				+ createTime + ", cost=" + cost + ", serialNumber="
				+ serialNumber + "]";
	}

}