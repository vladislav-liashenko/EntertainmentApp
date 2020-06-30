package com.entertainmentApp.service;

import com.entertainmentApp.dao.UserDao;
import com.entertainmentApp.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Autowired
    public void setUserDao(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(final User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(final User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void update(final User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findByUsername(final String name) {
        return userDao.findByUsername(name);
    }

    @Override
    @Transactional
    public User findById(final Long id) {
        return userDao.findById(id);
    }
}
