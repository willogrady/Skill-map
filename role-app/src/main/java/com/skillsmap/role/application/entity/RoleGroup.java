package com.skillsmap.role.application.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="role_group")
@XmlRootElement
public class RoleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @FormParam("role_group_id")
    public int role_group_id;
    
    @FormParam("role_group")
    public String role_group;
    
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
    @Override
    public String toString() {
        return "RoleGroup [role_group_id=" + role_group_id + ", role_group=" + role_group + "]";
    }
    
}