package com.entertainmentApp.dao;

import com.entertainmentApp.domain.user.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void delete(User user);

    void update(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);
}
