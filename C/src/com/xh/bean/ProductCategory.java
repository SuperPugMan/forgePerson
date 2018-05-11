package com.xh.bean;


/**
 * 
 * @author LSZ
 *
 * 非宁静无以致远！
 * 2018-5-3下午5:09:22   分级实体类
 *
 */

public class ProductCategory implements java.io.Serializable {


	private Integer id;
	private String name;//名称
	private Integer parentId;//父级目录ID
	private Integer type;//级别（1,2,3）级
	private String iconClass;//图标


	/** default constructor */
	public ProductCategory() {
	}

	/** minimal constructor */
	public ProductCategory(String name, Integer parentId) {
		this.name = name;
		this.parentId = parentId;
	}

	/** full constructor */
	public ProductCategory(String name, Integer parentId, Integer type,
			String iconClass) {
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
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

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIconClass() {
		return this.iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", type=" + type + ", iconClass=" + iconClass
				+ "]";
	}

	
	
	
}