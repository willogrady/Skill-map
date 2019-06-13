package com.addresslookup.service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.addresslookup.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);
	Address updateAddress(Address address);
	List<Address> getAllAddressList();


	String readAll(Reader rd);
	JSONObject readJsonFromUrl(String url) throws IOException, JSONException;
	JSONObject postcodeRequest(Address address) throws JSONException, IOException;
	Address postcodeAndHouseRequest(Address address);
	
}
