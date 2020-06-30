package com.entertainmentApp.dao;

import com.entertainmentApp.domain.entertainment.Entertainment;

import java.util.List;

public interface EntertainmentDao {
    void save(Entertainment entertainment);

    void delete(Entertainment entertainment);

    void update(Entertainment entertainment);

    List<Entertainment> findAll();

    List<Entertainment> findByName(String name);

//    List<Entertainment> findByDate(Date date);

    Entertainment findById(Long id);

}
