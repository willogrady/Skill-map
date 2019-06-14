package com.addresslookup.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.addresslookup.entity.AddressBean;

public interface AddressDAO{

	String readAll(Reader rd);
	JSONObject readJsonFromUrl(String url) throws IOException, JSONException;
	JSONObject postcodeRequest(AddressBean addressBean) throws IOException, JSONException;
	JSONObject postcodeAndHouseRequest() throws Exception;
	
	
	
}
