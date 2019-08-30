package com.skillsmap.role.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillsmap.role.application.entity.RoleCompanySkillMap;
import com.skillsmap.role.application.entity.RoleCompetencyMap;

public interface RoleCompanySkillMapRepository extends JpaRepository<RoleCompanySkillMap, Integer> {
	
	@Query(value="SELECT * FROM role_company_skill_map WHERE role_id = ?1", nativeQuery = true)
	public List<RoleCompanySkillMap> findByRoleId(@Param("role_id") int role_id);
	
	@Query(value="SELECT * FROM role_company_skill_map WHERE company_skill_id = ?1", nativeQuery = true)
	public List<RoleCompanySkillMap> findByCompanySkill(@Param("company_skill_id") int company_skill_id);

}
