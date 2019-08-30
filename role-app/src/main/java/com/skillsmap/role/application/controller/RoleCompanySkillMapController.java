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

import com.skillsmap.role.application.entity.RoleCompanySkillMap;
import com.skillsmap.role.application.repository.RoleCompanySkillMapRepository;

@RestController
@Component
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role_company_skill_map")
public class RoleCompanySkillMapController {
	
	@Autowired
	private RoleCompanySkillMapRepository rcpRepo;

	public RoleCompanySkillMapRepository getRcpRepo() {
		return rcpRepo;
	}

	public void setRcpRepo(RoleCompanySkillMapRepository rcpRepo) {
		this.rcpRepo = rcpRepo;
	}
	
	@GetMapping("/list")
	public Iterable<RoleCompanySkillMap> getRoleCompanySkillMap() {
		return getRcpRepo().findAll();
	}
	
	@GetMapping(path="/company_skill", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<RoleCompanySkillMap> getRoleCompanySkillMapViaCompanySkill(
			@RequestParam int company_skill_id){
		return getRcpRepo().findByCompanySkill(company_skill_id);
	}
	
	@GetMapping(path="/role_id", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody List<RoleCompanySkillMap> getRoleCompanyMapViaRole(
			@RequestParam int role_id){
		return getRcpRepo().findByRoleId(role_id);
	}
	
	@PostMapping("/create")
	public @ResponseBody String createRoleCompanySkillMap(
			@RequestParam int role_skill_map_id,
			@RequestParam int role_id,
			@RequestParam int company_skill_id,
			@RequestParam int level,
			@RequestParam int version_id) {

		
		RoleCompanySkillMap rsm = new RoleCompanySkillMap();
		rsm.setRole_skill_map_id(role_skill_map_id);
		rsm.setRole_id(role_id);
		rsm.setCompany_skill_id(company_skill_id);
		rsm.setLevel(level);
		rsm.setVersion_id(version_id);
		
		rcpRepo.save(rsm);
		
		return "Created and saved";
	}
}
