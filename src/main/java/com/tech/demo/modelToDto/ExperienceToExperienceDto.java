package com.tech.demo.modelToDto;

import org.springframework.context.annotation.Configuration;

import com.tech.demo.dto.ExperienceDto;
import com.tech.demo.model.Experience;

@Configuration
public class ExperienceToExperienceDto {
	
	public ExperienceDto  experienceToDto(Experience experience) {
		
		ExperienceDto experienceDto=new ExperienceDto();
		
		experienceDto.setCompanyName(experience.getCompanyName());
		
		experienceDto.setDesignation(experience.getDesignation());
		
		experienceDto.setId(experience.getId());
		
		experienceDto.setEndDate(experience.getEndDate());
		
		experienceDto.setLocation(experience.getLocation());
		
		experienceDto.setStartDate(experience.getStartDate());
		
		return experienceDto;
		
	}

}
