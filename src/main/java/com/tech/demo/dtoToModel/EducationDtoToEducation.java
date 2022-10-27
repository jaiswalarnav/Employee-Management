package com.tech.demo.dtoToModel;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tech.demo.dto.EducationDto;
import com.tech.demo.model.Education;
import com.tech.demo.repository.EducationRepository;

@Configuration
public class EducationDtoToEducation {
	
	@Autowired
	EducationRepository educationRepository;
	
	public Education dtoToEducation(EducationDto educationDto)
	{
		Education education=new Education();
		
		//education.setId(educationDto.getId());
		
		education.setHighSchool(educationDto.getHighSchool());
		
		education.setHsPercent(educationDto.getHsPercent());
		
		education.setSeniorSchool(educationDto.getSeniorSchool());
		
		education.setSsPercent(educationDto.getSsPercent());
		
		education.setUnderGrad(educationDto.getUnderGrad());
		
		education.setUgPercent(educationDto.getUgPercent());
		
		education.setPostGrad(educationDto.getPostGrad());
		
		education.setPgPercent(educationDto.getPgPercent());
		
		education.setOther(educationDto.getOther());
		
//		education.setIsDeleted(educationDto.getIsDeleted());
//		
//		education.setCreatedAt(educationDto.getCreatedAt());
//		
//		education.setUpdatedAt(educationDto.getUpdatedAt());
//		
//		education.setDeletedAt(educationDto.getDeletedAt());
		
		return education;
		
	}
	
	public Education updateDtoToEducation(EducationDto educationDto)throws Exception
	{
		if(! educationRepository.findById(educationDto.getId()).isPresent())
		{
			throw new Exception("EDUCATION_NOT_FOUND");
		}
		else
		{
			
		Education education=educationRepository.findById(educationDto.getId()).get();
		
		//education.setId(educationDto.getId());
		
		education.setHighSchool(educationDto.getHighSchool());
		
		education.setHsPercent(educationDto.getHsPercent());
		
		education.setSeniorSchool(educationDto.getSeniorSchool());
		
		education.setSsPercent(educationDto.getSsPercent());
		
		education.setUnderGrad(educationDto.getUnderGrad());
		
		education.setUgPercent(educationDto.getUgPercent());
		
		education.setPostGrad(educationDto.getPostGrad());
		
		education.setPgPercent(educationDto.getPgPercent());
		
		education.setOther(educationDto.getOther());
		
//		education.setIsDeleted(educationDto.getIsDeleted());
//		
//		education.setCreatedAt(educationDto.getCreatedAt());
//		
		education.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//		
//		education.setDeletedAt(educationDto.getDeletedAt());
		
		return education;
		
	}
	}

}
