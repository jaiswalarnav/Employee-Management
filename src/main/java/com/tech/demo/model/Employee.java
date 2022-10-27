package com.tech.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

import com.tech.demo.model.support.Support;

@Entity
public class Employee extends Support {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(nullable=false,name="contactNo",unique=true)
	private String contactNo;
	
	@Column(nullable=false)
	private String mailId;
	
	
	@Column(nullable= false)
	private String sex;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	private Date doj;
	
	@Column(nullable=false)
	private int age;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String aadhar;
	
//	@Column(columnDefinition="boolean default false")
//	private boolean is_deleted;
//	
//	@Column
//	private Long created_at;
//	
//	@Column
//	private Long deleted_at;
//	
//	@Column
//	private Long updated_at;
	
	@Column(nullable=false)
	private String designation;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="employee")
	private List<Experience> experiences;
	
//	private String token;
	
//	@OneToMany(targetEntity = Experience.class ,cascade = CascadeType.ALL)
//	@JoinColumn(name="empId",referencedColumnName = "id")
//	private List<Experience> experiences;
//		
//	@OneToOne(cascade=CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Education education;
	
//	@OneToOne(targetEntity=Education.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="eduId",referencedColumnName="id")
//	private Education education;

	
//	public String getToken() {
//		return token;
//	}
//
//
//	public void setToken(String token) {
//		this.token = token;
//	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


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

//	public boolean getIs_deleted() {
//		return is_deleted;
//	}
//
//	public void setIs_deleted(boolean is_deleted) {
//		this.is_deleted = is_deleted;
//	}
//
//	public Long getCreated_at() {
//		return created_at;
//	}
//
//	public void setCreated_at(Long created_at) {
//		this.created_at = created_at;
//	}
//
//	public Long getDeleted_at() {
//		return deleted_at;
//	}
//
//	public void setDeleted_at(Long deleted_at) {
//		this.deleted_at = deleted_at;
//	}
//
//	public Long getUpdated_at() {
//		return updated_at;
//	}
//
//	public void setUpdated_at(Long updated_at) {
//		this.updated_at = updated_at;
//	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}


//	public Education getEducation() {
//		return education;
//	}
//
//
//	public void setEducation(Education education) {
//		this.education = education;
//	}
//	
	
	
	

}
