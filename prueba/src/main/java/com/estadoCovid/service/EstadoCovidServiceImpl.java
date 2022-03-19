package com.estadoCovid.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.estadoCovid.locator.EstadoCovidLocator;
import com.estadoCovid.model.Estado;

@Service
public class EstadoCovidServiceImpl implements EstadoCovidService {
	

	public Estado est = EstadoCovidLocator.getItems()
			.findFirst().get();
	
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
		return EstadoCovidLocator.getItems()
				.filter(t->t.getFecha().equals(est.getFecha()))
				.max(Comparator.comparing(Estado::getIncidencia)).orElse(null);
	}
	
	@Override
	public Estado getTasaMenor() {
		return EstadoCovidLocator.getItems()
				.filter(t->t.getFecha().equals(est.getFecha()))
				.min(Comparator.comparing(Estado::getIncidencia)).orElse(null);
	}

	@Override
	public List<Estado> getLastDay() {
		return EstadoCovidLocator.getItems()
				.filter(t->t.getFecha().equals(est.getFecha())).collect(Collectors.toList());
	}
	
	@Override
	public List<Estado> getByDay(String fecha) {
		return EstadoCovidLocator.getItems()
				.filter(t->t.getFecha().startsWith(fecha))
				.collect(Collectors.toList());
	}

}
