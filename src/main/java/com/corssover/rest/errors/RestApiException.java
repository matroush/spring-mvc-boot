package com.corssover.rest.errors;

public class RestApiException extends Exception {

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
	public RestApiException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
	
	
}
