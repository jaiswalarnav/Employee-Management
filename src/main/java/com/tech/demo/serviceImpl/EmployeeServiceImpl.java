package com.tech.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.ExperienceDto;
import com.tech.demo.dto.LoginDto;
import com.tech.demo.dto.LoginReturnDto;
import com.tech.demo.dto.http.response.DataResponse;
import com.tech.demo.dtoToModel.EmployeeDtoToEmployee;
import com.tech.demo.dtoToModel.ExperienceDtoToExperience;
import com.tech.demo.model.Education;
import com.tech.demo.model.Employee;
import com.tech.demo.model.Experience;
import com.tech.demo.modelToDto.EmployeeToEmployeeDto;
import com.tech.demo.repository.EmployeeRepository;
import com.tech.demo.repository.ExperienceRespository;
import com.tech.demo.repository.TokenRepository;
import com.tech.demo.service.EmployeeService;
import com.tech.demo.validator.Validations;
import com.tech.demo.model.Token;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.implementation.bytecode.Throw;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeDtoToEmployee employeeDtoToEmployee;

	@Autowired
	ExperienceDtoToExperience experienceDtoToExperience;

	@Autowired
	ExperienceRespository experienceRespository;

	@Autowired
	EmployeeToEmployeeDto employeeToEmployeeDto;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	TokenRepository tokenRepository;

	public EmployeeDto getEmployee(Long id) throws Exception {

		Employee employee = null;

		EmployeeDto employeeDto = null;

		if (!employeeRepository.findById(id).isPresent()) {

			throw new Exception("EMPLOYEE_NOT_FOUND");

		} else {

			employee = employeeRepository.findById(id).get();

			
			employeeDto = employeeToEmployeeDto.employeeToDto(employee);

			return employeeDto;
		}
	}

	public List<EmployeeDto> getAllEmployee() throws Exception {

		List<Employee> employees = employeeRepository.findAll();
		
		if (employees.isEmpty())
			throw new Exception("EMPLOYESS_NOT_FOUND");

		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();

		for (Employee e : employees) {

			employeeDtos.add(employeeToEmployeeDto.employeeToDto(e));

		}
		

		return employeeDtos;

	}

	public void createEmployee(EmployeeDto employeeDto) throws Exception {
		Employee emp = employeeRepository.findEmployeeByAadharAndMailId(employeeDto.getAadhar(),employeeDto.getMailId());

		if (emp != null) {

			throw new RuntimeException("EMPLOYEE_ALREADY_EXIST");

		}

		else {

			// Employee employee =
			employeeDtoToEmployee.dtoToEmployee(employeeDto);

//			List<ExperienceDto> experienceDtos= employeeDto.getExperienceDtos(); 
//			
//			for (ExperienceDto experienceDto : experienceDtos) {
//				
//				Experience exp = experienceDtoToExperience.dtoToExperience(experienceDto);
//				
//				experienceRespository.save(exp);
//			
			// employeeRepository.save(employee);

		}

	}

	public void deleteEmployee(Long id) throws Exception {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {

			employeeRepository.delete(employee.get());

		}

		else {

			throw new RuntimeException("EMPLOYEE_DOES_NOT_EXIST");

		}

	}

	public void updateEmployee(EmployeeDto employeeDto) throws Exception {
		Employee emp = employeeRepository.findEmployeeByAadharAndMailId(employeeDto.getAadhar(),employeeDto.getMailId());
		
		try {
		if (emp != null) {

			employeeDtoToEmployee.updateDtoToEmployee(employeeDto, emp);
		} else

			throw new RuntimeException("EMPLOYEE_DOES_NOT_EXIST");
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public LoginReturnDto loginEmployee(LoginDto loginDto )throws Exception {
		
	
		
		if(loginDto.getLoginId()==null )
			throw new RuntimeException("ENTER_LOGIN_DETAILS");
		
		String userId=loginDto.getLoginId();
		Employee employee=new Employee();
		if(userId.charAt(0)>=48 && userId.charAt(0)<=57)
		{	
		Long contactNo=Long.parseLong(userId);
			employee=employeeRepository.findEmployeeByContactNo(contactNo);
		}
		else {
			
		String mailId=userId;
			employee= employeeRepository.findEmployeeByMailId(mailId);
		}
		EmployeeDto employeeDto=null;
		LoginReturnDto loginReturnDto=new LoginReturnDto();
		
		if(employee!= null)
		{
			if(!bCryptPasswordEncoder.matches( loginDto.getPassword(),employee.getPassword()))
				throw new RuntimeException("INVALID_CREDENTIALS");
			else
			{
				Token token=new Token(); 
				token.setUserToken(getToken(employee.getId()));
				tokenRepository.save(token);
				// employeeDto=employeeToEmployeeDto.employeeToDto(employee);
				// employeeDto.setToken(token.getUserToken());
				//new LoginReturnDto();
				
				loginReturnDto.setLastName(employee.getLastName());
				loginReturnDto.setFirstName(employee.getFirstName());
				loginReturnDto.setToken(token.getUserToken());
			}
			
		}
		else
			throw new RuntimeException("EMPLOYEE_NOT_FOUND");
		
		
		return loginReturnDto;
	}
	
	public String getToken(Long id) {
		
		String empId=""+id;
		String token=Jwts.builder()
					  .setSubject(empId)
					  .setExpiration(new Date(System.currentTimeMillis()+ 864_000_000))
					  .signWith(SignatureAlgorithm.HS512,"unique")
					  .compact();
		return token;
	}

	
	

}
