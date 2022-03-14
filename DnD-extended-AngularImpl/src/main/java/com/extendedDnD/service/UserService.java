package com.extendedDnD.service;

import java.util.List;

import com.extendedDnD.dao.UsersDao;
import com.extendedDnD.model.User;

public interface UserService extends UsersDao{

	String InsertUser(User user);
	
	String UserAuth(String email, String password);
	
	User findByEmail(String email);

	String deleteByEmail(String email, String password);

	List<User> getAllUsers();
}
