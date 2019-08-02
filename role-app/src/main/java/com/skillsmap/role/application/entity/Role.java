package com.skillsmap.role.application.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="role")
@XmlRootElement
public class Role {
	
	@FormParam("role_id")
	public int role_id;
	
	@FormParam("role_title")
	public String role_title;
	
	@FormParam("role_grade")
	public String role_grade;
	

	@FormParam("role_summary")
	public String role_summary;
	
	RoleGroup roleGroup;
	
	@ManyToOne
	@JoinColumn(name="role_group_id")
	public RoleGroup getRoleGroup() {
		return roleGroup;
	}
	
	public void setRoleGroup(RoleGroup roleGroup) {
		this.roleGroup = roleGroup;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_title=" + role_title + ", role_grade=" + role_grade
				+ ", role_summary=" + role_summary + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

	public String getRole_grade() {
		return role_grade;
	}

	public void setRole_grade(String role_grade) {
		this.role_grade = role_grade;
	}

	public String getRole_summary() {
		return role_summary;
	}

	public void setRole_summary(String role_summary) {
		this.role_summary = role_summary;
	}
	
	
	
	
	
	

}
