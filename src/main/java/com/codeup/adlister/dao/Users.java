package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByEmail(String email);
    Long insert(User user);
    void deleteUser(Long id);
    void updateUser(User user) throws SQLException;
    User findUserById(Long id);
}
