package com.entertainmentApp.dao;

import com.entertainmentApp.domain.entertainment.Category;

import java.util.List;

public interface CategoryDao {
    void save(Category category);

    void delete(Category category);

    void update(Category category);

    List<Category> findAll();

    Category findByName(String name);

}
