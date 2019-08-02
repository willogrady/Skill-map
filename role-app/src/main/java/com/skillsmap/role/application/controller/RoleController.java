package com.skillsmap.role.application.controller;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.skillsmap.role.application.entity.Role;
import com.skillsmap.role.application.entity.RoleGroup;
import com.skillsmap.role.application.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleRepository repo;

	public RoleRepository getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(RoleRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/test")
	public String test() {
		return "heyo captain jack";
	}
	

	@GetMapping("/list")
	public Iterable<Role> getRoles() {
		return getRepo().findAll();
	}
	
	@GetMapping("/id/{role_id}")
	public Role getRoleById(@PathVariable int role_id) {
		return getRepo().findById(role_id).get();		
	}
	
	public @ResponseBody String createRole(
			@RequestParam int role_id,
			@RequestParam String role_title,
			@RequestParam String role_grade,
			@RequestParam String version_id,
			@RequestParam String role_summary,
			@RequestParam String roleGroup) {
		
		Role r = new Role();
		RoleGroup rg = new RoleGroup();
		r.setRole_id(role_id);
		r.setRole_title(role_title);
		r.setRole_grade(role_grade);
		r.setVersion_id(version_id);
		r.setRole_summary(role_summary);
		rg.setRole_group(roleGroup);
	
		
		repo.save(r);
		
		return "Created and saved";
	}
	
	@GetMapping("/rolegroup/{roleGroup}")
	public Role getRoleByGroup(@PathVariable RoleGroup roleGroup) {
		return (Role) getRepo().findByRoleGroup(roleGroup);
	}
	

	
	@PutMapping("/edit/role_group_id")
	public @ResponseBody String updateRoleGroupId(
			@RequestParam int role_group_id,
			@RequestParam int role_id) {
		getRepo().updateRoleGroupId(role_group_id,role_id);
		return "updated role_group_id";
	}
	
}
