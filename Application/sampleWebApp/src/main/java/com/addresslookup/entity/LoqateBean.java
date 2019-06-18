package com.addresslookup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Entity
@Table(name="loqate")
public class LoqateBean {
	
	@FormParam("loqateID")
	public Long loqateID;
	
	@FormParam("Key")
	public String key;
	
	@FormParam("Text")
	public String text;
	
	@FormParam("Countries")
	public String countries;
	
	@FormParam("IsMiddleware")
	public boolean isMiddleware = true;
	
	@FormParam("Container")
	public String container;
	
	@FormParam("RetrieveId")
	public String retrieveId;

	@Id
	@GeneratedValue
	public Long getLoqateID() {
		return loqateID;
	}

	public void setLoqateID(Long loqateID) {
		this.loqateID = loqateID;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getRetrieveId() {
		return retrieveId;
	}

	public void setRetrieveId(String retrieveId) {
		this.retrieveId = retrieveId;
	}

	

	

	
	
	

}
