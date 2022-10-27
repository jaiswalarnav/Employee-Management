package com.tech.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.tech.demo.model.support.Support;


@Entity
public class Education extends Support {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    

	@Column(nullable = false)
	private String highSchool;

	@Column(nullable = false)
	private float hsPercent;

	private String seniorSchool;

	private float ssPercent;

	private String underGrad;

	private float ugPercent;

	private String postGrad;

	private float pgPercent;

	private String other;



	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
