package com.corssover.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name ="application")
@Entity
public class Application implements Serializable{


	@Id
	@Column(name = "application_id")
	private String applicationId;
	
	@Column(name = "display_name")
	@JsonProperty(value="display_name")
	private String displayName;
	
	@Column(name = "secret")
	private String secret;

	
	
	


	public Application() {
		super();
	}

	public Application(String applicationId, String secret) {
		super();
		this.applicationId = applicationId;
		this.secret = secret;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	
	
	
}
