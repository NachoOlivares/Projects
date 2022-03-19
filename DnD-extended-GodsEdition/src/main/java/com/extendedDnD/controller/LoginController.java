package com.extendedDnD.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Login Controller")
@Controller
@CrossOrigin("*")
public class LoginController {


	@ApiOperation("Login screen")
	@GetMapping(value="/login")
	public String login() {
		return "login.html";
	}
}
