package com.xh.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author LSZ
 *  用户 
 */
public class News implements Serializable{

	private Integer id;
	private String title;
	private String content;
	private Date createTime;
	private String img;
	private String module;
	
	public News() {
		super();
	}
	public News(Integer id, String title, String content, Date createTime,String module) {

		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.module = module;
	}
	
	
	
	
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", createTime=" + createTime + "]";
	}


}
