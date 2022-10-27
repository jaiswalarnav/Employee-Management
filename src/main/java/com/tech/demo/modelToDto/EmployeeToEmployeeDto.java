package com.tech.demo.modelToDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tech.demo.dto.EmployeeDto;
import com.tech.demo.dto.ExperienceDto;
import com.tech.demo.model.Education;
import com.tech.demo.model.Employee;
import com.tech.demo.model.Experience;
import com.tech.demo.repository.EducationRepository;
import com.tech.demo.repository.ExperienceRespository;

@Configuration
public class EmployeeToEmployeeDto {

	@Autowired
	EducationRepository educationRepository;

	@Autowired
	EducationToEducationDto educationToEducationDto;

	@Autowired
	ExperienceRespository experienceRespository;

	@Autowired
	ExperienceToExperienceDto experienceToExperienceDto;

	public EmployeeDto employeeToDto(Employee employee) {

		EmployeeDto employeeDto = new EmployeeDto();

		employeeDto.setAadhar(employee.getAadhar());

		employeeDto.setAddress(employee.getAddress());

		employeeDto.setAge(employee.getAge());

		employeeDto.setContactNo(employee.getContactNo());

		employeeDto.setDesignation(employee.getDesignation());

		employeeDto.setDoj(employee.getDoj());

		employeeDto.setFirstName(employee.getFirstName());

		employeeDto.setLastName(employee.getLastName());

		employeeDto.setId(employee.getId());

		employeeDto.setMailId(employee.getMailId());

		employeeDto.setSex(employee.getSex());

//		employeeDto.setUpdatedAt(employee.getUpdatedAt());
//		
//		employeeDto.setIsDeleted(employee.getIsDeleted());
//		
//		employeeDto.setCreatedAt(employee.getCreatedAt());
//
//		employeeDto.setDeletedAt(employee.getDeletedAt());

		// employeeDto.setPassword(employee.getPassword());

		// Education education=educationRepository.findByEmpId(employee.getId());

		// employeeDto.setEducationDto(educationToEducationDto.educationToDto(education));

		List<Experience> experiences = experienceRespository.findAllByEmployee(employee);

		List<ExperienceDto> experienceDtos = new ArrayList<ExperienceDto>();

		if (experienceDtos != null) {

			for (Experience exp : experiences) {
				ExperienceDto experienceDto = experienceToExperienceDto.experienceToDto(exp);
				experienceDtos.add(experienceDto);
			}

			// employeeDto.setExperienceDtos(null);

			employeeDto.setExperienceDtos(experienceDtos);
		}

		Education education = educationRepository.findByEmployee(employee);

		if (education != null) {

			employeeDto.setEducationDto(educationToEducationDto.educationToDto(education));

		}

		return employeeDto;

	}

}
