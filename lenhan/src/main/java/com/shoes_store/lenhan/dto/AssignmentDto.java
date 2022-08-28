package com.shoes_store.lenhan.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AssignmentDto {

	@Pattern(regexp = "\\d*", message = "Assignment id must be a number")
	private Integer assignmentId;
	@NotEmpty(message = "Assigned date must not be empty")
	private Date assignedDate;
	@NotEmpty(message = "Asset code must not be empty")
	private String note;
	@NotEmpty(message = "State must not be empty")
	private boolean state;
	@NotEmpty(message = "Account must not be empty")
	private AccountDto account;
	@NotEmpty(message = "Asset must not be empty")
	private AssetDto asset;
	public Integer getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}
	public Date getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	public AssetDto getAsset() {
		return asset;
	}
	public void setAsset(AssetDto asset) {
		this.asset = asset;
	}
	
	
}
