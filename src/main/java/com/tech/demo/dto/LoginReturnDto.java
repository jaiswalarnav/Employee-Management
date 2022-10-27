package com.tech.demo.dto;

public class LoginReturnDto {

	private String firstName;
	
	private String lastName;
	
	private String token;
	
	public LoginReturnDto(String firstName, String lastName, String token) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = token;
	}

	public LoginReturnDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginReturnDto [firstName=" + firstName + ", lastName=" + lastName + ", token=" + token + "]";
	}

	
	
	
	
}
