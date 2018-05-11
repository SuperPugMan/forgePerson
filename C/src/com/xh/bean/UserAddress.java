package com.xh.bean;

import java.sql.Timestamp;

/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-5-2下午3:12:28  用户住址
 *
 */

public  class UserAddress implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;//用户ID
	private String address;//地址
	private Timestamp createTime;//创建时间
	private Integer isDefault;//是否是默认地址（1：是 0：否）
	private String remark;//备注

	// Constructors

	/** default constructor */
	public UserAddress() {
	}

	/** full constructor */
	public UserAddress(Integer userId, String address,
			Timestamp createTime, Integer isDefault, String remark) {
		this.userId = userId;
		this.address = address;
		this.createTime = createTime;
		this.isDefault = isDefault;
		this.remark = remark;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {

		this.remark = remark;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", userId=" + userId + ", address="
				+ address + ", createTime=" + createTime + ", isDefault="
				+ isDefault + ", remark=" + remark + "]";
	}

	
	
	
	
	
	
}