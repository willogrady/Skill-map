package com.skillsmap.role.application.controller;


import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.dao.RoleSkillMapDAO;
import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;

@RestController
@RequestMapping("/role_skill_map")
public class RoleSkillMapController {
	
	@Autowired
	private RoleSkillMapRepository rsmRepo;
	
	@Autowired
	private RoleSkillMapDAO dao;
	
	public RoleSkillMapRepository getRsmRepo() {
		return rsmRepo;
	}

	public void setRsmRepo(RoleSkillMapRepository rsmRepo) {
		this.rsmRepo = rsmRepo;
	}
	
	@GetMapping("/test")
	public String test() {
		return "testing testing 456";
	}
	
	@GetMapping("/list")
	public Iterable<RoleSkillMap> getRoleSkillMap() {
		return getRsmRepo().findAll();
	}
	
	@GetMapping("/skill_id")
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaSkill(
			@RequestParam int skill_id){
		return getRsmRepo().findBySkillId(skill_id);
	}
	
	@GetMapping(path = "/sfia", produces = MediaType.APPLICATION_JSON)
	public String getSfiaSkill() throws JSONException, IOException {
		return dao.getSfiaRequest();

	}	
	

}
