package com.estadoCovid.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estadoCovid.service.EstadoCovidService;

@CrossOrigin("*")
@RestController
public class EstadoCovidController {

	@Autowired
	EstadoCovidService app;
	
	@GetMapping(value = "/municipios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getMunicipios() {
		return app.getMunicipios();
	}
	
}
