package com.forge.bean;

import java.util.Date;

public class News {
	private String title;
	private String content;
	private Date createTime;
	private String img;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", content=" + content
				+ ", createTime=" + createTime + ", img=" + img + "]";
	}
	public News(String title, String content, Date createTime, String img) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.img = img;
	}
	public News(String title, String content, String img) {
		super();
		this.title = title;
		this.content = content;
		this.img = img;
	}
	public News() {
		super();
	}
	
}
