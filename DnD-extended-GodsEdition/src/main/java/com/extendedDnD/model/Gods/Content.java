package com.extendedDnD.model.Gods;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Content implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SerializedName(value="content")
	private String contentAppendix;
	
	@SerializedName(value="Pantheon")
	private Pantheon pantheon;

	public Content(String contentAppendix, Pantheon pantheon) {
		super();
		this.contentAppendix = contentAppendix;
		this.pantheon = pantheon;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getContentAppendix() {
		return contentAppendix;
	}

	public void setContentAppendix(String contentAppendix) {
		this.contentAppendix = contentAppendix;
	}

	public Pantheon getPantheon() {
		return pantheon;
	}

	public void setPantheon(Pantheon pantheon) {
		this.pantheon = pantheon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
