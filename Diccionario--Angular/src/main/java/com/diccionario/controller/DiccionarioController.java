package com.diccionario.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diccionario.service.DiccionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("buscador palabras")
@CrossOrigin("*")
@RestController
public class DiccionarioController {

	@Autowired
	DiccionarioService app;
	
	@ApiOperation("Buscar palabra en diccionario")
	@GetMapping("/BuscarPalabra")
	public List<String> Resultado(@ApiParam("palabra a buscar") @RequestParam String palabra,@ApiParam("Exact match y/n") @RequestParam String exact) throws IOException{
		return app.Buscador(palabra, exact);
	}
}
