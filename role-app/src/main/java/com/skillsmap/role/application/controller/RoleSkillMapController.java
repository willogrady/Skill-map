package com.skillsmap.role.application.controller;


import java.io.IOException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.dao.RoleSkillMapDAO;
import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;

@RestController
@Component
@CrossOrigin(origins = "http://localhost:4200")
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

	// fetch role skill map table data via role_skill_map_id
	@GetMapping("/id/{role_skill_map_id}")
	public RoleSkillMap getRoleMapById(@PathVariable int role_skill_map_id){
		return getRsmRepo().findById(role_skill_map_id).get();
	}

	// fetch role skill map table data via skill_id
	@GetMapping("/skill_id")
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaSkill(
			@RequestParam int skill_id){
		return getRsmRepo().findBySkillId(skill_id);

	}
	
	// fetch role skill map table data via role_id
	@GetMapping(path="/role_id", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaRole(
			@RequestParam int role_id){
		return getRsmRepo().findByRoleId(role_id);
	}
	
	// fetch all sfia skills
	@GetMapping(path = "/sfia", produces = MediaType.APPLICATION_JSON)
	public String getSfiaSkill() throws JSONException, IOException {
		return dao.getSfiaRequest();

	}
	
	@PostMapping("/create")
	public @ResponseBody String createRoleSkillMap(
			@RequestParam int role_skill_map_id,
			@RequestParam int role_id,
			@RequestParam int skill_id,
			@RequestParam int level,
			@RequestParam int version_id) {

		
		RoleSkillMap rsm = new RoleSkillMap();
		rsm.setRole_skill_map_id(role_skill_map_id);
		rsm.setRole_id(role_id);
		rsm.setSkill_id(skill_id);
		rsm.setLevel(level);
		rsm.setVersion_id(version_id);
		
		rsmRepo.save(rsm);
		
		return "Created and saved";
	}
	
	//---SFIA Related requests ---
	// fetching only SFIA skill info via skill_id
	@GetMapping(path = "/sfia_skill", produces = MediaType.APPLICATION_JSON)
	public String getSfiaSkillviaID(@BeanParam RoleSkillMap roleSkillMap) throws JSONException, IOException {
		return dao.getSkillviaSkillId(roleSkillMap);

	}
	
	// fetching role and skill data via putting in skill_id and showing associated roles
	@GetMapping(path = "/role_by_skill", produces = MediaType.APPLICATION_JSON) 
	public String getRoleviaSkill(@BeanParam RoleSkillMap roleSkillMap, 
			@RequestParam int skill_id) throws JSONException, IOException {
		return dao.mapRoleWithSkillInfo(roleSkillMap);
	}
	
	// fetching role and skill data via putting in role_id and showing associated skills
	@GetMapping(path = "/skill_by_role", produces = MediaType.APPLICATION_JSON)
	public String getSkillviaRole(@BeanParam RoleSkillMap roleSkillMap,
			@RequestParam int role_id) throws IOException {
		return dao.mapSkillWithRoleInfo(roleSkillMap, role_id);
	}

}
