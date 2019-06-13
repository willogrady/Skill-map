package com.addresslookup.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.dao.AddressDao;
import com.addresslookup.entity.Address;
import com.addresslookup.service.AddressService;
import com.addresslookup.service.impl.AddressServiceImpl;

//rest apis
//@RequestMapping(path = "/address")
@RestController	//handles incoming web requests
@Component
@Path("/address")
public class AddressController {
	
	@Autowired //to inject the implementation of the service into the controller
	@Inject
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
	
//	@GetMapping("/test")
	@Path("/test")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String testing() {
		String str = "testing get request";
		return str;
	}
	
	
	@PostMapping(path = "/listpostcode", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public String returnPostcodeURL(AddressService newAddress) throws Exception {
		JSONObject js = new JSONObject();
		js.put("addresses", newAddress.postcodeRequest());
		System.out.println(newAddress.postcodeRequest());
		return js.toString();
		
	
	}
	
	
}
