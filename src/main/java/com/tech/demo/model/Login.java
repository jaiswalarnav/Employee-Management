package com.tech.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tech.demo.model.support.Support;

@Entity
public class Login extends  Support{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
//	private String mailId;
//	
//	private Long contactNo;
	
	private String loginId;
	
	private String password;
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	

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
	
	

}
