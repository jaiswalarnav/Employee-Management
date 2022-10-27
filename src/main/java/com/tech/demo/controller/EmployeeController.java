package com.tech.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.http.response.DataResponse;
import com.tech.demo.dto.http.response.RestResponse;
import com.tech.demo.model.Employee;
import com.tech.demo.model.Token;
import com.tech.demo.repository.EmployeeRepository;
import com.tech.demo.repository.TokenRepository;
import com.tech.demo.service.EmployeeService;
import com.tech.demo.validator.Validations;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TokenRepository tokenRepository;

	@GetMapping("/getEmployee/{empId}")
	@ResponseBody
	public DataResponse getEmployee(@PathVariable Long empId) {
		
		try {

//			String tok=req.getHeader("Authorization").toString();
//			
//			Token token=tokenRepository.findByUserToken(tok);
//			
//			if(token!=null) {
			
			EmployeeDto employeeDto = employeeService.getEmployee(empId);

			return new DataResponse(200, "SUCCESS", employeeDto);

		}
//			else
//				return new DataResponse(404,"INVALID_TOKEN",null);
//		}

		catch (Exception e) {

			return new DataResponse(404, "EMPLOYEE_NOT_FOUND", null);

		}

	
	}

	@GetMapping("/getAllEmployee")
	@ResponseBody
	public DataResponse getAllEmployee() {

		try {
//			String token=req.getHeader("Authorization").toString();
//			Token t=tokenRepository.findByUserToken(token);
////			List<Employee> res = employeeRepository.findAllByEmployeeIdInOrEmployeeIdIn(l1,l2);
//			if(t!=null) {
			List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
//
			return new DataResponse(200, "SUCCESS", employeeDtos);
//			}
//			else
//				return new DataResponse(404,"INVALID_TOKEN",null);
	

		} catch (Exception e) {

			return new DataResponse(404, "EMPLOYEES_NOT_FOUND", null);
		}

	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public DataResponse postEmployee(@RequestBody EmployeeDto employeeDto) {


		try {

			Validations validation=new Validations();
			
			String[] requestedArray= {"firstName","contactNo","mailId","sex","doj","age","address","aadhar","designation","password"};
			
		//	String[] requestedArray2= {"highSchool","hsPercent"};
			
			DataResponse res=validation.validate(employeeDto, requestedArray);
			
		//	DataResponse res2=validation.validate(employeeDto, requestedArray2);
			
			if(res!=null)
				return res;
			
//			if(res2!=null)
//				return res2;
			
			employeeService.createEmployee(employeeDto);

			return new DataResponse(200, "EMPLOYEE_CREATED_SUCCESSFULLY", null);
		}

		catch (Exception e) {

			return new DataResponse(400, "EMPLOYEE_ALREADY_PRESENT", null);
		}
	}

	@RequestMapping(value = "/deleteEmployee/{empId}", method = RequestMethod.DELETE)
	public RestResponse deleteEmployee(@PathVariable Long empId) {

		

		try {

			employeeService.deleteEmployee(empId);

			return new DataResponse(200, "EMPLOYEE_DELETED_SUCCESSFULLY", null);
		}

		catch (Exception e) {

			return new DataResponse(404, "EMPLOYEE_NOT_PRESENT", null);

		}

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public RestResponse updateEmployee(@RequestBody EmployeeDto employeeDto) {

		try {
			
			Validations validation=new Validations();
			
			String[] requestedArray= {"firstName","contactNo","mailId","sex","doj","age","address","aadhar","designation","password","highSchool","hsPercent"};
		
			DataResponse res=validation.validate(employeeDto, requestedArray);
			
			if(res!=null)
				return null;
			
			employeeService.updateEmployee(employeeDto);

			return new DataResponse(200, "EMPLOYEE_UPDATED_SUCCESSFULLY", null);

		}

		catch (Exception e) {

			return new DataResponse(404, e.getMessage(), null);
		}

	}

}
