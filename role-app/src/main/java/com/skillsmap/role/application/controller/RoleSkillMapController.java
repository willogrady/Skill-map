package com.skillsmap.role.application.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.dao.RoleSkillMapDAO;
import com.skillsmap.role.application.entity.Role;
import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;
import com.skillsmap.sfia.application.entity.SfiaSkillBean;

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


	@GetMapping("/id/{role_skill_map_id}")
	public RoleSkillMap getRoleMapById(@PathVariable int role_skill_map_id){
		return getRsmRepo().findById(role_skill_map_id).get();
	}

	@GetMapping("/skill_id")
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaSkill(
			@RequestParam int skill_id){
		return getRsmRepo().findBySkillId(skill_id);

	}
	
	@GetMapping("/role_id")
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaRole(
			@RequestParam int role_id){
		return getRsmRepo().findByRoleId(role_id);
	}
	
	@GetMapping(path = "/sfia", produces = MediaType.APPLICATION_JSON)
	public String getSfiaSkill() throws JSONException, IOException {
		return dao.getSfiaRequest();

	}
	
	
	
	@PostMapping("/create")
	public @ResponseBody String createRoleSkillMap(
			@RequestParam String role_title,
			@RequestParam String role_grade,
			@RequestParam int version_id,
			@RequestParam String role_summary,
			@RequestParam int role_group_id) {

		
		Role r = new Role();
		r.setRole_title(role_title);
		r.setRole_grade(role_grade);
		r.setVersion_id(version_id);
		r.setRole_summary(role_summary);
		r.setRole_group_id(role_group_id);
		
		
		
		return "Created and saved";
	}
	
	//---SFIA Related requests ---

	@GetMapping(path = "/sfia_skill", produces = MediaType.APPLICATION_JSON)
	public String getSfiaSkillviaID(@BeanParam RoleSkillMap roleSkillMap) throws JSONException, IOException {
		return dao.skillIdRequest(roleSkillMap);

	}
	
	@GetMapping(path = "/role_by_skill", produces = MediaType.APPLICATION_JSON) 
		public String getRoleviaSkill(@BeanParam RoleSkillMap roleSkillMap, 
			@RequestParam int skill_id) throws JSONException, IOException {
		
		String roleList = dao.getRoleViaSkill(roleSkillMap);
		String skillList = dao.skillIdRequest(roleSkillMap);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Skills", skillList);
		map.put("Roles", roleList);
	
		
		
		return map.toString();
	}


}
