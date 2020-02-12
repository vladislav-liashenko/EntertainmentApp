package com.entertainmentApp.service;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void save(User user);
    public void delete(User user);
    public void update (User user);
    public List<Entertainment> findAll();
    public User findByUsername(String username);
}
