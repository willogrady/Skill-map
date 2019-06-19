package com.addresslookup.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.addresslookup.entity.AddressBean;
import com.addresslookup.entity.LoqateBean;

public interface AddressDAO{

	public String readAll(Reader rd);
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException;
	public JSONObject postcodeRequest(AddressBean addressBean) throws IOException, JSONException;
	public JSONObject postcodeAndHouseRequest(AddressBean addressBean) throws Exception;
	
	
	//LOQATE SECTION
	public JSONObject findFirst(LoqateBean loqateBean) throws IOException, JSONException;
	public JSONObject retrieve(LoqateBean loqateBean) throws Exception;
	
}
