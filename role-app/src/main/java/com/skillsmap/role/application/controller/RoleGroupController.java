package com.skillsmap.role.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsmap.role.application.entity.Role;
import com.skillsmap.role.application.entity.RoleGroup;
import com.skillsmap.role.application.repository.RoleGroupRepository;

@RestController
@Component
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/test")
	public String test() {
		return "testing testing 123";
	}
	
	@GetMapping("/list")
	public Iterable<RoleGroup> getRoleGroup() {
		return getRgRepo().findAll();
	}
	
	@GetMapping("/id")
	public @ResponseBody RoleGroup getRoleGroupById(
			@RequestParam int role_group_id) {
		return getRgRepo().findById(role_group_id).get();		
	}
	
	@PostMapping("/create")
	public @ResponseBody String createRoleGroup(
			@RequestParam String role_group,
			@RequestParam int version_id) {
		
		RoleGroup rg = new RoleGroup();
		rg.setRole_group(role_group);
		rg.setVersion_id(version_id);
		
		rgRepo.save(rg);
		
		return "Created and saved";
	}
	
	@DeleteMapping("/delete/{role_group_id}")
	public String deleteRole(@PathVariable int role_group_id) {
		getRgRepo().deleteById(role_group_id);
		return "role group deleted ";
	}
	
	@PutMapping("/edit")
	public @ResponseBody String updateRoleGroup(
			@RequestParam String role_group,
			@RequestParam int role_group_id) {
		getRgRepo().updateRoleGroup(role_group, role_group_id);
		return "updated role_group";
	}
}
