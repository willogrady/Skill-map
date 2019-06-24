package com.addresslookup.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.addresslookup.dao.AddressDAO;
import com.addresslookup.entity.AddressBean;
import com.addresslookup.entity.LoqateBean;


@Component
@Service	//tells spring that this is the implementation class
public class AddressDAOImpl implements AddressDAO{
	
	
	private String ADDRESS_API_URL = "https://api.getAddress.io/find/";
	private String LOQATE_API_URL = "https://api.addressy.com/Capture/Interactive/";
	
	@Autowired
	public AddressDAO addressDAO;
	
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
	public JSONObject postcodeRequest(AddressBean addressBean) throws JSONException, IOException {
		String url = ADDRESS_API_URL+ addressBean.postcode +"?api-key="+addressBean.apiKey;
		JSONObject jsonResponse = readJsonFromUrl(url);
		return jsonResponse;

	}

	@Override
	public JSONObject postcodeAndHouseRequest(AddressBean addressBean) throws Exception {
		String url = ADDRESS_API_URL+addressBean.postcode+"/"+addressBean.houseNameOrNumber+"?api-key="+addressBean.apiKey; 
		JSONObject jsonResponse = readJsonFromUrl(url);
		System.out.print(jsonResponse);
		return jsonResponse;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	
	//LOQATE SECTION
	
	@Override
	public JSONObject findFirst(LoqateBean loqateBean) throws IOException, JSONException {

		String url = LOQATE_API_URL+ "/Find/v1.1/json3.ws?Key=" +loqateBean.key+"&text="+loqateBean.text+"&isMiddleware=" + loqateBean.isMiddleware + "&countries=" +loqateBean.countries;
		System.out.println(url);

		JSONObject jsonResponse = readJsonFromUrl(url);
		System.out.println("This is the response:" + jsonResponse);
		System.out.println("This is the json array:" + jsonResponse.get("Items"));
		System.out.println((jsonResponse.get("Items")).getClass());
		JSONArray arr = (JSONArray) jsonResponse.get("Items");
		JSONObject object = arr.getJSONObject(0);
		System.out.println(object);
		String findId = object.getString("Id");
		System.out.println("I really hope this is the Id!: " + findId);
	
		String url2 = LOQATE_API_URL+"/Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.text +
				"&countries="+loqateBean.countries+"&isMiddleware="+loqateBean.isMiddleware+"&container="+ findId;
		JSONObject step2response = readJsonFromUrl(url2);
		System.out.println("this is the response:" + step2response);
		
		return step2response; 
		//return jsonResponse;
	}

	@Override
	public JSONObject findSecond(LoqateBean loqateBean) throws IOException, JSONException {
		String url = LOQATE_API_URL+"/Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.text+"&countries="+loqateBean.countries+"&isMiddleware="+loqateBean.isMiddleware+"&container="+loqateBean.container;
		JSONObject jsonResponse = readJsonFromUrl(url);
		System.out.print(jsonResponse);
		return jsonResponse;
	}

	@Override
	public JSONObject retrieve(LoqateBean loqateBean) throws IOException, JSONException {
		String url = LOQATE_API_URL+"/Retrieve/v1.00/json3.ws?Key="+loqateBean.key+"&Id="+loqateBean.Id;
		System.out.println("Retrieve URL: "+ url);
		JSONObject jsonResponse = readJsonFromUrl(url);
		System.out.println(jsonResponse);
		return jsonResponse;
	}

	
}
