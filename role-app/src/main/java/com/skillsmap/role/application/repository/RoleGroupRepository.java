package com.skillsmap.role.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skillsmap.role.application.entity.RoleGroup;

@Repository
@Component
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer>{

}
