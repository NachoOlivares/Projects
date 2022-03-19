package com.extendedDnD.model;

public class God {

	private String deity;
	private String origin;
	private String alignment;
	private String domains;
	private String symbol;
	public God(String deity, String origin, String alignment, String domains, String symbol) {
		super();
		this.deity = deity;
		this.origin = origin;
		this.alignment = alignment;
		this.domains = domains;
		this.symbol = symbol;
	}
	public God() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDeity() {
		return deity;
	}
	public void setDeity(String deity) {
		this.deity = deity;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	public String getDomains() {
		return domains;
	}
	public void setDomains(String domains) {
		this.domains = domains;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
}
