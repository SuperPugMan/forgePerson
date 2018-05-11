package com.xh.util;

import java.io.Serializable;
import java.util.List;


public class PageInfo<T> implements Serializable {
	// 当前页---->
	private int pageNum =1 ;
	
	// 每页显示的数量
	private int pageSize =6;
	

	// 总记录数，在数据库获取coutn(*)
	private int total;
	
	// 总页数
	private int pages;
	
	// 结果集,要查询的T运行的,类型！
	private List<T> list;

	public PageInfo() {
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		if (total > 0) {
			this.total = total;
			// 获取总页数
			this.pages = (total % pageSize == 0) ? (total / pageSize) : (total/ pageSize + 1);
			System.err.println(pages+"=============页数");
		}
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
