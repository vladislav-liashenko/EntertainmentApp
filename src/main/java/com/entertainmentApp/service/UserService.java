package com.entertainmentApp.service;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void save(User user);

    void delete(User user);

    void update(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);
}
