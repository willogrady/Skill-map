package com.skillsmap.role.application.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.skillsmap.role.application.entity.RoleSkillMap;


@Component
@Service
@Primary
public class RoleSkillMapDAOImpl implements RoleSkillMapDAO {
	
	private String sfia_url = "http://localhost:9900/sfia/list";
	private String sfia_skill_id_url = "http://localhost:9900/sfia/id/";
	private String role_skill_url = "http://localhost:9901/role_skill_map/skill_id";

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
	public String readStringFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		try {
		   	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		   	String jsonText = readAll(rd);
		      return jsonText;
		    } finally {
		      is.close();
		    }
	}
	
	@Override
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException  {
		InputStream is = new URL(url).openStream();
		try {
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
		String strResponse = readStringFromUrl(sfia_url);
		return strResponse;
	}

	@Override
	public String skillIdRequest(RoleSkillMap roleSkillMap) throws IOException {
		String url = sfia_skill_id_url+roleSkillMap.skill_id;
		String strResponse = readStringFromUrl(url);
		return strResponse; 
		}
	
	@Override
	public String getRoleViaSkill(RoleSkillMap roleSkillMap) throws IOException {
		String url =  role_skill_url+"?skill_id="+roleSkillMap.skill_id;
		String strResponse = readStringFromUrl(url);
		return strResponse;
	}
	

	
}
