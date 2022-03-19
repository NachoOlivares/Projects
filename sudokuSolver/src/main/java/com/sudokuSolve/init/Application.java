package com.sudokuSolve.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.sudokuSolve.model")
//enable annotation for importing dao
@SpringBootApplication(scanBasePackages = { "com.sudokuSolve.service", "com.sudokuSolve.controller", "com.sudokuSolve.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
