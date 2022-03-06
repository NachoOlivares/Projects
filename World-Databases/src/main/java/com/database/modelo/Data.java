package com.database.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dataId;
	private String url;
	private String name;
	private String category;
	private String description;
	public Data(int dataId, String url, String name, String category, String description) {
		super();
		this.dataId = dataId;
		this.url = url;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
