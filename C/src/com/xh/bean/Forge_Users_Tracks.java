package com.xh.bean;

import java.io.Serializable;

import com.xh.service.ProductService;
import com.xh.servicelmpl.ProductServiceImpl;

/**
 * 
 * 未来的你会感谢现在奋斗的你！ 用户足迹 浏览过的商品记录
 * 
 */
public class Forge_Users_Tracks implements Serializable {

	@Override
	public String toString() {
		return "Forge_Users_Tracks [userId=" + userId + ", productId="
				+ productId + ", viewTime=" + viewTime + "]";
	}

	private String userId; // 用户ID
	private String productId; // 商品ID
	private String viewTime; // 用户的浏览时间

	public Forge_Users_Tracks() {
		super();
	}

	public Forge_Users_Tracks(String userId, String productId, String viewTime) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.viewTime = viewTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getViewTime() {
		return viewTime;
	}

	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}

	public String getProductName() {
		ProductService proSer = new ProductServiceImpl();
		System.out.println("根据ID查询名称--->id为" + getProductId());
		String name = proSer.selectBuId(getProductId());
		return name;
	}
}
