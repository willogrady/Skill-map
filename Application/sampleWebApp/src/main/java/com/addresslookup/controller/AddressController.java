package com.addresslookup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.entity.Address;
import com.addresslookup.service.AddressService;

//rest apis
@RequestMapping("address")
@RestController
public class AddressController {

	@Autowired //autowiring AddressService.interface
	private AddressService addressService;
	
	@PostMapping("/save")
	public Address save(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PostMapping("/update")
	public Address update(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	@GetMapping("/all")
	public List<Address> getAllAddress() {
		return addressService.getAllAddressList();
	}
}
