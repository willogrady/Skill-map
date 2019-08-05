package com.skillsmap.role.application.dao;

import java.io.IOException;
import java.io.Reader;

import org.json.JSONException;
import org.json.JSONObject;



public interface RoleSkillMapDAO {
	public String readAll(Reader rd);

	
	public String readJsonFromUrl(String url) throws IOException, JSONException;
	public String getSfiaRequest() throws IOException, JSONException;


}
