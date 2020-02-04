package com.entertainmentApp.dao;

import com.entertainmentApp.domain.Entertainment;

import java.util.List;

public interface EntertainDao {
    public void save(Entertainment entertainment);
    public void delete(Entertainment entertainment);
    public void update (Entertainment entertainment);
    public List<Entertainment> findAll();
    public List<Entertainment> findByName(String name);
    public Entertainment findById(Long id);
}
