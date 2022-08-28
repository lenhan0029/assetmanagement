package com.shoes_store.lenhan.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CategoryDto {
	@Pattern(regexp = "\\d*", message = "Category id must be a number")
	private Integer categoryId;
	@NotEmpty(message = "Category name must not be empty")
	private String categoryName;
	@NotEmpty(message = "key must not be empty")
	private String key;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
