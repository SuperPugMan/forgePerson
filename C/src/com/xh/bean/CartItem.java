package com.xh.bean;

import java.io.Serializable;

/**
 * 购物项（购物车中的内容）
 * 
 * @param <T>CartItem
 */
// public class CartItem<T> {
public class CartItem implements Serializable {
	private Product product; // 商品
	private int num; // 数量
	private double price; // 商品的总价
	private int userId;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 商品的总金额
	public double getPrice() {
		return product.getPrice() * num;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num + ", price="
				+ price + "]";
	}

}
