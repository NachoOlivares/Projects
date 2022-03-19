package com.estadoCovid.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estadoCovid.model.Estado;
import com.estadoCovid.service.EstadoCovidService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Coleccion covid")
@CrossOrigin("*")
@RestController
public class EstadoCovidController {

	@Autowired
	EstadoCovidService app;
	
	@ApiOperation("Listar todos municipios")
	@GetMapping(value = "municipios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getMunicipios() {
		return app.getMunicipios();
	}
	
	@ApiOperation("Mostrar datos de municipio")
	@GetMapping(value="municipio", produces = MediaType.APPLICATION_JSON_VALUE)
	public Estado getMunicipio(@ApiParam("municipio") @RequestParam String municipio) {
		return app.getMunicipio(municipio);
	}
	
	@ApiOperation("Mostrar estado con mayor tasa actual")
	@GetMapping(value="mayor tasa", produces = MediaType.APPLICATION_JSON_VALUE)
	public Estado getTasaMayor() {
		return app.getTasaMayor();
	}
	
	@ApiOperation("Mostrar estado con menor tasa actual")
	@GetMapping(value="menor tasa", produces = MediaType.APPLICATION_JSON_VALUE)
	public Estado getTasaMenor() {
		return app.getTasaMenor();
	}
	
	@ApiOperation("Mostrar estado municipios ultimo dia")
	@GetMapping(value="estado actual", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estado> getEstadoActual(){
		return app.getLastDay();
	}
	
	@ApiOperation("Mostrar estado municipios dia dado")
	@GetMapping(value="estado dia introducido", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estado> getEstadosFecha(@ApiParam("yyyy/mm/dd") @RequestParam String fecha){
		return app.getByDay(fecha);
	}
	
}
