package com.extendedDnD.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Weapon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SerializedName(value="Name")
	private String name;

	@SerializedName(value="Cost")
	private String cost;
	
	@SerializedName(value="Damage")
	private String damage;
	
	@SerializedName(value="Weight")
	private String weight;

	private String type;
	
	@SerializedName(value="Properties")
	private String[] properties;

	public Weapon(String name, String cost, String damage, String weight, String type, String[] properties) {
		super();
		this.name = name;
		this.cost = cost;
		this.damage = damage;
		this.weight = weight;
		this.type = type;
		this.properties = properties;
	}

	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
