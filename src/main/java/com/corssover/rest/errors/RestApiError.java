package com.corssover.rest.errors;

import java.io.Serializable;

public class RestApiError implements Serializable{

	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RestApiError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
	
	
}
