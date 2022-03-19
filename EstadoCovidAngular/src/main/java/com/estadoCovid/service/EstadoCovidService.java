package com.estadoCovid.service;

import java.util.List;

import com.estadoCovid.model.Estado;

public interface EstadoCovidService {

	public List<String> getMunicipios();
	
	public Estado getMunicipio(String municipio);
	
	public Estado getTasaMayor();
	
	public List<Estado> getLastDay();
}
