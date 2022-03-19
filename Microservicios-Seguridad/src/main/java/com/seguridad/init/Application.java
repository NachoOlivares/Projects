package com.seguridad.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.seguridad.init.Application;

@EntityScan(basePackages = "com.seguridad.modelo")
//enable annotation for importing dao
@EnableJpaRepositories(basePackages = "com.seguridad.dao")
@SpringBootApplication(scanBasePackages = { "com.seguridad.services", "com.seguridad.controller", "com.seguridad.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}