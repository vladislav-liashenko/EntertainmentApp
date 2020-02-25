package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void delete(User user);

    void update(User user);

    List<Entertainment> findAll();

    User findByUsername(String username);
}