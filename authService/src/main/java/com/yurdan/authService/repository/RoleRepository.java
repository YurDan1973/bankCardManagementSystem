package com.yurdan.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yurdan.authService.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
