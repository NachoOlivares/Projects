package com.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.database.modelo.Data;

public interface DatabaseDao extends JpaRepository<Data, String> {

	Data findByUrl(String url);
	
	@Modifying
	@Transactional
	void deleteByUrl(String url);

	Data findByName(String name);
	
	@Modifying
	@Transactional
	void deleteByName(String name);
}
