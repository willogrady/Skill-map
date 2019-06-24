package com.addresslookup.dao;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.addresslookup.entity.LoqateBean;

@Component
@Service
public class LoqateDAOImpl extends AddressDAOImpl implements LoqateDAO {
	
	private String LOQATE_API_URL = "https://api.addressy.com/Capture/Interactive/";
	
	@Autowired
	public LoqateDAO loqateDAO;
	
	@Override
	public JSONObject findFirst(LoqateBean loqateBean) throws IOException, JSONException {
	    String url = LOQATE_API_URL+"Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.text+"&isMiddleware="+loqateBean.isMiddleware+"&countries="+loqateBean.countries;
	    JSONObject jsonResponse = readJsonFromUrl(url);
	    System.out.println("This is the response:" + jsonResponse);
	    System.out.println("This is the json array:" + jsonResponse.get("Items"));
	    System.out.println((jsonResponse.get("Items")).getClass());
	    JSONArray arr = (JSONArray) jsonResponse.get("Items");
	    JSONObject object = arr.getJSONObject(0);
	    System.out.println(object);
	    String findId = object.getString("Id");
	    System.out.println("I really hope this is the Id!: " + findId);
	    String url2electricBoogaloo = LOQATE_API_URL+"/Find/v1.1/json3.ws?Key="+loqateBean.key+"&text="+loqateBean.text +
	            "&countries="+loqateBean.countries+"&isMiddleware="+loqateBean.isMiddleware+"&container="+ findId;
	    JSONObject step2response = readJsonFromUrl(url2electricBoogaloo);
	    System.out.println(step2response);
		return step2response;
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
