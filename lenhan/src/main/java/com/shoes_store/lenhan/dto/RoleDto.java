package com.shoes_store.lenhan.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RoleDto {
	@Pattern(regexp = "\\d*", message = "Role id must be a number")
	private Integer roleId;
	@NotEmpty(message = "Role name must not be empty")
	private String roleName;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
