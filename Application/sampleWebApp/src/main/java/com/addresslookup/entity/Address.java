package com.addresslookup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;

import lombok.Getter;	//lombok provides the getter and setters for us
import lombok.Setter;

@Entity
@Table(name="address")
@Setter
@Getter
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@FormParam("addressID")
	public Long addressId;
	
	@FormParam("postcode")
	public String postcode;
	
	@FormParam("house")
	public String houseNameOrNumber;
	
	@FormParam("api-key")
	public String apiKey;

}
