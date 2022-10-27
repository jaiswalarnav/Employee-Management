package com.tech.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class EmployeeDto {

	private Long id;
	
	@NotBlank(message="firstName can not be empty")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message="contactNo can not be empty")
	@Size(min=10,max=10)
	private String contactNo;
	
	@Email
	@NotBlank(message="mailId can not be empty")
	private String mailId;
	
	@NotBlank(message="sex can not be blank")
	private String sex;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message="doj can not be null")
//	@NotEmpty(message="doj can not be empty")
	private Date doj;
	
	@NotNull(message="age can not be null")
//	@NotEmpty(message="age can not be empty")
	private int age;
	
	@NotBlank(message="address can not be empty")
	private String address;
	
	@NotBlank(message="aadhar can not be empty")
	private String aadhar;
	
//	private boolean isDeleted;
//	
//	private Long createdAt;
//	
//	private Long deletedAt;
//	
//	private Long updatedAt;
	
	@NotBlank(message="designation can not be empty")
	private String designation;
	
	@NotBlank(message="password can not be empty")
	private String password;
	
	private List<ExperienceDto> experienceDtos;
	
	private EducationDto educationDto;
	
//	private String token;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
//	public boolean getIsDeleted() {
//		return isDeleted;
//	}
//	public void setIsDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//	public Long getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(Long createdAt) {
//		this.createdAt = createdAt;
//	}
//	public Long getDeletedAt() {
//		return deletedAt;
//	}
//	public void setDeletedAt(Long deletedAt) {
//		this.deletedAt = deletedAt;
//	}
//	public Long getUpdatedAt() {
//		return updatedAt;
//	}
//	public void setUpdatedAt(Long updatedAt) {
//		this.updatedAt = updatedAt;
//	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<ExperienceDto> getExperienceDtos() {
		return experienceDtos;
	}
	public void setExperienceDtos(List<ExperienceDto> experienceDtos) {
		this.experienceDtos = experienceDtos;
	}
	public EducationDto getEducationDto() {
		return educationDto;
	}
	public void setEducationDto(EducationDto educationDto) {
		this.educationDto = educationDto;
	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
	
	
	
	
}
