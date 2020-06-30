package com.entertainmentApp.service;

import com.entertainmentApp.domain.entertainment.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void save(Category category);

    void delete(Category category);

    void update(Category category);

    List<Category> findAll();

    Category findByName(String name);
}
