package com.addresslookup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;	//lombok provides the getter and setters for us
import lombok.Setter;

@Entity
@Table(name="address")
@Setter
@Getter
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addressId;
	
	@Column(name="postcode")
	private String postcode;
	
	@Column(name="house number or name")
	private String houseNameOrNumber;

}
