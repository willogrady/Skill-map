package com.skillsmap.role.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.skillsmap.role.application.entity.Role;
import com.skillsmap.role.application.entity.RoleGroup;

@Repository
@Component
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Role SET role_group_id = ?1 WHERE role_id = ?2")
	public void updateRoleGroupId(@Param("role_group_id")int role_group_id, @Param("role_id") int role_id);
	
	@Query(value="SELECT * FROM role WHERE role_group_id = ?1", nativeQuery = true)
	public List<Role> getRoleGroupId(@Param("role_group_id") int role_group_id);
	
}
