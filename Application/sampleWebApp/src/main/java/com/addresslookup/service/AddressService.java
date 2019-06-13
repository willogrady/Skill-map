package com.addresslookup.service;

import java.io.Reader;
import java.util.List;

import com.addresslookup.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);
	Address updateAddress(Address address);
	List<Address> getAllAddressList();

	String readAll(Reader rd);
	Address readJsonFromUrl(Address address);
	Address postcodeRequest(Address address);
	Address postcodeAndHouseRequest(Address address);
	
}
