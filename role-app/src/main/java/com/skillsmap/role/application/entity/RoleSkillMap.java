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
@Table(name="role_skill_map")
@XmlRootElement
public class RoleSkillMap {
	
    @FormParam("role_skill_map_id")
    int role_skill_map_id;
    @FormParam("role_id")
	public int role_id;
    @FormParam("skill_id")
    public int skill_id;
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
	public void setRole(Role role) {
		this.role = role;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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