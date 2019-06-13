package com.addresslookup.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addresslookup.dao.AddressDao;
import com.addresslookup.entity.Address;
import com.addresslookup.service.AddressService;

@Service	//tells spring that this is the implementation class
public class AddressServiceImpl implements AddressService{
	
	private String ADDRESS_API_UR = "https://api.getAddress.io/find/";
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public Address saveAddress(Address address) {
		return addressDao.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressDao.saveAndFlush(address);
	}

	@Override
	public List<Address> getAllAddressList() {
		return addressDao.findAll();
	}
	
	@Override
	public String readAll(Reader rd) {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    try {
			while ((cp = rd.read()) != -1) {
			  sb.append((char) cp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return sb.toString();
	}

	@Override
	public Address readJsonFromUrl(Address address) {
		return null;
	}

	@Override
	public Address postcodeRequest(Address address) {
		return null;
	}

	@Override
	public Address postcodeAndHouseRequest(Address address) {
		return null;
	}
	
}
