package com.seguridad.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.seguridad.modelo.Cursos;

public interface CursosDao extends JpaRepository<Cursos, Integer> {
	
	List<Cursos> findByTematica(String tematica);
	
	@Query("SELECT c FROM Cursos c WHERE c.duracion<=?1")
	List<Cursos> findByDuracionLessThan(int duracion);
	
	@Modifying
	@Transactional
	void deleteByDenominacion(String denominacion);

	Cursos findByDenominacion(String denominacion);
}
