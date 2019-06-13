package com.addresslookup.service;

import java.io.Reader;
import java.util.List;

import org.json.JSONObject;

import com.addresslookup.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);
	Address updateAddress(Address address);
	List<Address> getAllAddressList();

	Address readAll(Reader rd);
	JSONObject readJsonFromUrl(String url);
	Address postcodeRequest(Address address);
	Address postcodeAndHouseRequest(Address address);
	
}
