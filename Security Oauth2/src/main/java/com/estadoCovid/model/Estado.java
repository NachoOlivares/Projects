package com.estadoCovid.model;


import com.google.gson.annotations.SerializedName;

public class Estado {

	@SerializedName(value="municipio_distrito")
	private String municipio;
	@SerializedName(value="tasa_incidencia_acumulada_ultimos_14dias")
	private double incidencia;
	@SerializedName(value="tasa_incidencia_acumulada_total")
	private double incidenciaTotal;
	@SerializedName(value="fecha_informe")
	private String fecha;
	public Estado(String municipio, double incidencia, double incidenciaTotal, String fecha) {
		super();
		this.municipio = municipio;
		this.incidencia = incidencia;
		this.incidenciaTotal = incidenciaTotal;
		this.fecha = fecha;
	}
	
	public Estado() {
		super();
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public double getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}

	public double getIncidenciaTotal() {
		return incidenciaTotal;
	}

	public void setIncidenciaTotal(double incidenciaTotal) {
		this.incidenciaTotal = incidenciaTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
