package com.shoes_store.lenhan.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AccountDto {

	@Pattern(regexp = "\\d*", message = "Account id must be a number")
	private Integer accountId;
	@NotEmpty(message = "Username must not be empty")
	private String username;
	@NotEmpty(message = "Password must not be empty")
	private String password;
	private boolean status;
	@NotEmpty(message = "Password must not be empty")
	private RoleDto role;
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public RoleDto getRole() {
		return role;
	}
	public void setRole(RoleDto role) {
		this.role = role;
	}
	
}
