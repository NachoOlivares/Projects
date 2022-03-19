package com.extendedDnD.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Spell implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	@SerializedName("desc")
	private String description;
	private String page;
	private String range;
	private String components;
	private String material;
	private String ritual;
	private String duration;
	private String concentration;
	private String casting_time;
	private String level;
	private String school;
	@SerializedName("class")
	private String role;
	public Spell(String name, String description, String page, String range, String components, String material,
			String ritual, String duration, String concentration, String casting_time, String level, String school,
			String role) {
		super();
		this.name = name;
		this.description = description;
		this.page = page;
		this.range = range;
		this.components = components;
		this.material = material;
		this.ritual = ritual;
		this.duration = duration;
		this.concentration = concentration;
		this.casting_time = casting_time;
		this.level = level;
		this.school = school;
		this.role = role;
	}
	public Spell() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getComponents() {
		return components;
	}
	public void setComponents(String components) {
		this.components = components;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getRitual() {
		return ritual;
	}
	public void setRitual(String ritual) {
		this.ritual = ritual;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public String getCasting_time() {
		return casting_time;
	}
	public void setCasting_time(String casting_time) {
		this.casting_time = casting_time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
