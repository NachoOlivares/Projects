package com.extendedDnD.model.Gods;

import com.google.gson.annotations.SerializedName;

public class Pantheon {

	@SerializedName(value="content")
	private String[] contentPantheon;
	private Table table;
	public Pantheon(String[] contentPantheon, Table table) {
		super();
		this.contentPantheon = contentPantheon;
		this.table = table;
	}
	public Pantheon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String[] getContentPantheon() {
		return contentPantheon;
	}
	public void setContentPantheon(String[] contentPantheon) {
		this.contentPantheon = contentPantheon;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
}
