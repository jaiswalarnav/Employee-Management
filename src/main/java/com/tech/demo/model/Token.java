package com.tech.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Token {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String userToken;
	
	

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Token(Long id, String userToken) {
		super();
		this.id = id;
		this.userToken = userToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", userToken=" + userToken + "]";
	}
	
	

}
