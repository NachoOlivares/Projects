package com.extendedDnD.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extendedDnD.model.User;
import com.extendedDnD.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Buscador de monstruos")
@RestController
@CrossOrigin("*")
public class ExtendedController {

	@Autowired
	UserService uapp;

	@ApiOperation("new user")
	@PostMapping(value="/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String newUser(@RequestBody User user){
		return uapp.InsertUser(user);
	}
	@ApiOperation("user login")
	@GetMapping(value="/userLogin")
	public String userLogin(@RequestParam ("email") String email, @RequestParam ("password") String password){
		return uapp.UserAuth(email, password);
	}

	@RolesAllowed({"ADMIN"})
	@ApiOperation("user delete")
	@DeleteMapping(value="/userDelete")
	public String userDelete(@RequestParam("email") String email, @RequestParam("password") String password){
		return uapp.deleteByEmail(email, password);
	}

}
