package com.nashtech.rookies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.rookies.model.Role;
import com.nashtech.rookies.model.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
