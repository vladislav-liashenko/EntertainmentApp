package com.entertainmentApp.service;


import com.entertainmentApp.dao.CategoryDao;
import com.entertainmentApp.domain.entertainment.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CetegoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional
    public void save(final Category category) {
        categoryDao.save(category);
    }

    @Override
    @Transactional
    public void delete(final Category category) {
        categoryDao.delete(category);
    }

    @Override
    @Transactional
    public void update(final Category category) {
        categoryDao.update(category);
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    @Transactional
    public Category findByName(final String name) {
        return categoryDao.findByName(name);
    }
}
