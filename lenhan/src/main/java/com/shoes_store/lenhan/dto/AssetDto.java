package com.shoes_store.lenhan.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AssetDto {

	@Pattern(regexp = "\\d*", message = "Asset id must be a number")
	private Integer assetId;
	@NotEmpty(message = "Asset code must not be empty")
	private String assetCode;
	@NotEmpty(message = "Asset name must not be empty")
	private String assetName;
	@NotEmpty(message = "Specification must not be empty")
	private String specification;
	@NotEmpty(message = "Installed date must not be empty")
	private Date installedDate;
	@NotEmpty(message = "Location must not be empty")
	private String location;
	@NotEmpty(message = "State must not be empty")
	private String state;
	@NotEmpty(message = "Category must not be empty")
	private CategoryDto category;
	
	public Integer getAssetId() {
		return assetId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Date getInstalledDate() {
		return installedDate;
	}
	public void setInstalledDate(Date installedDate) {
		this.installedDate = installedDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	
}
