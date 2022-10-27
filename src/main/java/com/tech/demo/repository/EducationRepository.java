package com.tech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.model.Education;
import com.tech.demo.model.Employee;

public interface EducationRepository extends JpaRepository<Education, Long>{

	
	public Education findByEmployee(Employee employee);
}
