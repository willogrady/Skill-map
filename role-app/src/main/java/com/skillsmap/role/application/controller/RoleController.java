package com.skillsmap.role.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	RoleRepository repo;

	public RoleRepository getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(RoleRepository repo) {
		this.repo = repo;
	}

	public String test() {
		return "heyo captain jack";
	}
}
