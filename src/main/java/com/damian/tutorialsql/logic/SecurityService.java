package com.damian.tutorialsql.logic;

public interface SecurityService  {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
