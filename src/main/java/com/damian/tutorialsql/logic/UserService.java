package com.damian.tutorialsql.logic;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
