package com.skillsmap.role.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsmap.role.application.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
