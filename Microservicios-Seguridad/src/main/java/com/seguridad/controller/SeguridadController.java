package com.seguridad.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seguridad.modelo.Cursos;
import com.seguridad.services.SeguridadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api("Seguridad prueba hash")
@CrossOrigin("*")
@RestController
public class SeguridadController {

	@Autowired
	SeguridadService app;

	@ApiOperation("Dar curso de alta")
	@RolesAllowed({"ADMIN"})
	@PostMapping(value = "AltaCursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void alta(@ApiParam("Nuevo curso a introducir") @RequestBody Cursos curso) {
		app.alta(curso);
		if(app.findByTematica(curso.getTematica())!=null) {
			System.out.println("Curso subido con exito!");
		}
	}

	@ApiOperation("Lista de cursos")
	@RolesAllowed({"USER"})
	@GetMapping(value="ListarCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cursos> buscarTodos(){
		return app.findAll();
	}

	@ApiOperation("Eliminar curso")
	@RolesAllowed({"ADMIN"})
	@DeleteMapping(value="EliminarCursos/{denominacion}")
	public void eliminar(String denominacion) {
		app.deleteByDenominacion(denominacion);
	}

	@ApiOperation("Buscar curso por tematica")
	@RolesAllowed({"USER"})
	@GetMapping(value="buscarTematica/{tematica}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cursos> buscarTematica(@PathVariable("tematica") String tematica){
		return app.findByTematica(tematica);
	}

	@ApiOperation("Modificar curso")
	@RolesAllowed({"ADMIN"})
	@PutMapping(value="modificarCurso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCurso(@ApiParam("Nuevos datos del curso") @RequestBody Cursos curso) {
		app.save(curso);
	}
	
	
}
