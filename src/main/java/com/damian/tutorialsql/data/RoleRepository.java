package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

