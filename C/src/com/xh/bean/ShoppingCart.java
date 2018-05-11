package com.xh.bean;

public class ShoppingCart implements java.io.Serializable {
	// Fields

	private Integer userId;
	private Integer productId;
	private Integer productNum;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public ShoppingCart(Integer userId, Integer productId, Integer productNum) {
		this.userId = userId;
		this.productId = productId;
		this.productNum = productNum;
	}
	public ShoppingCart() {
	}
	@Override
	public String toString() {
		return "ShoppingCart [userId=" + userId + ", productId=" + productId
				+ ", productNum=" + productNum + "]";
	}

}