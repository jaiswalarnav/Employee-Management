package com.tech.demo.dto;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tech.demo.model.Employee;


public class EducationDto {

	private long id;

//	@NotBlank(message="highSchool can not be empty")
	@NotNull(message="highSchool can not be null")
	private String highSchool;

	@NotNull(message="hsPercent can not be null")
	private float hsPercent;

	private String seniorSchool;

	private float ssPercent;

	private String underGrad;

	private float ugPercent;

	private String postGrad;

	private float pgPercent;

	private String other;

//	private boolean isDeleted;
//
//	private Long createdAt;
//
//	private Long deletedAt;
//
//	private Long updatedAt;

//	private EmployeeDto employeeDto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public float getHsPercent() {
		return hsPercent;
	}

	public void setHsPercent(float hsPercent) {
		this.hsPercent = hsPercent;
	}

	public String getSeniorSchool() {
		return seniorSchool;
	}

	public void setSeniorSchool(String seniorSchool) {
		this.seniorSchool = seniorSchool;
	}

	public float getSsPercent() {
		return ssPercent;
	}

	public void setSsPercent(float ssPercent) {
		this.ssPercent = ssPercent;
	}

	public String getUnderGrad() {
		return underGrad;
	}

	public void setUnderGrad(String underGrad) {
		this.underGrad = underGrad;
	}

	public float getUgPercent() {
		return ugPercent;
	}

	public void setUgPercent(float ugPercent) {
		this.ugPercent = ugPercent;
	}

	public String getPostGrad() {
		return postGrad;
	}

	public void setPostGrad(String postGrad) {
		this.postGrad = postGrad;
	}

	public float getPgPercent() {
		return pgPercent;
	}

	public void setPgPercent(float pgPercent) {
		this.pgPercent = pgPercent;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

//	public boolean getIsDeleted() {
//		return isDeleted;
//	}
//
//	public void setIsDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//
//	public Long getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Long createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Long getDeletedAt() {
//		return deletedAt;
//	}
//
//	public void setDeletedAt(Long deletedAt) {
//		this.deletedAt = deletedAt;
//	}
//
//	public Long getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Long updatedAt) {
//		this.updatedAt = updatedAt;
//	}

//	public EmployeeDto getEmployeeDto() {
//		return employeeDto;
//	}
//
//	public void setEmployeeDto(EmployeeDto employeeDto) {
//		this.employeeDto = employeeDto;
//	}

}
