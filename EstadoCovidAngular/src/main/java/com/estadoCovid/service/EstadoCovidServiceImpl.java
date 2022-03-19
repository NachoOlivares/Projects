package com.estadoCovid.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.estadoCovid.locator.EstadoCovidLocator;
import com.estadoCovid.model.Estado;

@Service
public class EstadoCovidServiceImpl implements EstadoCovidService {

	
	@Override
	public List<String> getMunicipios() {
			return EstadoCovidLocator.getItems()
				.map(t->t.getMunicipio()) //stream de municipios
				.distinct() //quitamos duplicados
				.collect(Collectors.toList());  //conversi�n a lista
	}

	@Override
	public Estado getMunicipio(String municipio) {
		return EstadoCovidLocator.getItems()
				.filter(t->t.getMunicipio().equals(municipio)).findFirst().orElse(null);
	}

	@Override
	public Estado getTasaMayor() {
		return null;
	}

	@Override
	public List<Estado> getLastDay() {
		// TODO Auto-generated method stub
		return null;
	}

}
