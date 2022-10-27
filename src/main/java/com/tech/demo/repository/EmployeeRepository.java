package com.tech.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Employee findEmployeeByContactNo(Long contact_no);
	
	public Employee findEmployeeByAadharAndMailId(String aadhar,String mailId );
	
	public Employee findEmployeeByContactNoOrMailId(Long contactNo,String mailId);
	
	public Employee findEmployeeByMailId(String mailId);
	
	//public Employee findEmployeeByEmployeeId(Long employeeId);


	
	

}
