package com.extendedDnD.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.extendedDnD.model")
@EnableJpaRepositories(basePackages = "com.extendedDnD.dao")
@SpringBootApplication(scanBasePackages = { "com.extendedDnD.service", "com.extendedDnD.locator", "com.extendedDnD.controller", "com.extendedDnD.init" }, exclude = {SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
