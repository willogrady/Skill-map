package com.skillsmap.role.application.repository;

import java.sql.Array;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skillsmap.role.application.entity.RoleSkillMap;

@Repository
@Component
public interface RoleSkillMapRepository extends JpaRepository<RoleSkillMap, Integer> {
	
	@Query(value="SELECT * FROM role_skill_map WHERE skillcode = ?1", nativeQuery = true)
	public List<RoleSkillMap> findBySkillCode(@Param("skillcode") String skillcode);
	
	@Query(value="SELECT * FROM role_skill_map WHERE role_id = ?1", nativeQuery = true)
	public List<RoleSkillMap> findByRoleId(@Param("role_id") int role_id);
	
	@Query(value="SELECT skillcode FROM role_skill_map WHERE role_id = ?1", nativeQuery = true)
	public List<Object[]> findSkillsByRoleId(@Param("role_id") int role_id);


}
