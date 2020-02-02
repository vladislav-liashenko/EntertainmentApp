package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;
import com.entertainmentApp.domain.User;

import java.util.List;

public interface UserDao {
        public void save(User user);
        public void delete(User user);
        public void update (User user);
        public List<Entertainment> findAll();
        public User findByUsername(String username);
}
