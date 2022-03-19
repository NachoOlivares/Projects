package com.extendedDnD.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.extendedDnD.model.User;
import com.extendedDnD.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService app;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		List<User> users = app.getAllUsers();
		for (User user:users) {
			auth.inMemoryAuthentication().withUser(user.getEmail()).password("{noop}"+user.getPassword()).roles("USER");
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/unused").authenticated().and().httpBasic();
	}

}
