package com.skillsmap.role.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.Modifying;

import com.skillsmap.role.application.entity.Role;

@Repository
@Component
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value="SELECT * FROM role WHERE role_group_id = ?1", nativeQuery = true)
	public List<Role> findRoleGroupId(@Param("role_group_id") int role_group_id);
	
	// ---- UPDATE QUERIES ----
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Role SET role_group_id = ?1 WHERE role_id = ?2")
	public void updateRoleGroupId(@Param("role_group_id")int role_group_id, @Param("role_id") int role_id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Role SET role_title = ?1 WHERE role_id = ?2")
	public void updateRoleTitle(@Param("role_title")String role_title, @Param("role_id") int role_id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Role SET role_grade = ?1 WHERE role_id = ?2")
	public void updateRoleGrade(@Param("role_grade")String role_grade, @Param("role_id") int role_id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Role SET role_summary = ?1 WHERE role_id = ?2")
	public void updateRoleSummary(@Param("role_summary")String role_summary, @Param("role_id") int role_id);
	
}
