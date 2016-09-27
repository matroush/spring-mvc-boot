package com.corssover.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LogResponse implements Serializable{

	
	private boolean status;

	public LogResponse(){
		
	}
	
	
	public LogResponse(boolean status){
		
		this.status = status;
	}
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
}
