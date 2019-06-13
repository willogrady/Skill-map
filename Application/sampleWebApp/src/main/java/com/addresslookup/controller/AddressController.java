package com.addresslookup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.entity.Address;
import com.addresslookup.service.AddressService;
import com.addresslookup.service.impl.AddressServiceImpl;

//rest apis
@Component
@Path("/address")
@RestController	//handles incoming web requests
public class AddressController {

	@Autowired //autowiring AddressService.interface
	private AddressService addressService;
	
	
		//simple get request testing (--Will Remove--)
		@Path("/testing")
		@GET
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Map<String,String> testingLocalApi() {
			
			HashMap<String, String> map = new HashMap<>();
			
			map.put("address_url", "https://api.getaddress.io/find/%20yo179aq?api-key=LFG96MdGnUu6ZU9Y9_ZPQQ19108%20");
			return map;
		}
	
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
	
	@Path("/test")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String testing() {
		return "testing get request";
		
	}
	
	
	@PostMapping(path = "/listpostcode", consumes = "application/x-www-form-urlencoded", produces = "application/json")
	public String returnPostcodeURL(@RequestBody AddressServiceImpl newAddress) throws Exception {
		JSONObject js = new JSONObject();
		js.put("addresses", newAddress.postcodeRequest());
		System.out.println(newAddress.postcodeRequest());
		return js.toString();
		
	
	}
	
	
}
