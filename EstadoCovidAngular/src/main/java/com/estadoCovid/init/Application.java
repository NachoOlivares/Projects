package com.estadoCovid.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.EstadoCovid.model")
//enable annotation for importing dao
@SpringBootApplication(scanBasePackages = { "com.EstadoCovid.service", "com.EstadoCovid.locator", "com.EstadoCovid.controller", "com.EstadoCovid.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
