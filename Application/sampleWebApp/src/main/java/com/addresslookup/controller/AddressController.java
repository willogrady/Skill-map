package com.addresslookup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addresslookup.dao.AddressDAO;
import com.addresslookup.dao.AddressDAOImpl;
import com.addresslookup.entity.AddressBean;
import com.addresslookup.entity.LoqateBean;


//rest apis
@RestController	//handles incoming web requests
@Component
@Path("/address")
public class AddressController {
	
	@Autowired //to inject the implementation of the service into the controller
	AddressDAO newAddress;
	
	 @Path("/")
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    public String index() {
	        return "index.html";
	    }
	
	//simple get request testing (--Will Remove--)
	@Path("/testing")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Map<String,String> testingLocalApi() {
			
		HashMap<String, String> map = new HashMap<>();
			
		map.put("address_url", "https://api.getaddress.io/find/%20yo179aq?api-key=LFG96MdGnUu6ZU9Y9_ZPQQ19108%20");
		return map;
	}
	
	
	@Path("/test")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String testing() {
		String str = "testing get request";
		return str;
	}
		
	//List postcode using DAO interfaces
	@Path("/listpostcodedao")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String returnDao(@BeanParam AddressBean addressBean) throws Exception {
		
		JSONObject js = new JSONObject();
		js.put("addresses", newAddress.postcodeRequest(addressBean));
		return js.toString();
		
	}
	
	
	@Path("/firstFind")
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String firstFind(@BeanParam LoqateBean loqateBean) throws Exception {
		
		JSONObject js = new JSONObject();
		js.put("Items", newAddress.findFirst(loqateBean));
		System.out.println(js.toString());
		
		return js.toString();
		
	}
	
	

	
	
	
	
}
