package com.skillsmap.role.application.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Service
@Primary
public class RoleSkillMapDAOImpl implements RoleSkillMapDAO {
	
	private String sfia_url = "http://localhost:9900/sfia/list";

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
	public String getSfiaRequest() throws IOException, JSONException {
		JSONObject jsonResponse = readJsonFromUrl(sfia_url);
		System.out.println(jsonResponse.toString());
		return jsonResponse.toString();
	}

}
