package com.database.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.database.modelo.Data;
import com.database.services.DatabaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Seguridad prueba hash")
@CrossOrigin("*")
@RestController
public class DatabaseController {

	@Autowired
	DatabaseService app;

	@ApiOperation("Añadir data a la world database")
	@RolesAllowed({ "ADMIN" })
	@PostMapping(value = "addData", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addData(@ApiParam("url, nombre y datos") @RequestBody Data data) {
		app.AddData(data);
		if (app.findByName(data.getName()) != null) {
			System.out.println("Curso subido con exito!");
		}
	}

	@ApiOperation("Datos de las url")
	@RolesAllowed({ "USER" })
	@GetMapping(value = "ListaData", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Data> buscarTodos() {
		return app.findAll();
	}

	@ApiOperation("Eliminar url por nombre")
	@RolesAllowed({ "ADMIN" })
	@DeleteMapping(value = "deleteUrlByName/{name}")
	public void deleteByName(@ApiParam("url name") @RequestParam("name") String name) {
		app.deleteByName(name);
	}

	@ApiOperation("Buscar url por nombre")
	@RolesAllowed({ "USER" })
	@GetMapping(value = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Data findName(@ApiParam("url name") @RequestParam("name") String name) {
		return app.findByName(name);
	}

	@ApiOperation("Modificar url")
	@RolesAllowed({ "ADMIN" })
	@PutMapping(value = "modifyUrl", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyUrl(@ApiParam("Nuevos datos de la url") @RequestBody Data data) {
		if (app.findAll().stream().anyMatch(t -> t.getName().equals(data.getName()))) {
			app.save(data);
		}
	}

	@ApiOperation("Eliminar por url")
	@RolesAllowed({ "ADMIN" })
	@DeleteMapping(value = "deleteByUrl")
	public void deleteByUrl(@ApiParam("url to delete") @RequestParam("url") String url) {
		app.deleteByUrl(url);
	}

	@ApiOperation("Buscar por url")
	@RolesAllowed({ "USER" })
	@GetMapping(value = "findByUrl/{url}")
	public Data findByUrl(@ApiParam("url to search") @RequestParam("name") String url) {
		return app.findByUrl(url);
	}

}
