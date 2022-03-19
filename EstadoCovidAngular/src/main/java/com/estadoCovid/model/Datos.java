package com.estadoCovid.model;

import com.google.gson.annotations.SerializedName;

public class Datos {

	@SerializedName(value="data")
	private Estado[] estados;

	public Estado[] getEstados() {
		return estados;
	}

	public void setEstados(Estado[] estados) {
		this.estados = estados;
	}
	
	
}
