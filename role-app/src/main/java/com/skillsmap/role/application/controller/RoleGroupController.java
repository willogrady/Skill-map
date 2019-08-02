package com.skillsmap.role.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.repository.RoleGroupRepository;

@RestController
@RequestMapping("/role_group")
public class RoleGroupController {

	@Autowired
	private RoleGroupRepository rgRepo;

	public RoleGroupRepository getRgRepo() {
		return rgRepo;
	}

	@Autowired
	public void setRgRepo(RoleGroupRepository rgRepo) {
		this.rgRepo = rgRepo;
	}
	
	
}
