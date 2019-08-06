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
	
	// ---methods for role_by_skill---
	public String getRoleViaSkill(RoleSkillMap roleSkillMap) throws IOException;
	public String getSkillviaSkillId(RoleSkillMap roleSkillMap) throws IOException, JSONException;
	public String mapRoleWithSkillInfo(RoleSkillMap roleSkillMap) throws IOException;
	
	// ---methods for skill_by_role---
//	public String getRoleViaRoleID(RoleSkillMap roleSkillMap) throws IOException;
	public String mapSkillWithRoleInfo(RoleSkillMap roleSkillMap, int role_id) throws IOException;




}
