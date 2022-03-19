package com.database.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.database.init.Application;

@EntityScan(basePackages = "com.database.modelo")
//enable annotation for importing dao
@EnableJpaRepositories(basePackages = "com.database.dao")
@SpringBootApplication(scanBasePackages = { "com.database.services", "com.database.controller", "com.database.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}