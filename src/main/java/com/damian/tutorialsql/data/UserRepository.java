package com.damian.tutorialsql.data;

import com.damian.tutorialsql.logic.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}

