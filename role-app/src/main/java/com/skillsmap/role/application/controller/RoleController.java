package com.skillsmap.role.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.skillsmap.role.application.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleRepository repo;
	
	@Autowired
	private RoleGroupRepository rgRepo;
	
	public RoleGroupRepository getRgRepo() {
		return rgRepo;
	}

	@Autowired
	public void setRgRepo(RoleGroupRepository rgRepo) {
		this.rgRepo = rgRepo;
	}

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
	public @ResponseBody Role getRoleById(
			@RequestParam int role_id) {
		return getRepo().findById(role_id).get();		
	}
	
//	@GetMapping("/rolegroup/{roleGroup}")
//	public Role getRoleByGroup(@PathVariable String roleGroup) {
//		return getRepo().findByRoleGroup(roleGroup);
//	}

	@GetMapping("/rolegroup")
	public @ResponseBody List<Role> getRoleGroupId(
			@RequestParam int role_group_id) {
		return getRepo().getRoleGroupId(role_group_id);

	}
	
	@PostMapping("/create")
	public @ResponseBody String createRole(
			@RequestParam String role_title,
			@RequestParam String role_grade,
			@RequestParam int version_id,
			@RequestParam String role_summary,
			@RequestParam int role_group_id) {

		
		Role r = new Role();
		RoleGroup rg = new RoleGroup();
		r.setRole_title(role_title);
		r.setRole_grade(role_grade);
		r.setVersion_id(version_id);
		r.setRole_summary(role_summary);
		r.setRole_group_id(role_group_id);
		
		repo.save(r);
		
		return "Created and saved";
	}
	
	@PutMapping("/edit/role_group_id")
	public @ResponseBody String updateRoleGroupId(
			@RequestParam int role_group_id,
			@RequestParam int role_id) {
		getRepo().updateRoleGroupId(role_group_id,role_id);
		return "updated role_group_id";
	}
	
	@DeleteMapping("/delete/{role_id}")
	public String deleteRole(@PathVariable int role_id) {
		getRepo().deleteById(role_id);
		return "role deleted";
		
	}
	
}
