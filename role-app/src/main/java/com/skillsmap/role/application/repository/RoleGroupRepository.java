package com.skillsmap.role.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.skillsmap.role.application.entity.RoleGroup;

public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer>{

}
