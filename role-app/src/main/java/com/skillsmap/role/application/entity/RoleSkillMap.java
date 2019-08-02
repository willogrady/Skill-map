package com.skillsmap.role.application.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.skillsmap.sfia.application.entity.SfiaSkillBean;

@Entity
@Table(name="role_skill_map")
@XmlRootElement
public class RoleSkillMap {
	@FormParam("role_skill_map_id")
	int role_skill_map_id;
	@FormParam("role_id")
	int role_id;
	@FormParam("skill_id")
	int skill_id;
	@FormParam("level")
	int level;
	@FormParam("version_id")
	int version_id;
	
	
	SfiaSkillBean skill;
	
	public SfiaSkillBean getSkill() {
		return skill;
	}

	public void setSkill(SfiaSkillBean skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "RoleSkillMap [role_skill_map_id=" + role_skill_map_id + ", role_id=" + role_id + ", skill_id="
				+ skill_id + ", level=" + level + ", version_id=" + version_id + "]";
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
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
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
