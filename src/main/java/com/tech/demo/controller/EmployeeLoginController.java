package com.tech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.LoginDto;
import com.tech.demo.dto.LoginReturnDto;
import com.tech.demo.dto.http.response.DataResponse;
import com.tech.demo.service.EmployeeService;
import com.tech.demo.validator.Validations;

@RestController
@RequestMapping("/api1")
public class EmployeeLoginController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/login")
	public DataResponse login(@RequestBody LoginDto loginDto) {
		
		try {
//			EmployeeDto employeeDto= employeeService.loginEmployee(loginDto);
			
			Validations validation=new Validations();
			
			String[] requestedArray= {"loginId","password"};
			
			DataResponse res=validation.validate(loginDto, requestedArray);
			
			if(res!=null)
				return res;
			
			LoginReturnDto loginReturnDto= employeeService.loginEmployee(loginDto);
			
			return new DataResponse(200,"LOGIN_SUCCESSFULL",loginReturnDto);
		}
		
		catch (Exception e) {
			
			return new DataResponse(404,e.getMessage(),null);
		}
		
	}
	
	
	

}
