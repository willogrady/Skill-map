package com.skillsmap.role.application.dao;

import java.io.IOException;
import java.io.Reader;

import org.json.JSONException;
import org.json.JSONObject;

import com.skillsmap.role.application.entity.RoleSkillMap;



public interface RoleSkillMapDAO {
	public String readAll(Reader rd);
	public String readStringFromUrl(String url) throws IOException;
	public JSONObject readJsonFromUrl(String url) throws IOException, JSONException;

	public String getSfiaRequest() throws IOException, JSONException;
	public String getRoleViaSkill(RoleSkillMap roleSkillMap) throws IOException;
	public String skillIdRequest(RoleSkillMap roleSkillMap) throws IOException, JSONException;
	public String sfiaSkillIdRequest() throws IOException, JSONException;




}
