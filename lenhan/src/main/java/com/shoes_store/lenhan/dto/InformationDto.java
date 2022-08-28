package com.shoes_store.lenhan.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class InformationDto {

	@Pattern(regexp = "\\d*", message = "Information id must be a number")
	private Integer informationId;
	@NotEmpty(message = "First name must not be empty")
	private String firstName;
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;
	@NotEmpty(message = "Date of birth must not be empty")
	private Date dateOfBirth;
	@NotEmpty(message = "Staff code must not be empty")
	private String staffCode;
	@NotEmpty(message = "Location must not be empty")
	private String location;
	@NotEmpty(message = "Account must not be empty")
	private AccountDto account;
	
	public Integer getInformationId() {
		return informationId;
	}
	public void setInformationId(Integer informationId) {
		this.informationId = informationId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
}
