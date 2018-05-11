package com.xh.bean;

/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-5-2下午3:14:26
 *
 */

public class OrderDetail implements java.io.Serializable {

	// Fields

	private Integer id;//
	private Integer orderId;//订单主键
	private Integer productId;//商品主键
	private Integer quantity;//数量   买多少
	private Float cost;//消费,单个商品的消费 

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(Integer orderId, Integer productId,
			Integer quantity, Float cost) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId
				+ ", productId=" + productId + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}

	
	
	
	
	
	
}