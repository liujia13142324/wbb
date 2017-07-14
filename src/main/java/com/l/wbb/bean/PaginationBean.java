package com.l.wbb.bean;

import java.util.List;

public class PaginationBean <T> {
	//请求参数
	private Integer pageSize=10 ;
	//当前页
	private Integer page = 1;
	//响应参数
	private Integer allPage;
	private Integer total;
	private List<T> rows;
	

	@Override
	public String toString() {
		return "PaginationBean [pageSize=" + pageSize + ", page=" + page +  ", allPage="
				+ allPage + ", total=" + total + ", rows=" + rows + "]";
	}
	public PaginationBean() {
		
	}
	public PaginationBean(int page, int allPage, List<T> rows , int total) {
		this.page = page;
		this.allPage = allPage;
		this.rows = rows;
		this.total = total;
	}
	
	public PaginationBean(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
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
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public  List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
