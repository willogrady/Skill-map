package com.skillsmap.role.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skillsmap.role.application.entity.RoleGroup;

@Repository
@Component
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer>{

	@Query(value="SELECT DISTINCT(role_group) from role_group", nativeQuery = true)
	public List<String> findGroup();
	
	@Modifying
	@Transactional
	@Query(value="UPDATE RoleGroup SET role_group = ?1, version_id = ?2 WHERE role_group_id = ?3")
	public void updateRoleGroup(@Param("role_group") String role_group,
			@Param("version_id") int version_id,
			@Param("role_group_id") int role_group_id);
}
