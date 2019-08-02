package com.skillsmap.role.application.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity
@Table(name="roles")
public class RoleGroup {

	public int role_group_id;
	
	public String role_group;

	public int version_id;

	Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy="role_group", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "RoleGroup [role_group_id=" + role_group_id + ", role_group=" + role_group + ", version_id=" + version_id
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRole_group_id() {
		return role_group_id;
	}

	public void setRole_group_id(int role_group_id) {
		this.role_group_id = role_group_id;
	}

	public String getRole_group() {
		return role_group;
	}

	public void setRole_group(String role_group) {
		this.role_group = role_group;
	}

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}
	
	
	
}
