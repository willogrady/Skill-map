package com.skillsmap.role.application.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		
	public RoleSkillMapRepository getRsmRepo() {
		return rsmRepo;
	}

	public void setRsmRepo(RoleSkillMapRepository rsmRepo) {
		this.rsmRepo = rsmRepo;
	}
	
	@GetMapping("/list")
	public Iterable<RoleSkillMap> getRoleSkillMap() {
		return getRsmRepo().findAll();
	}

	@GetMapping(path="/skillcode", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<RoleSkillMap> getRoleSkillMapViaSkill(
			@RequestParam String skillcode){
		return getRsmRepo().findBySkillCode(skillcode);

	}

	@GetMapping(path="/role_id", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody List<RoleSkillMap> getRoleSkillMapViaRole(
			@RequestParam int role_id){
		return getRsmRepo().findByRoleId(role_id);
	}

	@PostMapping("/create")
	public @ResponseBody String createRoleSkillMap(
			@RequestParam int role_skill_map_id,
			@RequestParam int role_id,
			@RequestParam String skillcode,
			@RequestParam int level,
			@RequestParam int version_id) {

		
		RoleSkillMap rsm = new RoleSkillMap();
		rsm.setRole_skill_map_id(role_skill_map_id);
		rsm.setRole_id(role_id);
		rsm.setSkillcode(skillcode);
		rsm.setLevel(level);
		rsm.setVersion_id(version_id);
		
		rsmRepo.save(rsm);
		
		return "Created and saved";
	}
}
