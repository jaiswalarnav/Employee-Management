package com.tech.demo.modelToDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tech.demo.dto.EducationDto;
import com.tech.demo.model.Education;
import com.tech.demo.model.Employee;

@Configuration
public class EducationToEducationDto {

//	@Autowired
//	EmployeeToEmployeeDto employeeToEmployeeDto;

	public EducationDto educationToDto(Education education) {
		EducationDto educationDto = new EducationDto();

		Employee employee = education.getEmployee();

		//educationDto.setEmployeeDto(employeeToEmployeeDto.employeeToDto(employee));

		educationDto.setHighSchool(education.getHighSchool());

		educationDto.setHsPercent(education.getHsPercent());

		educationDto.setId(education.getId());

		educationDto.setOther(education.getOther());

		educationDto.setPgPercent(education.getPgPercent());

		educationDto.setPostGrad(education.getPostGrad());

		educationDto.setSeniorSchool(education.getSeniorSchool());

		educationDto.setSsPercent(education.getSsPercent());

		educationDto.setUgPercent(education.getUgPercent());

		educationDto.setUnderGrad(education.getUnderGrad());
//		educationDto.setUpdatedAt(education.getUpdatedAt());
//		educationDto.setIsDeleted(education.getIsDeleted());
//		educationDto.setCreatedAt(education.getCreatedAt());
//		educationDto.setDeletedAt(education.getDeletedAt());

		return educationDto;

	}

}
