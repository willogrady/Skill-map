package com.addresslookup.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
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
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException  {
		InputStream is = new URL(url).openStream();
		try {
		   	//BufferReader reading the text from the InputStream (is)
		   	//InputStreamReader decoding bytes into characters using the specified charset
		   	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		   	String jsonText = readAll(rd);
	    	JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
	}

	@Override
	public JSONObject postcodeRequest(Address address) throws JSONException, IOException {
		String url = ADDRESS_API_UR+address.postcode+"?api-key="+address.apiKey;
		JSONObject jsonResponse = readJsonFromUrl(url);
		System.out.print(jsonResponse);
		
		return jsonResponse;

	}

	@Override
	public Address postcodeAndHouseRequest(Address address) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
