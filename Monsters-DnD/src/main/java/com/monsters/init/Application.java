package com.monsters.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EntityScan(basePackages = "com.monsters.model")
//enable annotation for importing dao
@SpringBootApplication(scanBasePackages = { "com.monsters.service", "com.monsters.locator", "com.monsters.controller", "com.monsters.init" }, exclude = {SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
