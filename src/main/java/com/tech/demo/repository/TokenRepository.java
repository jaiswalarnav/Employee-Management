package com.tech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.model.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	public Token findByUserToken(String userToken);

}
