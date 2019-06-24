package com.addresslookup.dao;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.addresslookup.entity.LoqateBean;

public interface LoqateDAO {
	
	public JSONObject findFirst(LoqateBean loqateBean) throws IOException, JSONException;
	public JSONObject retrieve(LoqateBean loqateBean) throws Exception;

}
