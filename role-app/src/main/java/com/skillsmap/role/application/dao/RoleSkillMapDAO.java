package com.skillsmap.role.application.dao;

import java.io.IOException;
import java.io.Reader;

import org.json.JSONException;
import org.json.JSONObject;



public interface RoleSkillMapDAO {
	public String readAll(Reader rd);
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException;
	public JSONObject getSfiaRequest() throws IOException, JSONException;;

}
