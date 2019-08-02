package com.skillsmap.role.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skillsmap.role.application.entity.RoleSkillMap;

@Repository
@Component
public interface RoleSkillMapRepository extends JpaRepository<RoleSkillMap, Integer> {
	
	

}
