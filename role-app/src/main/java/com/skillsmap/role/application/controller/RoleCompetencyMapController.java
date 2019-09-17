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

import com.skillsmap.role.application.entity.RoleCompetencyMap;
import com.skillsmap.role.application.repository.RoleCompetencyMapRepository;

@RestController
@Component
//@CrossOrigin(origins = "http://localhost:4200") 
//@CrossOrigin(origins = "https://apim-skillsmap.azure-api.net/role")
@CrossOrigin(origins = "*")
@RequestMapping("/role_competency_skill_map")
public class RoleCompetencyMapController {
	
	@Autowired
	private RoleCompetencyMapRepository rcmRepo;

	public RoleCompetencyMapRepository getRcmRepo() {
		return rcmRepo;
	}

	public void setRcmRepo(RoleCompetencyMapRepository rcmRepo) {
		this.rcmRepo = rcmRepo;
	}
	
	@GetMapping("/list")
	public Iterable<RoleCompetencyMap> getRoleSkillMap() {
		return getRcmRepo().findAll();
	}
	
	@GetMapping(path="/competency", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<RoleCompetencyMap> getRoleCompetencyMapViaCompetency(
			@RequestParam int competency_id){
		return getRcmRepo().findByCompetency(competency_id);
	}
	
	@GetMapping(path="/role_id", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody List<RoleCompetencyMap> getRoleCompetencyMapViaRole(
			@RequestParam int role_id){
		return getRcmRepo().findByRoleId(role_id);
	}
	
	@PostMapping("/create")
	public @ResponseBody String createRoleCompetencyMap(
			@RequestParam int role_skill_map_id,
			@RequestParam int role_id,
			@RequestParam int competency_id,
			@RequestParam int level,
			@RequestParam int version_id) {

		
		RoleCompetencyMap rsm = new RoleCompetencyMap();
		rsm.setRole_skill_map_id(role_skill_map_id);
		rsm.setRole_id(role_id);
		rsm.setCompetency_id(competency_id);
		rsm.setLevel(level);
		rsm.setVersion_id(version_id);
		
		rcmRepo.save(rsm);
		
		return "Created and saved";
	}

}
