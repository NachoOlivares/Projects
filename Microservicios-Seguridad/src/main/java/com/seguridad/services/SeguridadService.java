package com.seguridad.services;

import java.util.List;

import com.seguridad.dao.CursosDao;
import com.seguridad.modelo.Cursos;

public interface SeguridadService extends CursosDao {

	void alta(Cursos curso);
	
	List<Cursos> eliminarPorTurno(String turno);
	
	List<Cursos> existentes();
}
