package com.skillsmap.role.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;

@RestController
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
	
	@GetMapping("/test")
	public String test() {
		return "testing testing 456";
	}
	
	@GetMapping("/list")
	public Iterable<RoleSkillMap> getRoleSkillMap() {
		return getRsmRepo().findAll();
	}
	
	

}
