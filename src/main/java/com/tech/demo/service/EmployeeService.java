package com.tech.demo.service;

import java.util.List;

import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.LoginDto;
import com.tech.demo.dto.LoginReturnDto;
import com.tech.demo.model.Employee;

public interface EmployeeService {

	 EmployeeDto getEmployee(Long id) throws Exception;
	 
	 List<EmployeeDto> getAllEmployee()throws Exception;
	 
	 void createEmployee(EmployeeDto employeeDto) throws Exception;
	 
	// Employee dtoToEmployee(EmployeeDto employeeDto);
	 
	// EmployeeDto employeeToDto(Employee employee);
	 
	 void deleteEmployee(Long id)throws Exception;
	 
	 void updateEmployee(EmployeeDto employeeDto)throws Exception;
	 
	LoginReturnDto loginEmployee(LoginDto loginDto)throws Exception;
	
}
