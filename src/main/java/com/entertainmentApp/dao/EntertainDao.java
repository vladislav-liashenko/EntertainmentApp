package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;

import java.util.List;

public interface EntertainDao {
    void save(Entertainment entertainment);

    void delete(Entertainment entertainment);

    void update(Entertainment entertainment);

    List<Entertainment> findAll();

    List<Entertainment> findByName(String name);

    Entertainment findById(Long id);
}
