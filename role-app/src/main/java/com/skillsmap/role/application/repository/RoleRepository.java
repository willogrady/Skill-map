package com.skillsmap.role.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillsmap.role.application.entity.Role;
import com.skillsmap.role.application.entity.RoleGroup;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query(value="SELECT * FROM role WHERE role_group = ?1", nativeQuery = true)
	public List<Role> findByRoleGroup(@Param("role_group") RoleGroup roleGroup);
	
}
