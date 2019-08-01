package com.skillsmap.role.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleGroup {

	public int role_group_id;
	
	public String role_group;
	
	public int version_id;

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
