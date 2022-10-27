package com.tech.demo.dtoToModel;

import java.sql.Timestamp;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.tech.demo.dto.ExperienceDto;
import com.tech.demo.model.Employee;
import com.tech.demo.model.Experience;
import com.tech.demo.repository.ExperienceRespository;

@Configuration
public class ExperienceDtoToExperience {
	
	@Autowired
	ExperienceRespository experienceRespository;

	public Experience dtoToExperience(ExperienceDto experienceDto) {
		Experience experience = new Experience();

		// experience.setEmpid(experienceDto.getEmpId());

		experience.setCompanyName(experienceDto.getCompanyName());

		experience.setDesignation(experienceDto.getDesignation());

		experience.setEndDate(experienceDto.getEndDate());

		experience.setId(experienceDto.getId());

		experience.setLocation(experienceDto.getLocation());

		experience.setStartDate(experienceDto.getStartDate());

//		experience.setUpdatedAt(experienceDto.getUpdatedAt());
//
//		experience.setIsDeleted(experienceDto.getIsDeleted());
//
//		experience.setCreatedAt(experienceDto.getCreatedAt());
//
//		experience.setDeletedAt(experienceDto.getDeletedAt());

		// experience.setEmployee(experienceDto.getEmployeeDto());

		return experience;

	}
	
	public Experience updateDtoToExperience(ExperienceDto experienceDto)throws Exception {
		if(! experienceRespository.findById(experienceDto.getId()).isPresent())
		{
			throw new Exception("EXPERIENCE_NOT_FOUND");
		}
		else
		{
			Experience experience=experienceRespository.findById(experienceDto.getId()).get();
		
		
		// experience.setEmpid(experienceDto.getEmpId());

		experience.setCompanyName(experienceDto.getCompanyName());

		experience.setDesignation(experienceDto.getDesignation());

		experience.setEndDate(experienceDto.getEndDate());

		experience.setId(experienceDto.getId());

		experience.setLocation(experienceDto.getLocation());

		experience.setStartDate(experienceDto.getStartDate());
		
		experience.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

//		experience.setUpdatedAt(experienceDto.getUpdatedAt());
//
//		experience.setIsDeleted(experienceDto.getIsDeleted());
//
//		experience.setCreatedAt(experienceDto.getCreatedAt());
//
//		experience.setDeletedAt(experienceDto.getDeletedAt());

		// experience.setEmployee(experienceDto.getEmployeeDto());

		return experience;

	}
		}

}
