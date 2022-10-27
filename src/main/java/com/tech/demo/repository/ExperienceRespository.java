package com.tech.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.model.Employee;
import com.tech.demo.model.Experience;

public interface ExperienceRespository extends JpaRepository<Experience, Long> {
	
	List<Experience> findAllByEmployee(Employee employee);
	
	public Experience findByEmployee(Employee employee);

}
