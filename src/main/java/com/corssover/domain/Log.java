package com.corssover.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name ="log")
@Entity
public class Log implements Serializable{

public enum Level{
		
		INFO , ERROR , DEBUG 
	}
	

	@Id
	@Column(name = "log_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "application_id" , nullable =false )
	@JsonProperty("application_id")
	private String applicationId;
	
	@Column(name = "logger" , nullable =false )
	@Size(max=256)
	private String logger;
	
	@Size(max=256)
	@Column(name = "level" ,  nullable =false)
	private String level;
	
	@Size(max=2048)
	@Column(name = "message" , nullable =false)
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getLogger() {
		return logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Log [applicationId=" + applicationId + ", logger=" + logger + ", level=" + level + ", message="
				+ message + "]";
	}

	
	
}
