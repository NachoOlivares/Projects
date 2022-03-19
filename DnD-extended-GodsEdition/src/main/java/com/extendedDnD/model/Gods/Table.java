package com.extendedDnD.model.Gods;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Table implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName(value="Deities")
	private String[][] deities;
	@SerializedName(value="Alignment")
	private String[][] alignment;
	@SerializedName(value="Suggested Domains")
	private String[][] domains;
	@SerializedName(value="Symbol")
	private String[][] symbol;
	public Table(String[][] deities, String[][] alignment, String[][] domains, String[][] symbol) {
		super();
		this.deities = deities;
		this.alignment = alignment;
		this.domains = domains;
		this.symbol = symbol;
	}
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String[][] getDeities() {
		int a = 0, b = 0;
		for (String[] deit : this.deities) {
			for (@SuppressWarnings("unused") String deity : deit) {
				String[] splitted = this.deities[a][b].split(",");
				this.deities[a][b] = "<b class=\"text\">"+splitted[0]+"</b><br>"+splitted[1];
				b++;
			}
			a++;
			b = 0;
		}
		return deities;
	}
	public void setDeities(String[][] deities) {
		this.deities = deities;
	}
	public String[][] getAlignment() {
		return alignment;
	}
	public void setAlignment(String[][] alignment) {
		this.alignment = alignment;
	}
	public String[][] getDomains() {
		return domains;
	}
	public void setDomains(String[][] domains) {
		this.domains = domains;
	}
	public String[][] getSymbol() {
		return symbol;
	}
	public void setSymbol(String[][] symbol) {
		this.symbol = symbol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
