package com.extendedDnD.model.Gods;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Appendix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName(value="Appendix")
	private Content appendix;

	public Appendix(Content appendix) {
		super();
		this.appendix = appendix;
	}

	public Appendix() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content getAppendix() {
		return appendix;
	}

	public void setAppendix(Content appendix) {
		this.appendix = appendix;
	}
	
}
