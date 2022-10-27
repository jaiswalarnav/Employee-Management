package com.tech.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tech.demo.model.support.Support;

@Entity
public class Experience extends Support {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "empId", nullable = false)
	private Employee employee;
    
	private String companyName;

	private Long startDate;

	private Long endDate;

	private String location;

	private String designation;
//
//	@Column(columnDefinition = "boolean default false")
//	private boolean isDeleted;
//
//	private Long createdAt;
//
//	private Long deletedAt;
//
//	private Long updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

//	public Long getEmpid() {
//		return empid;
//	}
//
//	public void setEmpid(Long empid) {
//		this.empid = empid;
//	}

}
