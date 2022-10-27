package com.tech.demo.dtoToModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.ExperienceDto;
import com.tech.demo.model.Education;
import com.tech.demo.model.Employee;
import com.tech.demo.model.Experience;
import com.tech.demo.repository.EducationRepository;
import com.tech.demo.repository.EmployeeRepository;
import com.tech.demo.repository.ExperienceRespository;

@Configuration
public class EmployeeDtoToEmployee {

	@Autowired
	ExperienceDtoToExperience experienceDtoToExperience;

	@Autowired
	ExperienceRespository experienceRespository;

	@Autowired
	EducationDtoToEducation educationDtoToEducation;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void dtoToEmployee(EmployeeDto employeeDto)throws Exception {

		Employee employee = new Employee();

		employee.setAadhar(employeeDto.getAadhar());

		employee.setAddress(employeeDto.getAddress());

		employee.setAge(employeeDto.getAge());

		employee.setContactNo(employeeDto.getContactNo());

		employee.setDesignation(employeeDto.getDesignation());

		employee.setDoj(employeeDto.getDoj());

		employee.setFirstName(employeeDto.getFirstName());

		employee.setLastName(employeeDto.getLastName());

		// employee.setId(employeeDto.getId());

		employee.setMailId(employeeDto.getMailId());

		employee.setSex(employeeDto.getSex());

//		employee.setUpdatedAt(employeeDto.getUpdatedAt());
//
//		employee.setIsDeleted(employeeDto.getIsDeleted());
//
//		employee.setCreatedAt(employeeDto.getCreatedAt());
//
//		employee.setDeletedAt(employeeDto.getDeletedAt());
         
		String password=bCryptPasswordEncoder.encode(employeeDto.getPassword()) ;
		
		employee.setPassword(password);

		Employee savedEmployee = employeeRepository.save(employee);

//		List<Experience> experience = new ArrayList<Experience>();
		for (ExperienceDto experienceDto : employeeDto.getExperienceDtos()) {

			Experience exp = experienceDtoToExperience.dtoToExperience(experienceDto);

			exp.setEmployee(savedEmployee);

			experienceRespository.save(exp);

			// experience.add(exp);

		}

		// employee.setExperiences(experience);

		Education education = educationDtoToEducation.dtoToEducation(employeeDto.getEducationDto());

		education.setEmployee(savedEmployee);

		educationRepository.save(education);

		// employee.setEducation(education);

		// return employee;
	}
	
	public void updateDtoToEmployee(EmployeeDto employeeDto, Employee employee)throws Exception {

		employee.setAadhar(employeeDto.getAadhar());

		employee.setAddress(employeeDto.getAddress());

		employee.setAge(employeeDto.getAge());

		employee.setContactNo(employeeDto.getContactNo());

	//	employee.setCreatedAt(employeeDto.getCreatedAt());

	//	employee.setDeletedAt(employeeDto.getDeletedAt());

		employee.setDesignation(employeeDto.getDesignation());

		employee.setDoj(employeeDto.getDoj());

		employee.setFirstName(employeeDto.getFirstName());

		employee.setLastName(employeeDto.getLastName());

		// employee.setId(employeeDto.getId());

	//	employee.setIsDeleted(employeeDto.getIsDeleted());

		employee.setMailId(employeeDto.getMailId());

		employee.setSex(employeeDto.getSex());

	//	employee.setUpdatedAt(employeeDto.getUpdatedAt());

		employee.setPassword(employeeDto.getPassword());
		
		employee.setUpdatedAt(new Timestamp(System.currentTimeMillis()) );

		Employee savedEmployee = employeeRepository.save(employee);

		List<Experience> experience = new ArrayList<Experience>();
		for (ExperienceDto experienceDto : employeeDto.getExperienceDtos()) {

			Experience exp = experienceDtoToExperience.updateDtoToExperience(experienceDto);

			exp.setEmployee(savedEmployee);

			experienceRespository.save(exp);

			// experience.add(exp);

		}

		// employee.setExperiences(experience);

		Education education = educationDtoToEducation.updateDtoToEducation(employeeDto.getEducationDto());

		education.setEmployee(savedEmployee);

		educationRepository.save(education);

	}

}
