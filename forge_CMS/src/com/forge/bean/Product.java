package com.forge.bean;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private String description;
	private double price;
	//商品库存
	private int stock;
	private int categorylevel1;
	private int categorylevel2;
	private int categorylevel3;
	//上传照片文件名
	private String fileName;
	private int score;
	
	public Product() {
		super();
	}
	public Product(int id, String name, String productDesc,
			double productPrice, int productStock, int productLevOne,
			int productLevTwo, int productLevThree, String fileName, int score) {
		super();
		this.id = id;
		this.name = name;
		this.description = productDesc;
		this.price = productPrice;
		this.stock = productStock;
		this.categorylevel1 = productLevOne;
		this.categorylevel2 = productLevTwo;
		this.categorylevel3 = productLevThree;
		this.fileName = fileName;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategorylevel1() {
		return categorylevel1;
	}
	public void setCategorylevel1(int categorylevel1) {
		this.categorylevel1 = categorylevel1;
	}
	public int getCategorylevel2() {
		return categorylevel2;
	}
	public void setCategorylevel2(int categorylevel2) {
		this.categorylevel2 = categorylevel2;
	}
	public int getCategorylevel3() {
		return categorylevel3;
	}
	public void setCategorylevel3(int categorylevel3) {
		this.categorylevel3 = categorylevel3;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
