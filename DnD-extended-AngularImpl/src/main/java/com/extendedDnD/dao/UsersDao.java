package com.extendedDnD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.extendedDnD.model.User;

public interface UsersDao extends JpaRepository<User, String> {

	@Query("SELECT c FROM User c WHERE c.email=?1")
	User findByEmail(String email);
	
	@Modifying
	@Transactional
	void deleteByEmail(String email);

	@Query("SELECT c FROM User c WHERE c.email=?1 AND c.password=?2")
	User userAuth(String email, String password);
	
	
}