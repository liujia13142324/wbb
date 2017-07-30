package com.l.wbb.bean;

public class Category {

	private Integer CategoryId;
	private String name;
	public Category(Integer categoryId, String name) {
		super();
		CategoryId = categoryId;
		this.name = name;
	}
	
	public Category() {
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", name=" + name + "]";
	}

	public Integer getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
