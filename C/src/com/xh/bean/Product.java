package com.xh.bean;

/**
 * EasybuyProduct entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;//名字
	private String description;//描述	
	private Float price;//单价
	private Integer stock;//库存
	private Integer categoryLevel1id;//分类1
	private Integer categoryLevel2id;//分类2
	private Integer categoryLevel3id;//分类3
	private String fileName;//文件名称
	private Integer isDelete;//是否删除  0/1：删除

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String name, Float price, Integer stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	/** full constructor */
	public Product(String name, String description, Float price,
			Integer stock, Integer categoryLevel1id, Integer categoryLevel2id,
			Integer categoryLevel3id, String fileName, Integer isDelete) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1id = categoryLevel1id;
		this.categoryLevel2id = categoryLevel2id;
		this.categoryLevel3id = categoryLevel3id;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCategoryLevel1id() {
		return this.categoryLevel1id;
	}

	public void setCategoryLevel1id(Integer categoryLevel1id) {
		this.categoryLevel1id = categoryLevel1id;
	}

	public Integer getCategoryLevel2id() {
		return this.categoryLevel2id;
	}

	public void setCategoryLevel2id(Integer categoryLevel2id) {
		this.categoryLevel2id = categoryLevel2id;
	}

	public Integer getCategoryLevel3id() {
		return this.categoryLevel3id;
	}

	public void setCategoryLevel3id(Integer categoryLevel3id) {
		this.categoryLevel3id = categoryLevel3id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock
				+ ", categoryLevel1id=" + categoryLevel1id
				+ ", categoryLevel2id=" + categoryLevel2id
				+ ", categoryLevel3id=" + categoryLevel3id + ", fileName="
				+ fileName + ", isDelete=" + isDelete + "]";
	}

	
	
	
}