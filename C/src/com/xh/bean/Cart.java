package com.xh.bean;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 购物车
 */
public class Cart {

	// 必须有一个集合来保存所有的商品
	private Map<String, CartItem> map = new LinkedHashMap();
	// 所有商品的总价
	private double price;

	// 新增商品
	public void addProduct(Product product,int num) {
		System.out.println("进入addProduct===========》");
		// 第一次购物项 肯定 为null
		CartItem cartItem = map.get(product.getId().toString());
		if (cartItem == null) { // 证明购物车中什么都没有
			System.out.println("=========>进入nullcartItem");
			cartItem = new CartItem(); // 实例化购物项
			// 将用户传递来的商品放进购物项中
			cartItem.setProduct(product);
			cartItem.setNum(num);
			// 把购物项放进购物车
			map.put(product.getId().toString(), cartItem);
		} else {
			// 如果存在商品 该商品数量加1
			System.out.println("商品存在======》");
			cartItem.setNum(cartItem.getNum() + num);
			System.out.println("商品存在======》"+cartItem.getNum());
		}
	}

	/**
	 * @return 所有商品的总价
	 */
	public double getPrice() {
		int totalPrice = 0; // 保存总价
		for (Entry<String, CartItem> product : map.entrySet()) {
			CartItem cartItem = product.getValue();
			totalPrice += cartItem.getPrice();
		}
		return totalPrice;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}