package com.skillsmap.role.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillsmap.role.application.entity.RoleCompetencyMap;
import com.skillsmap.role.application.entity.RoleSkillMap;

public interface RoleCompetencyMapRepository extends JpaRepository<RoleCompetencyMap, Integer>{

	@Query(value="SELECT * FROM role_competency_skill_map WHERE role_id = ?1", nativeQuery = true)
	public List<RoleCompetencyMap> findByRoleId(@Param("role_id") int role_id);
	
	@Query(value="SELECT * FROM role_competency_skill_map WHERE competency_id = ?1", nativeQuery = true)
	public List<RoleCompetencyMap> findByCompetency(@Param("competency_id") int competency_id);
}
