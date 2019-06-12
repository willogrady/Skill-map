package com.addresslookup.service;

import java.util.List;

import com.addresslookup.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);
	Address updateAddress(Address address);
	List<Address> getAllAddressList();

}
