package com.addresslookup.service;

import java.io.Reader;
import java.util.List;

import org.json.JSONObject;

import com.addresslookup.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);
	Address updateAddress(Address address);
	List<Address> getAllAddressList();

	String readAll(Reader rd);
	Address readJsonFromUrl(Address address);
	JSONObject postcodeRequest(Address address);
	Address postcodeAndHouseRequest(Address address);
	
}
