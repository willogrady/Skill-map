package com.addresslookup.webservices;

import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.addresslookup.controller.AddressController;
import com.addresslookup.service.impl.AddressServiceImpl;

@Provider
@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		register(CORSFilter.class);
		register(AddressServiceImpl.class);
		register(AddressController.class);
		
	}
	
	
	
	

}
