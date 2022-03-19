package com.estadoCovid.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.estadoCovid.model")
//enable annotation for importing dao
@SpringBootApplication(scanBasePackages = { "com.estadoCovid.service", "com.estadoCovid.locator", "com.estadoCovid.controller", "com.estadoCovid.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
