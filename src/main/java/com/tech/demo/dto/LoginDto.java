package com.tech.demo.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {
	
	private Long id;
	
	@NotBlank(message="emailId/contactNo can not empty")
	private String loginId;
	
	@NotBlank(message="password can not be empty")
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getMailId() {
//		return mailId;
//	}
//
//	public void setMailId(String mailId) {
//		this.mailId = mailId;
//	}
//
//	public Long getContactNo() {
//		return contactNo;
//	}
//
//	public void setContactNo(Long contactNo) {
//		this.contactNo = contactNo;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
	
	

}
