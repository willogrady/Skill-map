package com.skillsmap.role.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="role_company_skill_map")
@XmlRootElement
public class RoleCompanySkillMap {
	
    @FormParam("role_skill_map_id")
    int role_skill_map_id;
    @FormParam("role_id")
	public int role_id;
    @FormParam("company_skill_id")
    public int company_skill_id;
    @FormParam("level")
    int level;
    @FormParam("version_id")
    int version_id;
    
    Role role;

    @ManyToOne
    @JoinColumn(name="role_id", insertable=false, updatable=false)
	public Role getRole() {
		return role;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public void setRole(Role role) {
		this.role = role;
	}
	public int getRole_skill_map_id() {
		return role_skill_map_id;
	}
	public void setRole_skill_map_id(int role_skill_map_id) {
		this.role_skill_map_id = role_skill_map_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getCompany_skill_id() {
		return company_skill_id;
	}
	public void setCompany_skill_id(int company_skill_id) {
		this.company_skill_id = company_skill_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getVersion_id() {
		return version_id;
	}
	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}
}
