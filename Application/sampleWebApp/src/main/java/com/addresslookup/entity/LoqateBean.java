package com.addresslookup.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

@Entity
@Table(name="loqate")
public class LoqateBean {
	
	@FormParam("Key")
	public String Key;
	
	@FormParam("Text")
	public String Text;
	
	@FormParam("Countries")
	public String Countries;
	
	@FormParam("IsMiddleware")
	public boolean IsMiddleware = true;
	
	@FormParam("Container")
	public String Container;

	

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String getCountries() {
		return Countries;
	}

	public void setCountries(String countries) {
		Countries = countries;
	}
	
	public String getContainer() {
		return Container;
	}

	public void setContainer(String container) {
		Container = container;
	}
	
	

}
